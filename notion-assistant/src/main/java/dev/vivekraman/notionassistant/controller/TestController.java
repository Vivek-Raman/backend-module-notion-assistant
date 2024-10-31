package dev.vivekraman.notionassistant.controller;

import dev.vivekraman.notionassistant.config.Constants;
import dev.vivekraman.monolith.annotation.MonolithController;
import dev.vivekraman.monolith.model.Response;
import lombok.RequiredArgsConstructor;

import java.util.LinkedHashMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

@MonolithController(moduleName = Constants.MODULE_NAME)
@RequiredArgsConstructor
public class TestController {
  private final Scheduler scheduler;

  @PostMapping
  public Mono<Response<LinkedHashMap<String, Object>>> echo(@RequestBody LinkedHashMap<String, Object> body) {
    return Mono.just(Response.of(body))
        .subscribeOn(scheduler);
  }
}
