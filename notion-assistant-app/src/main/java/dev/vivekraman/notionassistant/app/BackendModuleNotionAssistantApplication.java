package dev.vivekraman.notionassistant.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(scanBasePackages = "dev.vivekraman.*")
@ConfigurationPropertiesScan(basePackages = "dev.vivekraman.notionassistant.config")
public class BackendModuleNotionAssistantApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendModuleNotionAssistantApplication.class, args);
	}
}
