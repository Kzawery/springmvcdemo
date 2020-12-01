package pl.edu.ug.tent.springmvcdemo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.tent.springmvcdemo.domain.Book;
import pl.edu.ug.tent.springmvcdemo.service.BookManager;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

  @Autowired
  BookManager bm;

  @GetMapping("/api/book")
  public List<Book> getBooks() {
    return bm.getAllBooks();
  }

  @PostMapping("/api/book")
  Book addBook(@RequestBody @Valid Book book) {
    Book bookToAdd = new Book(book.getTitle(), book.getISBN(), book.getAuthor());
    bm.addBook(bookToAdd);
    return bookToAdd;
  }

  @GetMapping("/api/book/{id}")
  Book getBook(@PathVariable String id) {
    return bm.findById(id);
  }

  @PutMapping("/api/book/{id}")
  Book replaceBook(@RequestBody  @Valid Book book, @PathVariable String id) {

    bm.remove(id);

    Book bookToAdd = new Book(book.getTitle(), book.getISBN(), book.getAuthor());
    bm.addBook(bookToAdd);
    return bookToAdd;
  }

  @DeleteMapping("/api/book/{id}")
  void deletePerson(@PathVariable String id) {
    bm.remove(id);
  }
}
