package guru.springframework.spring5webapp.model;

import lombok.*;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include private Long id;
    private String title;
    private String sibn;
    private String publisher;
    @ManyToMany
    @JoinTable(name="author_book",joinColumns = @JoinColumn(name="book_id"),
    inverseJoinColumns = @JoinColumn(name="author_id"))
    private Set<Author> authors= new HashSet<>();
}
