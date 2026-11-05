package ua.khnu.kpp;
import java.time.LocalDate;
public final class App {
    private App() { }
    public static void main(String[] args) {
        User curator = new User(1, "Олена — куратор музею");
        User researcher = new User(2, "Ігор — каталогізатор");
        Project museum = new Project(1, "Каталог музейної колекції", curator);
        LocalDate created = LocalDate.of(2026, 9, 10);
        Task task = new Task(1, "Опис експонатів", museum,
                             created, created.plusDays(7), new VariantPolicy());
        System.out.println("Початковий стан: " + task.status());
        task.assign(researcher);
        task.start();
        System.out.println("Після start: " + task.status());
        try {
            task.complete(created.plusDays(5), 12, 4, false);
        } catch (IllegalStateException exception) {
            System.out.println("Відмова правила: " + exception.getMessage());
            System.out.println("Стан після відмови: " + task.status());
        }
        task.complete(created.plusDays(5), 12, 3, false);
        System.out.println("Після успішного завершення: " + task.status());
    }
}
