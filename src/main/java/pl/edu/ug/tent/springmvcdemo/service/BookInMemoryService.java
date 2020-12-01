package pl.edu.ug.tent.springmvcdemo.service;

import org.springframework.stereotype.Service;
import pl.edu.ug.tent.springmvcdemo.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookInMemoryService implements BookManager {

  private static List<Book> books = new ArrayList<>();

  public void addBook(Book book) {
    book.setId(UUID.randomUUID().toString());
    books.add(book);
  }

  @Override
  public Book findById(String id) {
    for (Book book: books) {
      if (book.getId().equals(id)) {
        return book;
      }
    }
    return null;
  }

  public List<Book> getAllBooks() {
    return books;
  }

  @Override
  public void remove(String id) {

    Book toRemove = null;
    for (Book book : books) {
      if (book.getId().equals(id)) {
        toRemove = book;
        break;
      }
    }
    if (toRemove != null) {
      books.remove(toRemove);
    }
  }

}
