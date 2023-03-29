package im.rubric.codetest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
public class InitConfig {
    private final DataInitializer dataInitializer;

    @PostConstruct
    public void initializeData() {
        dataInitializer.initialize();
    }
}
