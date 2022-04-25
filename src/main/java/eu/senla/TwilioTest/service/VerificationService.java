package eu.senla.TwilioTest.service;

import eu.senla.TwilioTest.dto.VerificationResult;

public interface VerificationService {

    void startVerification(String phone, String channel);

    VerificationResult checkVerification(String phone, String code);

}
