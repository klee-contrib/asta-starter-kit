package kleecontrib.asta.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

/**
 * Service de gestion du stockage des fichiers.
 */
public interface FileStorageService {

    /**
     * Stocke un fichier dans un répertoire spécifique.
     *
     * @param file Fichier à stocker.
     * @param subDirectory Sous-répertoire de destination (ex: "utilisateurs/123").
     * @return Le nom du fichier stocké.
     * @throws FileStorageException si une erreur survient lors du stockage.
     */
    String storeFile(MultipartFile file, String subDirectory);

    /**
     * Stocke un fichier dans un répertoire spécifique avec un nom personnalisé.
     *
     * @param file Fichier à stocker.
     * @param subDirectory Sous-répertoire de destination (ex: "utilisateurs/123").
     * @param fileName Nom du fichier à utiliser.
     * @return Le nom du fichier stocké.
     * @throws FileStorageException si une erreur survient lors du stockage.
     */
    String storeFile(MultipartFile file, String subDirectory, String fileName);

    /**
     * Charge un fichier en tant que Resource.
     *
     * @param subDirectory Sous-répertoire source (ex: "utilisateurs/123").
     * @param fileName Nom du fichier.
     * @return Le fichier en tant que Resource.
     * @throws FileStorageException si le fichier n'existe pas ou ne peut pas être lu.
     */
    Resource loadFileAsResource(String subDirectory, String fileName);

    /**
     * Supprime un fichier.
     *
     * @param subDirectory Sous-répertoire source (ex: "utilisateurs/123").
     * @param fileName Nom du fichier.
     * @return true si le fichier a été supprimé, false s'il n'existait pas.
     * @throws FileStorageException si une erreur survient lors de la suppression.
     */
    boolean deleteFile(String subDirectory, String fileName);

    /**
     * Vérifie si un fichier existe.
     *
     * @param subDirectory Sous-répertoire source (ex: "utilisateurs/123").
     * @param fileName Nom du fichier.
     * @return true si le fichier existe, false sinon.
     */
    boolean fileExists(String subDirectory, String fileName);

    /**
     * Retourne le chemin complet vers un fichier.
     *
     * @param subDirectory Sous-répertoire source (ex: "utilisateurs/123").
     * @param fileName Nom du fichier.
     * @return Le chemin complet vers le fichier.
     */
    Path getFilePath(String subDirectory, String fileName);
}
