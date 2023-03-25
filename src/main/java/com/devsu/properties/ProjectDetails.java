package com.devsu.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProjectDetails {

    /**Clase para obtener los valores de apikey, value, y tokenkey del archivo application.properties*/

 @Value("${apiKey}")
 private String apiKey;
 @Value("${apiKeyValue}")
 private String apiKeyValue;
 @Value("${tokenKey}")
 private String tokenKey;

    public ProjectDetails() {
    }
    public String getApiKey() {
        return apiKey;
    }
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    public String getApiKeyValue() {
        return apiKeyValue;
    }

    public void setApiKeyValue(String apiKeyValue) {
        this.apiKeyValue = apiKeyValue;
    }
}
