package ua.khnu.kpp;
public final class User {
    private final long id;
    private final String name;
    public User(long id, String name) {
        if (id <= 0) throw new IllegalArgumentException("user id must be positive");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("user name is required");
        this.id = id;
        this.name = name;
    }
    public long id() { return id; }
    public String name() { return name; }
    @Override public boolean equals(Object other) {
        return this == other || other instanceof User user && this.id == user.id;
    }
    @Override public int hashCode() { return Long.hashCode(id); }
}
