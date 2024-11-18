package pl.urban.tijobackend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.urban.tijobackend.request.GeocodingResponse;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class GeocodingService {

    private final RestTemplate restTemplate;

    public GeocodingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public double[] getCoordinates(String address) {
        String url = String.format("https://nominatim.openstreetmap.org/search?format=json&q=%s",
                URLEncoder.encode(address, StandardCharsets.UTF_8));
        ResponseEntity<GeocodingResponse[]> response = restTemplate.getForEntity(url, GeocodingResponse[].class);

        if (response.getBody() != null && response.getBody().length > 0) {
            GeocodingResponse location = response.getBody()[0];
            return new double[]{Double.parseDouble(location.getLat()), Double.parseDouble(location.getLon())};
        }
        throw new IllegalArgumentException("Could not find coordinates for address: " + address);
    }

}
