/**
 * Class: BookService
 * AuthorName: Xinyue Chen
 * Description:
 *     An interface to provide services to front-end.
 *     It has methods findAll, findByISBN, findByName, save, update, deleteById, and updatePartial.
 */

package xinyue.termproject.bookrestapi.book.service;

import xinyue.termproject.bookrestapi.book.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface BookService {

  /**
   * to get all books in database.
   *
   * @return CompletableFuture<List<Book>>
   */
  CompletableFuture<List<Book>> findAll();

  /**
   * to get a book by ISBN.
   *
   * @param isbn represent Book's ISBN
   * @return CompletableFuture<Optional<Book>>
   */
  CompletableFuture<Optional<Book>> findByISBN(String isbn);

  /**
   * to get a book by name.
   *
   * @param name represent Book's name
   * @return CompletableFuture<List<Book>>
   */
  CompletableFuture<List<Book>> findByName(String name);

  /**
   * to add book to database.
   *
   * @param book represent a book
   * @return Book
   */
  Book save(Book book);

  /**
   * to update the whole information of the book.
   *
   * @param book represent the details of a book that want to update.
   * @return Book
   */
  Book update(Book book);

  /**
   * to delete a book by ISBN.
   *
   * @param id represent Book's ISBN
   */
  void deleteById(String id);

  /**
   * This method is to update partial data of the book
   *
   * @param isbn represent the target book's isbn we want to update
   * @param book represent the book data we want to update to
   * @return updated book
   */
  Book updatePartial(String isbn, Book book);
}
