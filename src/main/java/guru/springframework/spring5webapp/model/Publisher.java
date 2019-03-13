package guru.springframework.spring5webapp.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include private long id;
    private String name;

    public Publisher(String name, String addressLine1, String city, String state) {
        this.name = name;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
    }

    private String addressLine1;
    private String city;
    private String state;
}
