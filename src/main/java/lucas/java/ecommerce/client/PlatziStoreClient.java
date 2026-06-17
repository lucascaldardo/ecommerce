package lucas.java.ecommerce.client;

import lucas.java.ecommerce.client.response.PlatziProductsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@FeignClient(name = "PlatziStoreClient", url = "${basket.client.platzi}")
public interface PlatziStoreClient {

    @GetMapping("/products")
    List<PlatziProductsResponse> getAllProducts();

    @GetMapping("/products/{id}")
    PlatziProductsResponse getProductsById(@PathVariable Long id);

}
