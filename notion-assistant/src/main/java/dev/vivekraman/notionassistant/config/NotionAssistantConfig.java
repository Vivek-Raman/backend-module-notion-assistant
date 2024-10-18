package dev.vivekraman.notionassistant.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotionAssistantConfig {
  @Bean
  public GroupedOpenApi notionAssistantApiGroup() {
    return GroupedOpenApi.builder()
        .group(Constants.MODULE_NAME)
        .packagesToScan("dev.vivekraman.notionassistant.controller")
        .build();
  }
}
