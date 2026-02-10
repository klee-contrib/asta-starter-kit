package kleecontrib.asta.services;

/**
 * Exception levée lors d'une erreur de stockage de fichier.
 */
public class FileStorageException extends RuntimeException {

    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
