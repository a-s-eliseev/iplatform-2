package space.eliseev.iplatform.error;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ShowPrintException extends RuntimeException {

    public ShowPrintException(String message) {
        super(message);
    }
}
