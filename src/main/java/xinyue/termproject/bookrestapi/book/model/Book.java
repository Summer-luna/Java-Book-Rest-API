/**
 * Class: Book
 * AuthorName: Xinyue Chen
 * Description:
 *     An Entity Model to use for Object Relation Mapping with Database Table called Book.
 *     It has getter and setter methods and authors of a book.
 *     It has a printAuthors method that used lambda method to print the authors.
 */

package xinyue.termproject.bookrestapi.book.model;

import jakarta.persistence.*;
import lombok.*;
import xinyue.termproject.bookrestapi.author.model.Author;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
@AllArgsConstructor
@NoArgsConstructor
public class Book {

  @Getter
  @Setter
  @Id
  @Column(nullable = false, name = "isbn")
  private String isbn;

  @Getter
  @Setter
  @Column(nullable = false, name = "title")
  private String title;

  @Getter
  @Setter
  @ManyToMany
  @JoinTable(
    name= "book_author",
    joinColumns = @JoinColumn(name = "bookid", referencedColumnName = "isbn"),
    inverseJoinColumns = @JoinColumn(name = "authorid", referencedColumnName = "id")
  )
  private Set<Author> authors = new HashSet<>();

  /**
   * PrintAuthors (print a list of authors)
   * Input: None
   * Output: a list of authors
   * No Returns
   */
  public void printAuthors() {
    authors.forEach(author -> System.out.println("ID: " + author.getName()));
  }
}
