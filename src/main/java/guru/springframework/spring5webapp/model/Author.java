package guru.springframework.spring5webapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Author {

    public Author(){

    }
    public Author(String firstName,String lastName){
     this.firstName=firstName;
     this.lastName=lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include private long id;
    private String firstName;
    private String lastName;
    @ManyToMany(mappedBy="authors")
    private Set<Book> book=new HashSet<>() ;

}
