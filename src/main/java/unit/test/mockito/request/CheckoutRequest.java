package unit.test.mockito.request;

import lombok.Builder;
import lombok.Data;
import unit.test.mockito.dto.OrderDTO;
import unit.test.mockito.dto.PaymentDTO;

@Data
@Builder
public class CheckoutRequest {

    private OrderDTO orderDTO;
    private PaymentDTO paymentDTO;
}
