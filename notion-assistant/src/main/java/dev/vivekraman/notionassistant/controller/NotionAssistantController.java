package dev.vivekraman.notionassistant.controller;

import dev.vivekraman.notionassistant.config.Constants;
import dev.vivekraman.notionassistant.model.Expense;
import dev.vivekraman.notionassistant.service.AssistantService;
import dev.vivekraman.monolith.annotation.MonolithController;
import dev.vivekraman.monolith.model.Response;
import lombok.RequiredArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@MonolithController(moduleName = Constants.MODULE_NAME)
@RequiredArgsConstructor
public class NotionAssistantController {
  private final AssistantService assistantService;
  private final Scheduler scheduler;

  @PostMapping("/echo")
  public Mono<Response<LinkedHashMap<String, Object>>> echo(@RequestBody LinkedHashMap<String, Object> body) {
    return Mono.just(Response.of(body))
      .subscribeOn(scheduler);
  }

  @PostMapping(path = "/expense")
  @PreAuthorize("hasAuthority('notion_assistant')")
  public Mono<Response<Map>> persistExpense(@RequestBody Expense expense) {
    return assistantService.persistExpense(expense)
      .map(Response::of)
      .subscribeOn(scheduler);
  }
}
