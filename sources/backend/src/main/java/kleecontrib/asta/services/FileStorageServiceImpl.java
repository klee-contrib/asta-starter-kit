package kleecontrib.asta.services;

import kleecontrib.asta.configuration.properties.FileStorageProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * Implémentation du service de gestion du stockage des fichiers.
 */
@Service
public class FileStorageServiceImpl implements FileStorageService {

    private static final Logger logger = LoggerFactory.getLogger(FileStorageServiceImpl.class);

    private final Path fileStorageLocation;

    public FileStorageServiceImpl(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = fileStorageProperties.getUploadPath().toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException ex) {
            throw new FileStorageException("Impossible de créer le répertoire de stockage des fichiers.", ex);
        }
    }

    @Override
    public String storeFile(MultipartFile file, String subDirectory) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        return storeFile(file, subDirectory, fileName);
    }

    @Override
    public String storeFile(MultipartFile file, String subDirectory, String fileName) {
        try {
            // Vérifier que le nom du fichier est valide
            if (fileName.contains("..")) {
                throw new FileStorageException("Le nom du fichier contient une séquence de chemin invalide: " + fileName);
            }

            // Créer le sous-répertoire si nécessaire
            Path targetLocation = resolveAndCreateDirectory(subDirectory);

            // Copier le fichier vers la destination
            Path targetFile = targetLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetFile, StandardCopyOption.REPLACE_EXISTING);

            logger.info("Fichier stocké avec succès: {}", targetFile);
            return fileName;

        } catch (IOException ex) {
            throw new FileStorageException("Impossible de stocker le fichier " + fileName, ex);
        }
    }

    @Override
    public Resource loadFileAsResource(String subDirectory, String fileName) {
        try {
            Path filePath = getFilePath(subDirectory, fileName);
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                throw new FileStorageException("Fichier introuvable: " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new FileStorageException("Fichier introuvable: " + fileName, ex);
        }
    }

    @Override
    public boolean deleteFile(String subDirectory, String fileName) {
        try {
            Path filePath = getFilePath(subDirectory, fileName);
            return Files.deleteIfExists(filePath);
        } catch (IOException ex) {
            throw new FileStorageException("Impossible de supprimer le fichier: " + fileName, ex);
        }
    }

    @Override
    public boolean fileExists(String subDirectory, String fileName) {
        Path filePath = getFilePath(subDirectory, fileName);
        return Files.exists(filePath);
    }

    @Override
    public Path getFilePath(String subDirectory, String fileName) {
        Path subDirectoryPath = fileStorageLocation.resolve(subDirectory).normalize();
        return subDirectoryPath.resolve(fileName).normalize();
    }

    /**
     * Résout le chemin vers un sous-répertoire et le crée si nécessaire.
     *
     * @param subDirectory Sous-répertoire.
     * @return Le chemin résolu.
     * @throws IOException si le répertoire ne peut pas être créé.
     */
    private Path resolveAndCreateDirectory(String subDirectory) throws IOException {
        Path targetLocation = fileStorageLocation.resolve(subDirectory).normalize();
        Files.createDirectories(targetLocation);
        return targetLocation;
    }
}
