package tarishi.project.muzik.config;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties(prefix = "frontend")
@Validated
@Data
public class FrontEndConfig {
    @NotEmpty(message = "Front End URL cannot be empty")
    private String url = "http://localhost:3000";
}