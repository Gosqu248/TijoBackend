package pl.urban.tijobackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.urban.tijobackend.service.GeocodingService;

import java.util.Map;

@RestController
@RequestMapping("/api/geocoding")
public class GeocodingController {

    private final GeocodingService geocodingService;

    public GeocodingController(GeocodingService geocodingService) {
        this.geocodingService = geocodingService;
    }

    @GetMapping("/cordinates")
    public Map<String, Double> getCoordinates(@RequestParam String address) {
        return geocodingService.getCoordinates(address);
    }
}
