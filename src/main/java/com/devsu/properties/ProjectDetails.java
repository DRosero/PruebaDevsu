package com.devsu.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProjectDetails {

 @Value("${apiKey}")
 private String apiKey;

 @Value("${apyKeyValue}")
 private String apyKeyValue;

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

    public String getApyKeyValue() {
        return apyKeyValue;
    }

    public void setApyKeyValue(String apyKeyValue) {
        this.apyKeyValue = apyKeyValue;
    }

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }
}
