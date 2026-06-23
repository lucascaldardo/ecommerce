package lucas.java.ecommerce.controller.request;

import lombok.Getter;
import lombok.Setter;
import lucas.java.ecommerce.entity.PaymentMethod;

@Getter
@Setter
public class PaymentRequest {
    private PaymentMethod paymentMethod;
}
