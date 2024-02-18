package com.example.client.api_client;

import com.example.client.model.AccountDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

@Component
public class AccountClient {

    private RestClient accountRestClient;

    private RestClient currentAccountRestClient;

    private String baseUrl;

    public AccountClient(@Value("http://localhost:8080") String baseUrl) {
        this.baseUrl = baseUrl + "/account";
        accountRestClient = RestClient.create(this.baseUrl);
    }

    public void setCurrentAccount(Long id) {
        currentAccountRestClient = RestClient
                .builder()
                .baseUrl(baseUrl + "/dto/{id}")  // Change the order of path variables
                .defaultUriVariables(Map.of("id", id))
                .build();
    }

    public Collection<AccountDto> readAll() {
        // Update the URL to use /account/dto instead of /account
        return Arrays.asList(accountRestClient.get()
                .uri("/dto")  // Append /dto to the existing URL
                .retrieve()
                .toEntity(AccountDto[].class)
                .getBody());
    }

    public void updateAccountUser(AccountDto data) {
        // Update the URL to use /account/dto instead of /account
        currentAccountRestClient
                .put()
                .body(data)
                .retrieve()
                .toBodilessEntity();
    }

    public void create(AccountDto data){
        accountRestClient.post()
                .body(data)
                .retrieve()
                .toBodilessEntity();
    }

    public AccountDto readCurrent(){
        return currentAccountRestClient.get()
                .retrieve()
                .toEntity(AccountDto.class)
                .getBody();
    }
}
