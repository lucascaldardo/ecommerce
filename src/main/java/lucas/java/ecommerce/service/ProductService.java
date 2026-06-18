package lucas.java.ecommerce.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lucas.java.ecommerce.client.PlatziStoreClient;
import lucas.java.ecommerce.client.response.PlatziProductsResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final PlatziStoreClient platziStoreClient;

    @Cacheable(value = "products")
    public List<PlatziProductsResponse> listarProdutos(){
        log.info("Coletando todos os produtos");
        return platziStoreClient.getAllProducts();
    }

    @Cacheable(value = "products", key = "#productId")
    public PlatziProductsResponse listarProdutosPorId(Long productId){
        log.info("Coletando o produto de id: {}", productId);
        return platziStoreClient.getProductsById(productId);
    }

}
