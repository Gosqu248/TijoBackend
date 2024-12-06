package pl.urban.tijobackend.integrationTests;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.urban.tijobackend.dto.SearchedRestaurantDTO;
import pl.urban.tijobackend.model.Restaurant;
import pl.urban.tijobackend.model.RestaurantAddress;
import pl.urban.tijobackend.repository.RestaurantAddressRepository;
import pl.urban.tijobackend.repository.RestaurantRepository;
import pl.urban.tijobackend.service.RestaurantAddressService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RestaurantAddressIntegrationTest {

    private static final Logger logger = LoggerFactory.getLogger(RestaurantAddressIntegrationTest.class);


    @Autowired
    private RestaurantAddressService restaurantAddressService;

    @Autowired
    private RestaurantAddressRepository restaurantAddressRepository;


    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    public void testGetRestaurantAddressById() {
        //Given
        Long restaurantId = 3L;

        //When
        RestaurantAddress resultAddress = restaurantAddressService.getRestaurantAddressById(restaurantId);

        //Then
        assertNotNull(resultAddress);
        assertEquals(restaurantId, resultAddress.getId());
        logger.info("Test zakończony sukcesem - znaleziono adres restauracji: {}", resultAddress.getStreet() + " " + resultAddress.getFlatNumber() + ", " + resultAddress.getCity() + " " + resultAddress.getZipCode());
    }

    @Test
    public void testAddAddress() {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Test Restaurant");
        restaurant.setCategory("Italian");
        restaurant = restaurantRepository.save(restaurant);

        RestaurantAddress address = new RestaurantAddress();
        address.setStreet("Main St");
        address.setFlatNumber("12A");
        address.setCity("Test City");
        address.setZipCode("12345");
        address.setLatitude(52.2297);
        address.setLongitude(21.0122);

        RestaurantAddress savedAddress = restaurantAddressService.addAddress(address, restaurant.getId());

        assertNotNull(savedAddress.getId());
        assertEquals(restaurant.getId(), savedAddress.getRestaurant().getId());
        logger.info("Test zakończony sukcesem - dodano nowy address do nowej restauracje w bazie danych");

    }

    @Test
    void testSearchNearbyRestaurantsWithRestaurants() {
       // Given
        String address = "33-100";

        //When
        List<SearchedRestaurantDTO> results = restaurantAddressService.searchNearbyRestaurants(address, 6.0);

        //Then
        assertFalse(results.isEmpty());
        assertEquals(results.size(), 11);
        logger.info("Test zakończony sukcesem - znaleziono {} restauracji", results.size());

    }

    @Test
    void testSearchNearbyRestaurantsWithoutRestaurants() {
        // Given
        String address = "Paris";

        //When
        List<SearchedRestaurantDTO> results = restaurantAddressService.searchNearbyRestaurants(address, 6.0);

        //Then
        assertEquals(results.size(), 0);
        logger.info("Test zakończony sukcesem - znaleziono {} restauracji", results.size());
    }

    @Test
    public void testUpdateAddress() {
        //Given
        Long addressId = 12L; // Można zmienić na inny istniejący adres w bazie danych
        RestaurantAddress updatedAddress = new RestaurantAddress();
        updatedAddress.setStreet("Warszawska");
        updatedAddress.setFlatNumber("12");
        updatedAddress.setCity("Warszawa");
        updatedAddress.setZipCode("00-001");


        //When
        RestaurantAddress address = restaurantAddressService.updateAddress(addressId, updatedAddress);

        //Then
        assertNotNull(address);
        assertEquals(updatedAddress.getStreet(), address.getStreet());
        logger.info("Test zakończony sukcesem - poprawnie zaktualizowano adres restauracji");
    }

    @Test
    void testGetAllRestaurantAddresses() {
        //Given
        Long actualRestaurantAddressCount = restaurantAddressRepository.count();

        //When
        List<RestaurantAddress> addresses = restaurantAddressService.getAllRestaurantAddresses();

        //Then
        assertEquals(actualRestaurantAddressCount, addresses.size());
        logger.info("Test zakończony sukcesem - znalazło {} adresów restauracji w bazie danych", addresses.size());

    }






}
