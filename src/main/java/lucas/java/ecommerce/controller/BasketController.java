package lucas.java.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import lucas.java.ecommerce.client.request.BasketRequest;
import lucas.java.ecommerce.controller.request.PaymentRequest;
import lucas.java.ecommerce.entity.Basket;
import lucas.java.ecommerce.service.BasketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @GetMapping("/{id}")
    public ResponseEntity<Basket> listarBasketPorId(@PathVariable String id){
        return ResponseEntity.ok(basketService.listarBasketPorId(id));
    }

    @PostMapping("/criar")
    public ResponseEntity<Basket> criarBasket(@RequestBody BasketRequest basketRequest ){
        return ResponseEntity.status(HttpStatus.CREATED).body(basketService.criarBasket(basketRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Basket> atualizarBasket(@PathVariable String id, @RequestBody BasketRequest basketRequest){
        return ResponseEntity.status(HttpStatus.OK).body(basketService.atualizarBasket(id, basketRequest));
    }

    @PutMapping("/{id}/payment")
    public ResponseEntity<Basket> basketPaga(@PathVariable String id, @RequestBody PaymentRequest paymentRequest){
        return ResponseEntity.status(HttpStatus.OK).body(basketService.basketPaga(id, paymentRequest));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarBasket(@PathVariable String id){
        basketService.deletarBasket(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
