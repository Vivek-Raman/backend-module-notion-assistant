package dev.vivekraman.notionassistant.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import dev.vivekraman.notionassistant.client.NotionAPI;
import dev.vivekraman.notionassistant.config.NotionProperties;
import dev.vivekraman.notionassistant.model.Expense;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AssistantService {
  private final NotionAPI notionAPI;
  private final NotionProperties databaseProperties;

  public Mono<Map> persistExpense(Expense expense) {
    // return notionAPI.fetchDatabaseMetadata(databaseProperties.getDatabaseIDs().getExpenses());
    return notionAPI.addExpense(databaseProperties.getDatabaseIDs().getExpenses(), expense);
  }
}
