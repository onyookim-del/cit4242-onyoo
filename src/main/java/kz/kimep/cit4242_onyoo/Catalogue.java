package kz.kimep.cit4242_onyoo;

import java.util.List;

public final class Catalogue {

    private final List<Book> books;

    public Catalogue(List<Book> books) {
        this.books = List.copyOf(books);
    }

    public List<Book> books() {
        return books;
    }
}