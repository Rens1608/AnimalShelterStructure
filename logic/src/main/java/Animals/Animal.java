package Animals;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Animal implements Serializable {
    public Gender Gender;
    public String Name;
    public Reservor ReservedBy;

    public Animal(Animals.Gender gender, String name) {
        Gender = gender;
        Name = name;
    }

    public Animals.Gender getGender() {
        return Gender;
    }

    public void setGender(Animals.Gender gender) {
        Gender = gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Reservor getReservedBy() {
        return ReservedBy;
    }

    public void setReservedBy(Reservor reservedBy) {
        ReservedBy = reservedBy;
    }

    public boolean Reserve(String reservedBy){
        if(ReservedBy == null){
            LocalDateTime date = LocalDateTime.now();
            ReservedBy = new Reservor(reservedBy, date);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String reserved = "not reserved";
        if(ReservedBy != null){
            reserved = "reserved by: " + ReservedBy.Name;
        }
        return Name + ',' + Gender + ',' + reserved ;
    }
}
