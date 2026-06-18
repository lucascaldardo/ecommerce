package lucas.java.ecommerce.client.response;

import java.io.Serializable;
import java.math.BigDecimal;

public record PlatziProductsResponse(Long id, String title, BigDecimal price) implements Serializable {
}
