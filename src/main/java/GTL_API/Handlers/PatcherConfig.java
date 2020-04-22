package GTL_API.Handlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PatcherConfig {

    @Bean
    public PatcherHandler patcherHandler() {
        return new PatcherHandler();
    }

}
