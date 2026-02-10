package kleecontrib.asta.configuration;

import kleecontrib.asta.configuration.properties.FileStorageProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("kleecontrib.asta.services")
@EnableConfigurationProperties(FileStorageProperties.class)
public class ServicesConfiguration {
}
