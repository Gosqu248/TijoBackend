package pl.urban.tijobackend.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GeocodingResponse {
    private String lat;
    private String lon;
}
