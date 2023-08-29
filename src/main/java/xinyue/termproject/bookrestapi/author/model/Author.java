/**
 * Class: Author
 * AuthorName: Xinyue Chen
 * Description:
 *     An Entity Model to use for Object Relation Mapping with Database Table called Author.
 *     It has getter and setter methods and books that belongs to a book.
 */
package xinyue.termproject.bookrestapi.author.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xinyue.termproject.bookrestapi.book.model.Book;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author {
  @Getter
  @Setter
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(nullable = false, name = "id")
  private String id;

  @Getter
  @Setter
  @Column(nullable = false, name = "name")
  private String name;

  @Getter
  @Setter
  @ManyToMany(mappedBy = "authors")
  @JsonIgnore
  private Set<Book> books = new HashSet<>();

}
