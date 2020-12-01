package pl.edu.ug.tent.springmvcdemo.service;

import pl.edu.ug.tent.springmvcdemo.domain.Book;
import pl.edu.ug.tent.springmvcdemo.domain.Person;

import java.util.List;

public interface BookManager {

  void addBook(Book book);

  Book findById(String id);

  List<Book> getAllBooks();

  void remove(String id);


}
