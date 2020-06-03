package ee.mrtnh.fortumo.controller;

import ee.mrtnh.fortumo.service.FortumoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FortumoController {

    @PostMapping("/")
    public Long fortumoControllerMethod(@RequestBody String message) {
        log.info("Call for Fortumo controller"); // TODO: change to debug
        log.info("Received message is " + message);
        Long response = null;
        FortumoService fortumoService = new FortumoService();
        response = fortumoService.processMessage(message);
        // TODO: how to hold sending response until specific message is received (possibly in other thread)?
        log.info("Sending response: " + response);
        return response;
    }
}
