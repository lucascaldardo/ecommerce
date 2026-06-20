package lucas.java.ecommerce.controller;

import lombok.RequiredArgsConstructor;
import lucas.java.ecommerce.client.request.BasketRequest;
import lucas.java.ecommerce.entity.Basket;
import lucas.java.ecommerce.service.BasketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @PostMapping("/criar")
    public ResponseEntity<Basket> criarBasket(@RequestBody BasketRequest basketRequest ){
        return ResponseEntity.status(HttpStatus.CREATED).body(basketService.criarBasket(basketRequest));
    }

}
