package lucas.java.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import lucas.java.ecommerce.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private  final ProductService productService;

    @GetMapping
    public ResponseEntity<Void> listarProdutos(){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> listarProdutosPorId(@PathVariable Long id){

        return ResponseEntity.ok().build();
    }

}
