package lucas.java.ecommerce.repository;

import lucas.java.ecommerce.entity.Basket;
import lucas.java.ecommerce.entity.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BasketRepository extends MongoRepository<Basket, String> {

    Optional<Basket> findByClientAndStatus(Long client, Status status);

}
