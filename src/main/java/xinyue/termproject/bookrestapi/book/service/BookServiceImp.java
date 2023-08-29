/**
 * Class: BookServiceImp
 * AuthorName: Xinyue Chen
 * Description:
 *     An concrete class to provide services to front-end.
 *     It has methods findAll, findByISBN, findByName, save, update, deleteById, and updatePartial.
 */

package xinyue.termproject.bookrestapi.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xinyue.termproject.bookrestapi.book.model.Book;
import xinyue.termproject.bookrestapi.book.repository.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class BookServiceImp implements BookService {

  private final BookRepository bookRepository;

  /**
   * Constructor.
   *
   * @param bookRepository represents book repository
   */
  @Autowired
  public BookServiceImp(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  /**
   * to get all books in database.
   *
   * @return CompletableFuture<List<Book>>
   */
  @Override
  public CompletableFuture<List<Book>> findAll() {
    return CompletableFuture.completedFuture(bookRepository.findAll());
  }

  /**
   * to get a book by ISBN.
   *
   * @param isbn represent Book's ISBN
   * @return CompletableFuture<Optional<Book>>
   */
  @Override
  public CompletableFuture<Optional<Book>> findByISBN(String isbn) {
    return CompletableFuture.completedFuture(bookRepository.findById(isbn));
  }

  /**
   * to get a book by name.
   *
   * @param name represent Book's name
   * @return CompletableFuture<List<Book>>
   */

  @Override
  public CompletableFuture<List<Book>> findByName(String name) {
    return bookRepository.findByName(name);
  }

  /**
   * to add book to database.
   *
   * @param book represent a book
   * @return Book
   */
  @Override
  public Book save(Book book) {
    return bookRepository.save(book);
  }

  /**
   * to update the whole information of the book.
   *
   * @param book represent the details of a book that want to update.
   * @return Book
   */
  @Override
  public Book update(Book book) {
    return bookRepository.save(book);
  }

  /**
   * to delete a book by ISBN.
   *
   * @param id represent Book's ISBN
   */
  @Override
  public void deleteById(String id) {
    bookRepository.deleteById(id);
  }

  /**
   * This method is to update partial data of the book
   *
   * @param isbn represent the target book's isbn we want to update
   * @param book represent the book data we want to update to
   * @return updated book
   */
  @Override
  public Book updatePartial(String isbn, Book book) {
    Optional<Book> targetBook = bookRepository.findById(isbn);

    // of find a book based on isbn
    if(targetBook.isPresent()){
      if(book.getTitle() != null) {
        targetBook.get().setTitle(book.getTitle());
      }

      if(book.getAuthors().size() != 0) {
        targetBook.get().setAuthors(book.getAuthors());
      }

      return bookRepository.save(targetBook.orElse(null));
    }

    return null;
  }
}
