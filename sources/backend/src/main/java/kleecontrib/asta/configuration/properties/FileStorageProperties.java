package kleecontrib.asta.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.file.Path;
import java.nio.file.Paths;

@ConfigurationProperties("file-storage")
public record FileStorageProperties(
        String uploadDir) {

    public FileStorageProperties {
        if (uploadDir == null || uploadDir.isEmpty()) {
            uploadDir = "uploads";
        }
    }

    public Path getUploadPath() {
        return Paths.get(uploadDir);
    }
}
