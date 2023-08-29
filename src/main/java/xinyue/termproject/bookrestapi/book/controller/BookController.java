/**
 * Class: BookController
 * AuthorName: Xinyue Chen
 * Description:
 *     An controller to handle HTTP Requests from font-end.
 *     It has findAllBooks, addBook, findBookByISBN, deleteBook, updateEntireBook, and updatePartialBook.
 */

package xinyue.termproject.bookrestapi.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xinyue.termproject.bookrestapi.book.model.Book;
import xinyue.termproject.bookrestapi.book.service.BookService;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(path = "/api/books")
public class BookController {
  private final BookService bookService;

  /**
   * Constructor.
   * @param bookService represents Book Service
   */
  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  /**
   * to get all books in database.
   *
   * @return CompletableFuture<List<Book>>
   */
  @GetMapping("")
  public CompletableFuture<List<Book>> findAllBooks() {
    return bookService.findAll();
  }

  /**
   * to add book to database.
   *
   * @param book represent a book
   * @return Book
   */
  @PostMapping("/add")
  public Book addBook(@RequestBody Book book) {
    return bookService.save(book);
  }

  /**
   * to get a book by ISBN.
   *
   * @param isbn represent Book's ISBN
   * @return CompletableFuture<Optional<Book>>
   */
  @GetMapping("/isbn/{isbn}")
  public CompletableFuture<Optional<Book>> findBookByISBN(@PathVariable String isbn) {
    return bookService.findByISBN(isbn);
  }

  /**
   * to get a book by name.
   *
   * @param name represent Book's name
   * @return CompletableFuture<List<Book>>
   */
  @GetMapping("/title/{name}")
  public CompletableFuture<List<Book>> findBookByName(@PathVariable String name) {
    System.out.println(name);
    String split = name.replace("%20", " ");

    return bookService.findByName(split);
  }

  /**
   * to delete a book by ISBN.
   *
   * @param isbn represent Book's ISBN
   */
  @DeleteMapping("{isbn}/delete")
  public void deleteBook(@PathVariable String isbn) {
    bookService.deleteById(isbn);
  }

  /**
   * to update the whole information of the book.
   *
   * @param isbn represent Book's ISBN
   * @param book represent the details of a book that want to update.
   * @return Book
   */
  @PutMapping("{isbn}")
  public Book updateEntireBook(@PathVariable String isbn, @RequestBody Book book) {
    book.setIsbn(isbn);
    return bookService.save(book);
  }

  /**
   * This method is to update partial data of the book
   *
   * @param isbn represent the target book's isbn we want to update
   * @param book represent the book data we want to update to
   * @return updated book
   */
  @PatchMapping("{isbn}")
  public Book updatePartialBook(@PathVariable String isbn, @RequestBody Book book) throws ExecutionException, InterruptedException {
    return bookService.updatePartial(isbn, book);
  }
}
