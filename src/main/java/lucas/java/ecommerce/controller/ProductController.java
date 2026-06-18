package lucas.java.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import lucas.java.ecommerce.client.response.PlatziProductsResponse;
import lucas.java.ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private  final ProductService productService;

    @GetMapping
    public ResponseEntity<List<PlatziProductsResponse>> listarProdutos(){
        return ResponseEntity.ok(productService.listarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatziProductsResponse> listarProdutosPorId(@PathVariable Long id){
        return ResponseEntity.ok(productService.listarProdutosPorId(id));
    }

}
