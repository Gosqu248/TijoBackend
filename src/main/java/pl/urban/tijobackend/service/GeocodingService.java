package pl.urban.tijobackend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.urban.tijobackend.request.GeocodingResponse;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class GeocodingService {

    private final RestTemplate restTemplate;

    public GeocodingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Double> getCoordinates(java.lang.String address) {
        java.lang.String url = java.lang.String.format("https://nominatim.openstreetmap.org/search?format=json&q=%s",
                URLEncoder.encode(address, StandardCharsets.UTF_8));
        ResponseEntity<GeocodingResponse[]> response = restTemplate.getForEntity(url, GeocodingResponse[].class);

        if (response.getBody() != null && response.getBody().length > 0) {
            GeocodingResponse location = response.getBody()[0];
            Map<java.lang.String, java.lang.Double> coordinates = new HashMap<>();
            coordinates.put("lat", java.lang.Double.parseDouble(location.getLat()));
            coordinates.put("lon", java.lang.Double.parseDouble(location.getLon()));
            return coordinates;
        }
        throw new IllegalArgumentException("Could not find coordinates for address: " + address);
    }

}
