package pl.urban.tijobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.urban.tijobackend.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
