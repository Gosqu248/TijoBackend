package pl.urban.tijobackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.urban.tijobackend.model.RestaurantAddress;
import pl.urban.tijobackend.service.RestaurantAddressService;

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
}
