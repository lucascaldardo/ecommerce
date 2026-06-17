package lucas.java.ecommerce.service;

import lucas.java.ecommerce.client.PlatziStoreClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ProductService {

    private final PlatziStoreClient platziStoreClient;

    @GetMapping("/products")
    public List<PlatziStoreClient> listarProdutos(){
        return platziStoreClient.getAllProducts();
    }

    public void listarProdutosPorId(){

    }

}
