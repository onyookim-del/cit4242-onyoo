package kz.kimep.cit4242_onyoo;

import org.junit.jupiter.api.Test;

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
}