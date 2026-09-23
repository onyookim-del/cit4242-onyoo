package kz.kimep.cit4242_onyoo;

import java.util.List;

public class InMemoryBookSource implements BookSource {

    @Override
    public List<Book> load() {
        return List.of(
                new Book("Clean Code", 464),
                new Book("Effective Java", 416),
                new Book("The Pragmatic Programmer", 352)
        );
    }
}