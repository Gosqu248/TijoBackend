package pl.urban.tijobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.urban.tijobackend.model.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Long countByRestaurantId(Long restaurantId);

    List<Order> findAllByRestaurantId(Long restaurantId);
}
