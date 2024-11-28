package com.ains.groupit.calculateme.controller;

import com.ains.groupit.calculateme.dto.request.ConcreteStrengthCalculationRequestDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/concrete-strength")
public class ConcreteStrengthCalculationController {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${flask.server.url}")
    private String flaskServerUrl;

    @PostMapping("/predict")
    public ResponseEntity<String> predictConcreteStrength(@RequestBody ConcreteStrengthCalculationRequestDTO requestDTO) {
        try {
            String flaskUrl = flaskServerUrl + "/";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            String requestBody = String.format(
                    "inputs=%s %s %s %s %s %s %s %s",
                    requestDTO.getAsh(), requestDTO.getWater(), requestDTO.getSuperplasticizer(),
                    requestDTO.getCoarseAggregate(), requestDTO.getFineAggregate(),
                    requestDTO.getCement(), requestDTO.getAge(), requestDTO.getStrength()
            );

            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<String> response = restTemplate.exchange(flaskUrl, HttpMethod.POST, entity, String.class);

            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            return new ResponseEntity<>("Error while calling Flask backend: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/get-data")
    public ResponseEntity<String> getSavedData() {
        try {
            String flaskUrl = flaskServerUrl + "/get-data";

            ResponseEntity<String> response = restTemplate.exchange(flaskUrl, HttpMethod.GET, null, String.class);

            return new ResponseEntity<>(response.getBody(), response.getStatusCode());
        } catch (Exception e) {
            return new ResponseEntity<>("Error while calling Flask backend: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
