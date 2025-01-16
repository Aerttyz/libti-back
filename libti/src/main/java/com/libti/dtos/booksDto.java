package com.libti.dtos;

public class BooksDto {
    
    private String title;

    private String author;

    private String edition;

    private String publisher;

    private String isbn;

    private String yearPublication;

    private String link;

    private byte[] cover;

    public BooksDto() {
    }

    public BooksDto(String title, String author, String edition, String publisher, String isbn, String yearPublication, String link, byte[] cover) {
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.publisher = publisher;
        this.isbn = isbn;
        this.yearPublication = yearPublication;
        this.link = link;
        this.cover = cover;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(String yearPublication) {
        this.yearPublication = yearPublication;
    }

}
