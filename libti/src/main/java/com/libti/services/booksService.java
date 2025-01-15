package com.libti.services;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.libti.models.bookModel;
import com.libti.repositories.booksRepository;

import jakarta.transaction.Transactional;

@Service
public class booksService {

    @Autowired
    private booksRepository booksRepository;

    @Transactional
    public void save(com.libti.dtos.booksDto booksDto) {

        try {

        

            bookModel bookModel = new bookModel();
            try {
                String sanitizedInput = new String(booksDto.getCover()).replaceAll("\\s+", "");
                byte[] decodedCover = Base64.getDecoder().decode(sanitizedInput); 
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
