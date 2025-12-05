package kleecontrib.asta.main;

import kleecontrib.asta.configuration.AppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({AppConfiguration.class})
public class AstaMainApplication {

    static void main(String[] args) {
        SpringApplication.run(AstaMainApplication.class, args);
    }
}
