package org.kolmanfreecss.kf_nlp_jvm.infrastructure.adapters.output.nlp;

import org.kolmanfreecss.kf_nlp_jvm.application.service.NlpService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NlpHuggingFaceServiceImpl implements NlpService {

    private final WebClient webClient;
    
    @Value("${huggingface.api.key:default-api-key}")
    private String apiKey;

    public NlpHuggingFaceServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api-inference.huggingface.co/models/distilbert-base-uncased-finetuned-sst-2-english").build();
    }

    @Override
    public String analyzeSentiment(String text) {
        try {
            return this.webClient.post()
                    .header("Authorization", "Bearer " + apiKey)
                    .bodyValue("{\"inputs\":\"" + text + "\"}")
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (Exception e) {
            return "Error processing text: " + e.getMessage();
        }
    }
}
