package gg.troll.report.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({
        "${riot-api-key.properties:classpath:/riot-api-key.properties}"
})
public class PropertiesConfig {
}
