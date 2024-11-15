package dev.vivekraman.notionassistant.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class NotionAssistantConfig {
  @Bean
  public GroupedOpenApi notionAssistantApiGroup() {
    return GroupedOpenApi.builder()
        .group(Constants.MODULE_NAME)
        .packagesToScan("dev.vivekraman.notionassistant.controller")
        .build();
  }

  @Bean
  public WebClient notionWebClient(NotionProperties notionProperties) {
    return WebClient.builder()
        .baseUrl(notionProperties.getBaseURL())
        .defaultHeader("Notion-Version", notionProperties.getApiVersion())
        .defaultHeader("Authorization", "Bearer " + notionProperties.getApiKey())
        .build();
  }
}
