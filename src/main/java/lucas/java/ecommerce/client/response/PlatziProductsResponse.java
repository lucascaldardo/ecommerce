package lucas.java.ecommerce.client.response;

import java.math.BigDecimal;

public record PlatziProductsResponse(Long id, String title, BigDecimal price) {
}
