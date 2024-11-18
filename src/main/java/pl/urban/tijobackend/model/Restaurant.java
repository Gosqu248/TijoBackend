package pl.urban.tijobackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    private String logoUrl;

    private String imageUrl;

    @OneToOne(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @JsonIgnore
    private RestaurantAddress restaurantAddress;
}
