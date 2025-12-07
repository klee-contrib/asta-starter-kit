package kleecontrib.asta.configuration;

import kleecontrib.asta.configuration.web.WebConfiguration;
import org.springframework.context.annotation.Import;

@Import({
        JpaConfiguration.class,
        SecurityConfiguration.class,
        WebConfiguration.class,
        QueriesConfiguration.class,
        CommandsConfiguration.class,
        MutationsConfiguration.class
})
public class AppConfiguration {
}
