package ua.khnu.kpp;
import java.time.LocalDate;
public final class Task {
    private final long id;
    private final String title;
    private final Project project;
    private final LocalDate created;
    private final LocalDate due;
    private final CompletionPolicy policy;
    private Status status;
    private User assignee;

    public Task(long id, String title, Project project, LocalDate created,
                LocalDate due, CompletionPolicy policy) {
        if (id <= 0) throw new IllegalArgumentException("task id must be positive");
        if (title == null || title.isBlank()) throw new IllegalArgumentException("task title is required");
        if (project == null || created == null || due == null || policy == null)
            throw new IllegalArgumentException("project, dates and policy are required");
        if (due.isBefore(created)) throw new IllegalArgumentException("due date is before creation");
        this.id = id;
        this.title = title;
        this.project = project;
        this.created = created;
        this.due = due;
        this.policy = policy;
        this.status = Status.NEW;
        this.assignee = null;
    }
    public long id() { return id; }
    public String title() { return title; }
    public Project project() { return project; }
    public LocalDate created() { return created; }
    public LocalDate due() { return due; }
    public Status status() { return status; }
    public User assignee() { return assignee; }

    public void assign(User user) {
        if (status != Status.NEW) throw new IllegalStateException("assignment only allowed in NEW");
        if (user == null) throw new IllegalArgumentException("assignee is required");
        assignee = user;
    }
    public void start() {
        if (status != Status.NEW) throw new IllegalStateException("start only allowed in NEW");
        if (assignee == null) throw new IllegalStateException("assign a user first");
        status = Status.ACTIVE;
    }
    public void complete(LocalDate date, int units, int defects, boolean approved) {
        if (status != Status.ACTIVE) throw new IllegalStateException("completion only allowed in ACTIVE");
        if (date == null || date.isBefore(created))
            throw new IllegalArgumentException("completion date is invalid");
        if (units < 0 || defects < 0)
            throw new IllegalArgumentException("evidence values must be non-negative");
        if (!policy.allows(units, defects, approved))
            throw new IllegalStateException("completion policy rejected evidence");
        status = Status.DONE;
    }
}
