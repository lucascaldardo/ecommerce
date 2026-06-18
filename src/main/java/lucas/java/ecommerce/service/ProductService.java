package lucas.java.ecommerce.service;

import lombok.RequiredArgsConstructor;
import lucas.java.ecommerce.client.PlatziStoreClient;
import lucas.java.ecommerce.client.response.PlatziProductsResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final PlatziStoreClient platziStoreClient;

    @GetMapping("/products")
    public List<PlatziProductsResponse> listarProdutos(){
        return platziStoreClient.getAllProducts();
    }

    public PlatziProductsResponse listarProdutosPorId(Long id){
        return platziStoreClient.getProductsById(id);
    }

}
