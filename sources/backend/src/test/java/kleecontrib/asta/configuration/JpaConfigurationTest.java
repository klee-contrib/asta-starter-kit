package kleecontrib.asta.configuration;

import jakarta.persistence.EntityManagerFactory;
import kleecontrib.asta.configuration.properties.AuthenticationProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.boot.security.autoconfigure.SecurityProperties;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.cors.CorsConfigurationSource;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class JpaConfigurationTest {

    @Test
    void transactionManagerWrapsEntityManagerFactory() {
        EntityManagerFactory emf = mock(EntityManagerFactory.class);
        JpaConfiguration configuration = new JpaConfiguration();

        PlatformTransactionManager transactionManager = configuration.transactionManager(emf);

        assertThat(transactionManager).isInstanceOf(JpaTransactionManager.class);
        assertThat(((JpaTransactionManager) transactionManager).getEntityManagerFactory()).isSameAs(emf);
    }

    @Test
    void entityScanUsesSpringBoot41Package() {
        assertThat(JpaConfiguration.class.getAnnotation(EntityScan.class)).isNotNull();
        assertThat(EntityScan.class.getPackageName())
                .isEqualTo("org.springframework.boot.persistence.autoconfigure");
    }
}
