package org.kolmanfreecss.kf_nlp_jvm.infrastructure.rest;

import com.fasterxml.jackson.databind.JsonNode;
import org.kolmanfreecss.kf_nlp_jvm.application.service.NlpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class NlpController {

    private final NlpService nlpService;

    @Autowired
    public NlpController(final NlpService nlpService) {
        this.nlpService = nlpService;
    }

    @PostMapping("/analyze")
    public Mono<String> analyzeText(@RequestBody String text) {
        return nlpService.analyzeSentiment(text);
    }
    
    @GetMapping("/detectOffensiveLanguage")
    public Mono<String> detectOffensiveLanguage(@RequestParam String text) {
        return nlpService.detectOffensiveLanguage(text);
    }
    
    @GetMapping("/getAnswer")
    public Mono<JsonNode> getAnswer(@RequestParam String context, @RequestParam String question) {
        return nlpService.getAnswer(context, question);
    }
}
