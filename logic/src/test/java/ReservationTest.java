import Animals.Animal;
import Animals.Cat;
import Animals.Gender;
import Reservation.Reservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReservationTest {
    private Reservation reservation;

    @BeforeEach
    public void TestInitialize()
    {
        this.reservation = new Reservation();
    }

    @Test
    public void TestNewCat()
    {
        List<Animal> animals = reservation.getAnimals();
        Assertions.assertEquals(0, animals.size());
        this.reservation.newCat("Ms. Meow", Gender.Female, "Scratches couch");
        Assertions.assertEquals(1, animals.size());
    }

    @Test
    public void TestNewDog()
    {
        List<Animal> animals = reservation.getAnimals();
        Assertions.assertEquals(0, animals.size());
        this.reservation.newDog("Sgt. Woof", Gender.Male);
        Assertions.assertEquals(1, animals.size());
    }
}
