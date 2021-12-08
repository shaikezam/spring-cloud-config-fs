package spring.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@EventListener
	public void onApplicationEvent(RefreshRemoteApplicationEvent event) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject("http://localhost:50001/actuator/busrefresh", new Object(), String.class);
		System.out.println(event);
	}

}
