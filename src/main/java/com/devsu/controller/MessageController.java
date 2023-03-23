package com.devsu.controller;

import com.devsu.model.MessageDevsu;
import com.devsu.properties.ProjectDetails;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import static java.util.Objects.isNull;
import javax.crypto.spec.SecretKeySpec;

@RestController
@RequestMapping("/")
public class MessageController {

    @Autowired
    ProjectDetails projectDetails;

    @PostMapping("/DevOps")
    public ResponseEntity<Object> sendMessageServer(@RequestHeader Map<String, String> headers, @RequestBody MessageDevsu messageDevsu) throws Exception {

        try {
            if(validateApiKey(headers) && validateToken(headers)){
                String result = "Hello "+ messageDevsu.getTo()+" your message will be send";
                return ResponseEntity.status(200).body(result);
            }
            else {
                return ResponseEntity.status(500).body("Error");
            }

        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }

    public String getApiKey(){
        return projectDetails.getApiKey();
    }

    public String getapiKeyValue(){
        return projectDetails.getApiKeyValue();
    }

    public String gettokenKey(){
        return projectDetails.getTokenKey();
    }

    private Boolean validateApiKey (Map<String,String> headers) throws Exception {
        //debería leerse del poperties
        String apiKey =getApiKey();//"X-Parse-REST-API-Key";
        String apiValue = getapiKeyValue();//"2f5ae96c-b558-4c7b-a590-a501ae1c3f6c";

        String apiValueRequest = headers.get(apiKey.toLowerCase(Locale.ROOT));
        //verificar que existe la cabecera
        if (isNull(apiValueRequest))
        {
            throw new Exception("Es requerido el header: "+apiKey);
        }
        //verificar que sea el valor correcto
        Boolean respuesta = apiValueRequest.equals(apiValue)?true:false;
        if (!respuesta)
        {
            throw new Exception("El valor correspondiente al header: "+apiKey+" es erróneo");
        }

        return respuesta;
    }

    private Boolean validateToken (Map<String,String> headers) throws Exception {
        Boolean response = false;
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        try {
            String headerKey = gettokenKey();//"X-JWT-KWY";
            String tokenValue = headers.get(headerKey.toLowerCase(Locale.ROOT));
            //verificar que exista el header
            if (isNull(tokenValue)) {
                throw new Exception("Es requerido el header: " + headerKey);
            }

            //Separar el token (header, payload, firma)
            String[] datosToken = tokenValue.split("\\.");
            //decodificar token
            Base64.Decoder decoder = Base64.getUrlDecoder();
            String header = new String(decoder.decode(datosToken[0]));
            String payload = new String(decoder.decode(datosToken[1]));
            String signature =new String(datosToken[2]);

            //verificar firma del token
            String tokenWithoutSignature = datosToken[0] + "." + datosToken[1];
            SecretKeySpec secretKeySpec = new SecretKeySpec(TextCodec.BASE64.decode(projectDetails.getTokenKey()),signatureAlgorithm.getJcaName());
            DefaultJwtSignatureValidator validator = new DefaultJwtSignatureValidator(signatureAlgorithm,secretKeySpec);

            if(validator.isValid(tokenWithoutSignature,signature)){
                response=true;
            }

            return response;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
