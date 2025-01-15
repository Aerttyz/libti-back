package com.libti.services;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libti.models.bookModel;
import com.libti.repositories.booksRepository;

@Service
public class booksService {

    @Autowired
    private booksRepository booksRepository;

    public void save(com.libti.dtos.booksDto booksDto) {

        try {

        

            bookModel bookModel = new bookModel();
            try {
                byte[] decodedCover = Base64.getDecoder().decode(booksDto.getCover());
                bookModel.setCover(decodedCover);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
}
