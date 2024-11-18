package pl.urban.tijobackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.urban.tijobackend.dto.SearchedRestaurantDTO;
import pl.urban.tijobackend.model.RestaurantAddress;
import pl.urban.tijobackend.service.RestaurantAddressService;
import org.json.JSONException;

import java.util.List;

@RestController
@RequestMapping("/api/restaurantAddress")
public class RestaurantAddressController {

    private final RestaurantAddressService restaurantAddressService;

    public RestaurantAddressController(RestaurantAddressService restaurantAddressService) {
        this.restaurantAddressService = restaurantAddressService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantAddress> getRestaurantAddress(@PathVariable Long id) {
        RestaurantAddress restaurantAddress = restaurantAddressService.getRestaurantAddressById(id);
        return ResponseEntity.ok(restaurantAddress);
    }

    @PostMapping("/add")
    public ResponseEntity<RestaurantAddress> addRestaurantAddress(@RequestParam Long restaurantId, @RequestBody RestaurantAddress restaurantAddress) {
        RestaurantAddress savedRestaurantAddress =  restaurantAddressService.addAddress(restaurantAddress, restaurantId);
        return ResponseEntity.ok(savedRestaurantAddress);
    }

    @GetMapping("/searchRestaurant")
    public ResponseEntity<List<SearchedRestaurantDTO>> searchRestaurants(
            @RequestParam String address,
            @RequestParam(defaultValue = "6") double radius) throws JSONException {
        List<SearchedRestaurantDTO> results = restaurantAddressService.searchNearbyRestaurants(address, radius);
        return ResponseEntity.ok(results);
    }
}
