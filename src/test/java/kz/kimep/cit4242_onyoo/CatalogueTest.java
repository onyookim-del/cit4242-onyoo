package kz.kimep.cit4242_onyoo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CatalogueTest {

    @Test
    void loadsBooksFromMemoryWithoutAFile() {
        BookSource source = new InMemoryBookSource();

        Catalogue catalogue = new Catalogue(source.load());

        assertEquals(3, catalogue.books().size());
        assertEquals("Clean Code", catalogue.books().get(0).title());
    }

    @Test
    void bookKeepsBehaviour() {
        Book book = new Book("Clean Code", 464);

        assertFalse(book.hasMoreThan(500));
    }

    @Test
    void loadsBooksFromCsv() {
        BookSource source = new CsvBookSource("/books.csv");

        Catalogue catalogue = new Catalogue(source.load());

        assertEquals(3, catalogue.books().size());
        assertEquals("Clean Code", catalogue.books().get(0).title());
    }

    @Test
    void unknownAuthorReturnsEmptyList() {
        Catalogue catalogue = new Catalogue(List.of(
                new Book("Clean Code", "Robert C. Martin", 464),
                new Book("Effective Java", "Joshua Bloch", 416)
        ));

        assertEquals(List.of(), catalogue.titlesBy("Unknown Author"));
    }
}