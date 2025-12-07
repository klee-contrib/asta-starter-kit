package kleecontrib.asta.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"kleecontrib.asta.commands"})
public class CommandsConfiguration {
}
