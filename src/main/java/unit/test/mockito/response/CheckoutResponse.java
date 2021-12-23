package unit.test.mockito.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CheckoutResponse {
    private Boolean success;
    private String errorMessage;
}
