package pl.urban.tijobackend.unitTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.urban.tijobackend.request.GeoCodingResponse;
import pl.urban.tijobackend.service.GeocodingService;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class GeocodingServiceTests {

    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private GeocodingService geocodingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnCoordinatesForParis() {
        // Given
        String address = "Paris";
        GeoCodingResponse mockResponse = new GeoCodingResponse("48.8588897", "2.3200410217200766");

        when(restTemplate.getForEntity(anyString(), eq(GeoCodingResponse[].class)))
                .thenReturn(new ResponseEntity<>(new GeoCodingResponse[] {mockResponse}, HttpStatus.OK));

        // When
        double[] coordinates = geocodingService.getCoordinates(address);

        // Then
        double expectedLat = Double.parseDouble(mockResponse.getLat());
        double expectedLon = Double.parseDouble(mockResponse.getLon());
        assertNotNull(coordinates);
        assertEquals(expectedLat, coordinates[0]);
        assertEquals(expectedLon, coordinates[1]);
    }

    @Test
    void shouldReturnCoordinatesForTarnow() {
        // Given
        String address = "Tarnów, 33-100";
        GeoCodingResponse mockResponse = new GeoCodingResponse("50.025988299999995", "20.96405842696229");

        when(restTemplate.getForEntity(anyString(), eq(GeoCodingResponse[].class)))
                .thenReturn(new ResponseEntity<>(new GeoCodingResponse[] {mockResponse}, HttpStatus.OK));

        // When
        double[] coordinates = geocodingService.getCoordinates(address);

        // Then
        double expectedLat = Double.parseDouble(mockResponse.getLat());
        double expectedLon = Double.parseDouble(mockResponse.getLon());
        assertNotNull(coordinates);
        assertEquals(expectedLat, coordinates[0]);
        assertEquals(expectedLon, coordinates[1]);
    }

    @Test
    void shouldThrowExceptionWhenCoordinatesNotFound() {
        // Given
        String address = "Invalid Address";

        when(restTemplate.getForEntity(anyString(), eq(GeoCodingResponse[].class)))
                .thenReturn(new ResponseEntity<>(new GeoCodingResponse[] {}, HttpStatus.OK));

        // When
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            geocodingService.getCoordinates(address);
        });

        //Then
        String expectedMessage = "Could not find coordinates for address: " + address;
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }



}
