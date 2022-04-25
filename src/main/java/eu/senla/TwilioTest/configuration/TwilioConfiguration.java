package eu.senla.TwilioTest.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("twilio")
public class TwilioConfiguration {

    private String accountSid;

    private String authToken;

    private String phone;

    private String verificationSid;
}
