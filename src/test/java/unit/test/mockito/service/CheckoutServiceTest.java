package unit.test.mockito.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import unit.test.mockito.dto.OrderDTO;
import unit.test.mockito.dto.PaymentDTO;
import unit.test.mockito.request.CheckoutRequest;
import unit.test.mockito.response.CheckoutResponse;
import unit.test.mockito.response.OrderResponse;
import unit.test.mockito.response.PaymentResponse;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutServiceTest extends TestCase {

    @InjectMocks
    private CheckoutService checkoutService;

    @Mock
    private PaymentService paymentService;

    @Mock
    private OrderService orderService;

    @Test
    public void shouldNotMakePaymentWhenHasPaymentError() {
        PaymentDTO paymentDTO = new PaymentDTO();
        OrderDTO orderDTO = new OrderDTO();

        CheckoutRequest checkoutRequest = CheckoutRequest.builder().paymentDTO(paymentDTO).orderDTO(orderDTO).build();

        when(paymentService.makePayment(paymentDTO)).thenReturn(new PaymentResponse(Boolean.FALSE));

        CheckoutResponse checkoutResponse = checkoutService.completeTransaction(checkoutRequest);

        assertFalse(checkoutResponse.getSuccess());
        assertEquals("payment error.", checkoutResponse.getErrorMessage());

    }

    @Test
    public void shouldNotMakePaymentWhenHasErrorOnCreateOrder() {
        PaymentDTO paymentDTO = new PaymentDTO();
        OrderDTO orderDTO = new OrderDTO();

        CheckoutRequest checkoutRequest = CheckoutRequest.builder().paymentDTO(paymentDTO).orderDTO(orderDTO).build();

        when(paymentService.makePayment(paymentDTO)).thenReturn(new PaymentResponse(Boolean.TRUE));
        when(orderService.createOrder(orderDTO)).thenReturn(new OrderResponse(Boolean.FALSE));

        CheckoutResponse checkoutResponse = checkoutService.completeTransaction(checkoutRequest);

        assertFalse(checkoutResponse.getSuccess());
        assertEquals("create order error.", checkoutResponse.getErrorMessage());

    }

    @Test
    public void shouldMakePayment() {
        PaymentDTO paymentDTO = new PaymentDTO();
        OrderDTO orderDTO = new OrderDTO();

        CheckoutRequest checkoutRequest = CheckoutRequest.builder().paymentDTO(paymentDTO).orderDTO(orderDTO).build();

        when(paymentService.makePayment(paymentDTO)).thenReturn(new PaymentResponse(Boolean.TRUE));
        when(orderService.createOrder(orderDTO)).thenReturn(new OrderResponse(Boolean.TRUE));

        CheckoutResponse checkoutResponse = checkoutService.completeTransaction(checkoutRequest);

        assertTrue(checkoutResponse.getSuccess());
        assertNull(checkoutResponse.getErrorMessage());

    }

}