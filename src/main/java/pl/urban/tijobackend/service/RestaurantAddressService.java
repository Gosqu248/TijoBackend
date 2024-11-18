package pl.urban.tijobackend.service;

import org.springframework.stereotype.Service;
import pl.urban.tijobackend.model.Restaurant;
import pl.urban.tijobackend.model.RestaurantAddress;
import pl.urban.tijobackend.repository.RestaurantAddressRepository;
import pl.urban.tijobackend.repository.RestaurantRepository;

@Service
public class RestaurantAddressService {

    private final RestaurantAddressRepository restaurantAddressRepository;
    private final RestaurantRepository restaurantRepository;

    public RestaurantAddressService(RestaurantAddressRepository restaurantAddressRepository, RestaurantRepository restaurantRepository) {
        this.restaurantAddressRepository = restaurantAddressRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public RestaurantAddress getRestaurantAddressById(Long id) {
        return restaurantAddressRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Restaurant address with id " + id + " not found"));
    }

    public RestaurantAddress addAddress(RestaurantAddress restaurantAddress, Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new IllegalArgumentException("Restaurant with id " + restaurantId + " not found"));
        restaurantAddress.setRestaurant(restaurant);
        return restaurantAddressRepository.save(restaurantAddress);
    }


}
