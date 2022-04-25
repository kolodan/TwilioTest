package eu.senla.TwilioTest.service;

import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import eu.senla.TwilioTest.configuration.TwilioConfiguration;
import eu.senla.TwilioTest.dto.VerificationResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TwilioVerificationService implements VerificationService {

    private final TwilioConfiguration twilioConf;

    /**
     * @param to The phone number or email to verify
     * @param channel The verification method to use (sms, email or other)
     */
    @Override
    public void startVerification(String to, String channel) {
        String phone = "+" + to;
        Verification.creator(twilioConf.getVerificationSid(), phone, channel).create();
    }

    /**
     * @param to The phone number or email to verify
     * @param code The verification string
     */
    @Override
    public VerificationResult checkVerification(String to, String code) {
        String phone = "+" + to;

        VerificationCheck verification =
                VerificationCheck.creator(twilioConf.getVerificationSid(), code).setTo(phone).create();

        if ("approved".equals(verification.getStatus())) {
            return new VerificationResult(verification.getValid());
        } else {
            return new VerificationResult(new String[]{"Invalid code"});
        }
    }
}
