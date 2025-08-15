package online.codemize.gestaocondominio.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "online.codemize.gestaocondominio.client")
public class AppConfig {
}
