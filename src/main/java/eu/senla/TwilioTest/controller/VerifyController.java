package eu.senla.TwilioTest.controller;

import eu.senla.TwilioTest.dto.VerificationResult;
import eu.senla.TwilioTest.service.VerificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verification")
@RequiredArgsConstructor
public class VerifyController {

    private final VerificationService service;

    @PostMapping("/start")
    public ResponseEntity<String> startVerification(@RequestParam String phone, @RequestParam String channel){
        service.startVerification(phone, channel);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/check")
    public VerificationResult checkVerification(@RequestParam String phone, @RequestParam String code){
        return service.checkVerification(phone, code);
    }

}
