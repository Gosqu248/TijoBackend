package pl.urban.tijobackend.unitTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.urban.tijobackend.model.Restaurant;
import pl.urban.tijobackend.repository.RestaurantRepository;
import pl.urban.tijobackend.service.RestaurantService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RestaurantUnitTests {
    private static final Logger logger = LoggerFactory.getLogger(RestaurantUnitTests.class);


    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private RestaurantService restaurantService;

    private Restaurant testRestaurant;
    @BeforeEach
    void setUp() {
        testRestaurant = new Restaurant();
        testRestaurant.setId(1L);
        testRestaurant.setName("Test Restaurant");
        testRestaurant.setCategory("Italian");
    }
    @Test
    public void shouldFindRestaurantByExistingId() {
        // Given
        Long restaurantId = 1L;
        when(restaurantRepository.findById(restaurantId)).thenReturn(Optional.of(testRestaurant));

        // When
        Restaurant foundRestaurant  = restaurantService.getRestaurantById(restaurantId);

        // Then
        assertNotNull(foundRestaurant);
        assertEquals(testRestaurant.getId(), foundRestaurant.getId());
        assertEquals(testRestaurant.getName(), foundRestaurant.getName());
        logger.info("Test zakończony sukcesem - znaleziono restaurację o ID: {}", restaurantId);
    }

    @Test
    public void shouldThrowExceptionWhenRestaurantNotFound() {
        // Given
        Long nonExistingId = 99L;
        when(restaurantRepository.findById(nonExistingId)).thenReturn(Optional.empty());

        // When
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> restaurantService.getRestaurantById(nonExistingId));

        // Then
        assertEquals("Restaurant with id " + nonExistingId + " not found", exception.getMessage());
        logger.info("Test zakończony sukcesem - nie znaleziono restauracji o ID: {}", nonExistingId);

    }

    @Test
    public void shouldAddNewRestaurant() {
        // Given
        Restaurant newRestaurant = new Restaurant();
        newRestaurant.setName("New Restaurant");
        when(restaurantRepository.save(newRestaurant)).thenReturn(newRestaurant);

        // When
        Restaurant savedRestaurant = restaurantService.addRestaurant(newRestaurant);


        // Then
        assertNotNull(savedRestaurant);
        assertEquals(newRestaurant, savedRestaurant);
        logger.info("Dodano nową restaurację");

    }

    @Test
    void shouldDeleteRestaurantById() {
        // Given
        Long restaurantId = 1L;

        // When
        restaurantService.deleteRestaurant(restaurantId);

        // Then
        verify(restaurantRepository).deleteById(restaurantId);
        logger.info("Test zakończony sukcesem - usunięto restaurację o ID: {}", restaurantId);

    }

    @Test
    void shouldUpdateExistingRestaurant() {
        // Given
        Long restaurantId = 1L;
        Restaurant existingRestaurant = new Restaurant();
        existingRestaurant.setId(restaurantId);
        existingRestaurant.setName("Old Name");
        existingRestaurant.setCategory("Old Category");

        Restaurant updatedRestaurantDetails = new Restaurant();
        updatedRestaurantDetails.setName("New Name");
        updatedRestaurantDetails.setCategory("New Category");

        when(restaurantRepository.findById(restaurantId)).thenReturn(Optional.of(existingRestaurant));
        when(restaurantRepository.save(existingRestaurant)).thenReturn(existingRestaurant);

        // When
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurantId, updatedRestaurantDetails);

        // Then
        assertEquals("New Name", updatedRestaurant.getName());
        assertEquals("New Category", updatedRestaurant.getCategory());
        logger.info("Test zakończony sukcesem - zaktualizowano restaurację o ID: {}", restaurantId);

    }

    @Test
    void shouldRetrieveAllRestaurants() {
        // Given
        List<Restaurant> expectedRestaurants = Arrays.asList(
                testRestaurant,
                new Restaurant(2L, "Another Restaurant", "Chinese", null, null, null, null)
        );
        when(restaurantRepository.findAll()).thenReturn(expectedRestaurants);

        // When
        List<Restaurant> retrievedRestaurants = restaurantService.getAllRestaurants();

        // Then
        assertNotNull(retrievedRestaurants);
        assertEquals(2, retrievedRestaurants.size());
        logger.info("Test zakończony sukcesem - pobrano wszystkie restauracje");

    }

}