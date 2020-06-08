package ee.mrtnh.fortumo.controller;

import ee.mrtnh.fortumo.service.FortumoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
public class FortumoController {

    @Autowired
    FortumoService fortumoService;

    @PostMapping("/")
    public CompletableFuture<Long> fortumoControllerMethod(@RequestBody String message) {
        log.debug("Call for FortumoController -> fortumoControllerMethod");
        log.debug("Received message is " + message);
        CompletableFuture<Long> response = fortumoService.processMessage(message);
        log.debug("Sending response: " + response);
        return response;
    }
}
