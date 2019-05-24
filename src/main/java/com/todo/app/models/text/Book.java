package com.todo.app.models.text;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Book {

    List<Page> pages;

    public Book() {
        this.pages = new ArrayList<>();
    }

    public List<Page> read (List<String> list){
        return pages;
    }

    public void write (Page page) {
        pages.add(page);
    }

    public void remove (int PageNumber) {
        pages.remove(PageNumber);
    }
}
