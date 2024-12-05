package pl.urban.tijobackend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.urban.tijobackend.request.GeoCodingResponse;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class GeocodingService {

    private final RestTemplate restTemplate;

    public GeocodingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public double[] getCoordinates(String address) {
        String formattedAddress = removeCommas(address);

        String url = String.format("https://nominatim.openstreetmap.org/search?format=json&q=%s",
                URLEncoder.encode(formattedAddress, StandardCharsets.UTF_8));
        try {
            ResponseEntity<GeoCodingResponse[]> response = restTemplate.getForEntity(url, GeoCodingResponse[].class);

            if (response.getBody() != null && response.getBody().length > 0) {
                GeoCodingResponse location = response.getBody()[0];
                double lat = Double.parseDouble(location.getLat());
                double lon = Double.parseDouble(location.getLon());



                return new double[]{lat, lon};
            } else {
                throw new IllegalArgumentException("No results found for address: " + address);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not find coordinates for address: " + address);
        }
    }

    private String removeCommas(String address) {
        String addressWithoutCommas = address.replace(",", "");
        return addressWithoutCommas
                .replace("ą", "a")
                .replace("ć", "c")
                .replace("ę", "e")
                .replace("ł", "l")
                .replace("ń", "n")
                .replace("ó", "o")
                .replace("ś", "s")
                .replace("ź", "z")
                .replace("ż", "z");

    }
}
