package sudobito.rehabilitation.mvc_start;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configurable
public class ServletApplication {
    @Bean
    SpringMemberFormControllerV1 springMemberFormControllerV1() {
        return new SpringMemberFormControllerV1();
    }
}
