package org.kolmanfreecss.kf_nlp_jvm.infrastructure.adapters.output.nlp;

import com.fasterxml.jackson.databind.JsonNode;
import org.kolmanfreecss.kf_nlp_jvm.application.service.NlpService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class NlpHuggingFaceServiceImpl implements NlpService {

    private WebClient webClient;
    
    private final WebClient.Builder webClientBuilder;
    
    @Value("${huggingface.api.key:default-api-key}")
    private String apiKey;
    
    private static final String API_SENTIMENT_MODEL = "https://api-inference.huggingface.co/models/distilbert-base-uncased-finetuned-sst-2-english";
    private static final String API_ANSWER_MODEL = "https://api-inference.huggingface.co/models/deepset/roberta-base-squad2";
    
    public NlpHuggingFaceServiceImpl(WebClient.Builder webClientBuilder) {
        // For test purposes we will use different models in this same service.
//        this.webClient = webClientBuilder.baseUrl("https://api-inference.huggingface.co/models/distilbert-base-uncased-finetuned-sst-2-english").build();
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public Mono<String> analyzeSentiment(String text) {
        try {
            this.webClient = webClientBuilder.baseUrl(API_SENTIMENT_MODEL).build();
            return this.webClient.post()
                    .header("Authorization", "Bearer " + apiKey)
                    .bodyValue("{\"inputs\":\"" + text + "\"}")
                    .retrieve()
                    .bodyToMono(String.class);
        } catch (Exception e) {
            return Mono.error(e);
        }
    }
    
    @Override
    public Mono<String> detectOffensiveLanguage(String text) {
        try {
            this.webClient = webClientBuilder.baseUrl(API_SENTIMENT_MODEL).build();
            return this.webClient.post()
                    .header("Authorization", "Bearer " + apiKey)
                    .bodyValue("{\"inputs\":\"" + text + "\"}")
                    .retrieve()
                    .bodyToMono(String.class);
        } catch (Exception e) {
            return Mono.error(e);
        }
    }
    
    @Override
    public Mono<JsonNode> getAnswer(String context, String question) {
        try {
            this.webClient = webClientBuilder.baseUrl(API_ANSWER_MODEL).build();
            return this.webClient.post()
                    .header("Authorization", "Bearer " + apiKey)
                    .bodyValue("{\"question\":\"" + question + "\",\"context\":\"" + context + "\"}")
                    .retrieve()
                    .bodyToMono(JsonNode.class);
        } catch (Exception e) {
            return Mono.error(e);
        }
    }
}
