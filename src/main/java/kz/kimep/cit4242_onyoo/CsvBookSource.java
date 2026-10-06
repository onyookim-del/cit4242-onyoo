package kz.kimep.cit4242_onyoo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CsvBookSource implements BookSource {

    private final String resource;

    public CsvBookSource(String resource) {
        this.resource = resource;
    }

    @Override
    public List<Book> load() {
        InputStream input = getClass().getResourceAsStream(resource);

        if (input == null) {
            throw new IllegalArgumentException("Resource not found: " + resource);
        }

        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(input))) {

            return reader.lines()
                    .filter(line -> !line.isBlank())
                    .map(line -> line.split(";"))
                    .map(parts -> new Book(
                            parts[0],
                            parts[1],
                            Integer.parseInt(parts[2])
                    ))
                    .toList();

        } catch (java.io.IOException e) {
            throw new IllegalStateException("Could not load books", e);
        }
    }
}