package com.tallninja.springopenapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "App Controller", description = "REST Controller for the application")
@RestController
public class AppController {

    @Operation(
            summary = "Root route",
            description = "description"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    @RequestMapping("/")
    public ResponseEntity<Map<String, String>> echo(@RequestParam String message) {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("message", message);
        return ResponseEntity.ok(responseBody);
    }
}
