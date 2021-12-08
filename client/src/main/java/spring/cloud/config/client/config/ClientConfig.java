package spring.cloud.config.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties
@RefreshScope
public class ClientConfig {
}
