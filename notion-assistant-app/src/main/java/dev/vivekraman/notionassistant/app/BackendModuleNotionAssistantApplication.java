package dev.vivekraman.notionassistant.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "dev.vivekraman.*")
public class BackendModuleNotionAssistantApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackendModuleNotionAssistantApplication.class, args);
	}
}
