package dev.vivekraman.notionassistant.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = Constants.MODULE_NAME)
@Data
public class NotionProperties {
  private String baseURL;
  private String apiKey;
  private String apiVersion;

  private DatabaseID databaseIDs;

  @Data
  public static class DatabaseID {
    private String expenses;
  }
}
