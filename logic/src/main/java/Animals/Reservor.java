package Animals;

import java.time.LocalDateTime;

public class Reservor {
    public String Name;
    public LocalDateTime ReservedAt;

    public Reservor() {
    }

    public Reservor(String name, LocalDateTime reservedAt) {
        Name = name;
        ReservedAt = reservedAt;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public LocalDateTime getReservedAt() {
        return ReservedAt;
    }

    public void setReservedAt(LocalDateTime reservedAt) {
        ReservedAt = reservedAt;
    }
}
