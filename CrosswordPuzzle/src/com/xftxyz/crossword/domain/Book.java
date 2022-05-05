package com.xftxyz.crossword.domain;

import java.util.Arrays;

public class Book {
    private String bookName;
    private String[] roles;

    public Book(String bookName, String[] roles) {
        this.bookName = bookName;
        this.roles = roles;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Book [bookName=" + bookName + ", roles=" + Arrays.toString(roles) + "]";
    }

}
