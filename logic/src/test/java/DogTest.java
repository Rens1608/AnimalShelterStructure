import Animals.Dog;
import Animals.Gender;
import Animals.Species;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class DogTest {

    private Dog dog;

    @BeforeEach
    public void testInitialize(){
        dog = new Dog( Gender.Male, "Sgt. Woof", 0, Species.Dog);
    }

    @Test
    public void testConstructor(){
        Assertions.assertEquals("Sgt. Woof", dog.getName());
        Assertions.assertEquals(Gender.Male, dog.getGender());
        Assertions.assertNull(dog.getReservedBy());
        Assertions.assertEquals(LocalDateTime.now().getDayOfMonth() , dog.LastWalk);
        Assertions.assertFalse(dog.NeedsWalk());
    }

    @Test
    public void TestReservation()
    {
        Assertions.assertNull(dog.getReservedBy());
        Assertions.assertTrue(this.dog.Reserve("John Doe"));
        Assertions.assertNotNull(this.dog.getReservedBy());
        Assertions.assertEquals("John Doe", this.dog.getReservedBy().Name);
        Assertions.assertFalse(this.dog.Reserve("Jane Doe"));
    }
}
