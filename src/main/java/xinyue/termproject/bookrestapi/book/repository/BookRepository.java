/**
 * Class: BookRepository
 * AuthorName: Xinyue Chen
 * Description:
 *     An book Repository extends JPA Repository to interact with database.
 */
package xinyue.termproject.bookrestapi.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xinyue.termproject.bookrestapi.book.model.Book;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

  /**
   * to get a book by name.
   *
   * @param name represent Book's name
   * @return CompletableFuture<List<Book>>
   */
  @Query("SELECT book FROM Book book WHERE book.title = :name")
  CompletableFuture<List<Book>> findByName(@Param("name") String name);
}
