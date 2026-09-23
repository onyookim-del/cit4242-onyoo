package kz.kimep.cit4242_onyoo;

public record Book(String title, int pages) {

    public boolean hasMoreThan(int pageCount) {
        return pages > pageCount;
    }
}