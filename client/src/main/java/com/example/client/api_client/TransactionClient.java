package com.example.client.api_client;

import com.example.client.model.AccountDto;
import com.example.client.model.TransactionDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

@Component
public class TransactionClient {

    private RestClient accountRestClient;

    private RestClient currentAccountRestClient;

    private String baseUrl;

    public TransactionClient(@Value("http://localhost:8080") String baseUrl) {
        this.baseUrl = baseUrl + "/transaction";
        accountRestClient = RestClient.create(this.baseUrl);
    }

    public void setCurrentAccount(Long id){
        currentAccountRestClient = RestClient
                .builder()
                .baseUrl(baseUrl + "/{id}")
                .defaultUriVariables(Map.of("id", id))
                .build();
    }
    public void updateAccountUser(TransactionDto data){
        currentAccountRestClient
                .put()
                .body(data)
                .retrieve()
                .toBodilessEntity();
    }

    public Collection<TransactionDto> readAll(){
        // Update the URL to use /transaction/dto instead of /transaction
        return Arrays.asList(accountRestClient.get()
                .uri("/dto")  // Append /dto to the existing URL
                .retrieve()
                .toEntity(TransactionDto[].class)
                .getBody());
    }

    public void create(TransactionDto data) {
        // Update the URL to use /transaction/dto instead of /transaction
        accountRestClient.post()
                .uri("/dto")  // Append /dto to the existing URL
                .body(data)
                .retrieve()
                .toBodilessEntity();
    }

    public TransactionDto readCurrent(){
        return currentAccountRestClient.get()
                .retrieve()
                .toEntity(TransactionDto.class)
                .getBody();
    }
}
