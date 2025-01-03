package com.maybank.assessment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
@RestController
@RequestMapping("/api/external")
public class ExternalController {

    private static final String EXTERNAL_URL = "https://official-joke-api.appspot.com/random_joke";

    @GetMapping
    public ResponseEntity<String> fetchJoke() {
        log.info("Calling third-party API: {}", EXTERNAL_URL);
        try {
            // Create a URL object
            URL url = new URL(EXTERNAL_URL);

            // Open an HTTP connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            log.info("Response Code: {}", responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Log and return the response
                log.info("Received response: {}", response);
                return ResponseEntity.ok(response.toString());
            } else {
                log.error("Failed to fetch data. Response Code: {}", responseCode);
                return ResponseEntity.status(responseCode).body("Failed to fetch data from third-party API");
            }
        } catch (Exception ex) {
            log.error("Error occurred while calling third-party API", ex);
            return ResponseEntity.status(500).body("Internal Server Error");
        }
    }
}