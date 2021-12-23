package unit.test.mockito.service;

import unit.test.mockito.request.CheckoutRequest;
import unit.test.mockito.response.CheckoutResponse;
import unit.test.mockito.response.OrderResponse;
import unit.test.mockito.response.PaymentResponse;

public class CheckoutService {

    private OrderService orderService = new OrderService();
    private PaymentService paymentService = new PaymentService();

    public CheckoutResponse completeTransaction(CheckoutRequest request) {

        PaymentResponse paymentResponse = paymentService.makePayment(request.getPaymentDTO());
        if (!Boolean.TRUE.equals(paymentResponse.getIsSuccess())) {
            return new CheckoutResponse(Boolean.FALSE, "payment error.");
        }

        OrderResponse orderResponse = orderService.createOrder(request.getOrderDTO());
        if (!Boolean.TRUE.equals(orderResponse.getIsSuccess())) {
            return new CheckoutResponse(Boolean.FALSE, "create order error.");
        }

        return new CheckoutResponse(Boolean.TRUE, null);
    }

}
