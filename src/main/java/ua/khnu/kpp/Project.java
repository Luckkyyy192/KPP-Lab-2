package ua.khnu.kpp;
public final class Project {
    private final long id;
    private final String title;
    private final User owner;
    public Project(long id, String title, User owner) {
        if (id <= 0) throw new IllegalArgumentException("project id must be positive");
        if (title == null || title.isBlank()) throw new IllegalArgumentException("project title is required");
        if (owner == null) throw new IllegalArgumentException("project owner is required");
        this.id = id;
        this.title = title;
        this.owner = owner;
    }
    public long id() { return id; }
    public String title() { return title; }
    public User owner() { return owner; }
}
