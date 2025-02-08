package tarishi.project.muzik.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "frontend")
@Validated
@Data
public class FrontEndConfig {
    @NotEmpty(message = "Front End URL cannot be empty")
    private String url;
}