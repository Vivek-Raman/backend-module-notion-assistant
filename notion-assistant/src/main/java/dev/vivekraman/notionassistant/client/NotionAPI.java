package dev.vivekraman.notionassistant.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NotionAPI {
  @Value("${notion-assistant.api-key:}")
  private String apiKey;
}
