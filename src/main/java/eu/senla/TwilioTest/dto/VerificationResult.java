package eu.senla.TwilioTest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VerificationResult {

    private boolean valid;

    private String[] errors;

    public VerificationResult(String[] errors){
        this.errors = errors;
        this.valid = false;
    }

    public VerificationResult(boolean valid){
        this.errors = new String[]{};
        this.valid = valid;
    }

}
