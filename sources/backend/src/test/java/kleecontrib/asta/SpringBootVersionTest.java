package kleecontrib.asta;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootVersion;

import static org.assertj.core.api.Assertions.assertThat;

class SpringBootVersionTest {

    @Test
    void usesSpringBoot41() {
        assertThat(SpringBootVersion.getVersion()).startsWith("4.1.");
    }
}
