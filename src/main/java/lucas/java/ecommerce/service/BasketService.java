package lucas.java.ecommerce.service;

import lombok.RequiredArgsConstructor;
import lucas.java.ecommerce.client.request.BasketRequest;
import lucas.java.ecommerce.client.response.PlatziProductsResponse;
import lucas.java.ecommerce.controller.request.PaymentRequest;
import lucas.java.ecommerce.entity.Basket;
import lucas.java.ecommerce.entity.Product;
import lucas.java.ecommerce.entity.Status;
import lucas.java.ecommerce.repository.BasketRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;
    private final ProductService productService;

    public Basket listarBasketPorId(String id){
        return basketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Carrinho não encontrado"));
    }
    public Basket criarBasket(BasketRequest basketRequest){
        basketRepository.findByClientAndStatus(basketRequest.clientId(), Status.OPEN)
                .ifPresent(basket -> {
                    throw new IllegalArgumentException("Já existe um carrinho aberto");
                });

        List<Product> products = getProducts(basketRequest);

        Basket basket = Basket.builder()
                .client(basketRequest.clientId())
                .status(Status.OPEN)
                .products(products)
                .build();

        basket.calculateTotalPrice();
        return basketRepository.save(basket);
    }

    public Basket atualizarBasket(String basketId, BasketRequest basketRequest){
        Basket basketSalva = listarBasketPorId(basketId);

        List<Product> products = getProducts(basketRequest);
        basketSalva.setProducts(products);
        basketSalva.calculateTotalPrice();
        return basketRepository.save(basketSalva);
    }

    public Basket basketPaga(String basketId, PaymentRequest paymentRequest){
        Basket basketSalva = listarBasketPorId(basketId);
        basketSalva.setPaymentMethod(paymentRequest.getPaymentMethod());
        basketSalva.setStatus(Status.SOLD);
        return basketRepository.save(basketSalva);
    }

    public void deletarBasket(String basketId){
        basketRepository.deleteById(basketId);
    }

    private @NonNull List<Product> getProducts(BasketRequest basketRequest) {
        List<Product> products = new ArrayList<>();
        basketRequest.products().forEach(productRequest -> {
            PlatziProductsResponse platziProductsResponse = productService.listarProdutosPorId(productRequest.id());

            products.add(Product.builder()
                    .id(platziProductsResponse.id())
                    .title(platziProductsResponse.title())
                    .price(platziProductsResponse.price())
                    .quantity(productRequest.quantity())
                    .build());
        });
        return products;
    }

}
