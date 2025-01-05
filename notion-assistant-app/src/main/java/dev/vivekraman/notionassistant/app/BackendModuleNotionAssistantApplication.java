package dev.vivekraman.notionassistant.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;

@SpringBootApplication(
  scanBasePackages = "dev.vivekraman.*",
  exclude = {
    ReactiveSecurityAutoConfiguration.class,
    ReactiveUserDetailsServiceAutoConfiguration.class,
  })
public class BackendModuleNotionAssistantApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendModuleNotionAssistantApplication.class, args);
	}
}
