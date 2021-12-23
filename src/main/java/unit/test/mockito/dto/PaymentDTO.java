package unit.test.mockito.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO {

    private String creditCardNo;
    private String validDate;
    private String cvv;
    private BigDecimal amount;

}
