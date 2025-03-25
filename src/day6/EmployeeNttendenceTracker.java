package day6;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

class EmployeeAttendenceTracker {
    private int id;
    private String name;
    private LocalDateTime lastLogin;

    public EmployeeAttendenceTracker(int id, String name, LocalDateTime lastLogin) {
        this.id = id;
        this.name = name;
        this.lastLogin = lastLogin;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Optional<LocalDateTime> getLastLogin() {
        return Optional.ofNullable(lastLogin);
    }
}

public class EmployeeNttendanceTracker {
    public static void main(String[] args) {
        List<EmployeeAttendenceTracker> employees = Arrays.asList(
            new EmployeeAttendenceTracker(1, "Alice", LocalDateTime.now().minusDays(10)),
            new EmployeeAttendenceTracker(2, "Bob", LocalDateTime.now().minusDays(5)),
            new EmployeeAttendenceTracker(3, "Charlie", LocalDateTime.now().minusDays(15)),
            new EmployeeAttendenceTracker(4, "David", LocalDateTime.now().minusDays(2)),
            new EmployeeAttendenceTracker(5, "Eve", null)
        );

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime oneWeekAgo = LocalDateTime.now().minusDays(7);

        // Employees who haven't logged in for the past 7 days
        List<Employee> inactiveEmployees = employees.stream()
            .filter(e -> e.getLastLogin().orElse(LocalDateTime.MIN).isBefore(oneWeekAgo))
            .collect(Collectors.toList());

        System.out.println("Employees who haven't logged in for the past 7 days:");
        inactiveEmployees.forEach(e -> System.out.println(e.getName() + " - " + e.getLastLogin()
                .map(formatter::format).orElse("No login record")));

        // Sort employees by last login date (oldest first)
        List<Employee> sortedEmployees = employees.stream()
            .sorted(Comparator.comparing(e -> e.getLastLogin().orElse(LocalDateTime.MIN)))
            .collect(Collectors.toList());

        System.out.println("\nEmployees sorted by last login date (oldest first):");
        sortedEmployees.forEach(e -> System.out.println(e.getName() + " - " + e.getLastLogin()
                .map(formatter::format).orElse("No login record")));
    }
}

