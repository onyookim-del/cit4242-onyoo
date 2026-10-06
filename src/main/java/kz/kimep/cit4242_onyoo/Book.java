package kz.kimep.cit4242_onyoo;

public record Book(String title, String author, int pages) {

    public Book(String title, int pages) {
        this(title, "", pages);
    }

    public boolean hasMoreThan(int pageCount) {
        return pages > pageCount;
    }
}