package com.libti.services;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libti.models.BookModel;
import com.libti.repositories.BooksRepository;
import jakarta.transaction.Transactional;

@Service
public class BooksService {

    @Autowired
    private BooksRepository booksRepository;

    @Transactional
    public void save(com.libti.dtos.BooksDto booksDto) {
        try {
            BookModel bookModel = new BookModel();
            bookModel.setCover(booksDto.getCover());
            bookModel.setTitle(booksDto.getTitle());
            bookModel.setAuthor(booksDto.getAuthor());
            bookModel.setEdition(booksDto.getEdition());
            bookModel.setPublisher(booksDto.getPublisher());
            bookModel.setIsbn(booksDto.getIsbn());
            bookModel.setLink(booksDto.getLink());
            bookModel.setYearPublication(booksDto.getYearPublication());
            booksRepository.save(bookModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<BookModel> getBook() {
        try {
            List<BookModel> books = booksRepository.findAll();
            return books;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<BookModel> getBookByTitle(String title) {
        try {
            List<BookModel> books = booksRepository.findByTitleContainingIgnoreCase(title);
            return books;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
