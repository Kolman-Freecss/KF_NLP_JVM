package org.kolmanfreecss.kf_nlp_jvm.infrastructure.rest;

import org.kolmanfreecss.kf_nlp_jvm.application.service.NlpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NlpController {

    private final NlpService nlpService;

    @Autowired
    public NlpController(final NlpService nlpService) {
        this.nlpService = nlpService;
    }

    @PostMapping("/analyze")
    public ResponseEntity<String> analyzeText(@RequestBody String text) {
        String result = nlpService.analyzeSentiment(text);
        return ResponseEntity.ok(result);
    }
}
