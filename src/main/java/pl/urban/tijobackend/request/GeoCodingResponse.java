package pl.urban.tijobackend.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoCodingResponse {
    private String lat;
    private String lon;
}
