package org.kolmanfreecss.kf_nlp_jvm.application.service;

import com.fasterxml.jackson.databind.JsonNode;
import reactor.core.publisher.Mono;

/**
 * @version 1.0
 * @uthor Kolman-Freecss
 */
public interface NlpService {
    
    Mono<String> analyzeSentiment(final String text);
    Mono<String> detectOffensiveLanguage(final String text);
    Mono<JsonNode> getAnswer(final String context, final String question);
    
}
