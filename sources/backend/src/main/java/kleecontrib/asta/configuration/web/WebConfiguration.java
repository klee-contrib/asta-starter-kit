package kleecontrib.asta.configuration.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"kleecontrib.asta.api", "kleecontrib.asta.configuration.web"})
public class WebConfiguration {

}
