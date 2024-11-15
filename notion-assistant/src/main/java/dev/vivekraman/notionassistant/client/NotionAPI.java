package dev.vivekraman.notionassistant.client;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import dev.vivekraman.notionassistant.model.Expense;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class NotionAPI {
  private final WebClient notionWebClient;

  public Mono<Map> fetchDatabaseMetadata(String databaseID) {
    return notionWebClient.get().uri("/databases/{databaseID}", databaseID)
        .retrieve()
        .bodyToMono(Map.class);
  }

  public Mono<Map> addExpense(String databaseID, Expense expense) {
    return notionWebClient.post().uri("/pages")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(Map.of(
          "parent", Map.of(
            "database_id", databaseID
          ),
          "properties", Map.of(
            "Summary", Map.of(
              "title", List.of(
                Map.of("text", Map.of(
                  "content", expense.getSummary()
                ))
              )
            ),
            "Date", Map.of(
              "date", Map.of(
                "start", expense.getDate().toInstant().toString()
              )
            ),
            "Amount", Map.of(
              "number", expense.getAmount()
            )
          )
        )).retrieve()
        .bodyToMono(Map.class);
  }
}
