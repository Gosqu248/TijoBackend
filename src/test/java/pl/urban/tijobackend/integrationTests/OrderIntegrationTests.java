package pl.urban.tijobackend.integrationTests;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.urban.tijobackend.model.Order;
import pl.urban.tijobackend.repository.OrderRepository;
import pl.urban.tijobackend.service.OrderService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderIntegrationTests {

    private static final Logger logger = LoggerFactory.getLogger(OrderIntegrationTests.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testGetOrderById() {
        // Given
        Long existingOrderId = 1L;

        // When
        Order order = orderService.getOrderById(existingOrderId);

        // Then
        assertNotNull(order);
        assertEquals(existingOrderId, order.getId());
        assertNotNull(order.getRestaurant());
        assertNotNull(order.getOrderMenus());
        assertFalse(order.getOrderMenus().isEmpty());
        logger.info("Test zakończony sukcesem - znaleziono zamówienie o ID: {} , koszt zamówienia: {}zł", order.getId(), order.getTotalPrice());
    }

    @Test
    public void testGetAllRestaurantOrders() {
        // Given
        Long restaurantId = 2L;
        Long orderCount = orderRepository.countByRestaurantId(restaurantId);

        // When
        List<Order> orders = orderService.getAllRestaurantOrders(restaurantId);

        // Then
        assertEquals(orderCount, orders.size());
        logger.info("Test zakończony sukcesem - znaleziono {} zamówień dla restauracji o ID: {}", orders.size(), restaurantId);
    }

    @Test
    public void testGetAllOrders() {
        // Given
        Long orderCount = orderRepository.count();

        // When
        List<Order> order = orderService.getAllOrders();

        // Then
        assertEquals(orderCount, order.size());
        logger.info("Test zakończony sukcesem - znaleziono {} zamówień ", order.size());
    }
}