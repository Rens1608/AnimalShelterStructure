import Animals.Dog;
import Animals.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class DogTest {

    private Dog dog;

    @BeforeEach
    public void testInitialize(){
        dog = new Dog( Gender.Male, "Sgt. Woof");
    }

    @Test
    public void testConstructor(){
        Assertions.assertEquals("Sgt. Woof", dog.Name);
        Assertions.assertEquals(Gender.Male, dog.Gender);
        Assertions.assertNull(dog.ReservedBy);
        Assertions.assertEquals(LocalDateTime.now().getDayOfMonth() , dog.LastWalk);
        Assertions.assertFalse(dog.NeedsWalk());
    }

    @Test
    public void TestReservation()
    {
        Assertions.assertNull(dog.ReservedBy);
        Assertions.assertTrue(this.dog.Reserve("John Doe"));
        Assertions.assertNotNull(this.dog.ReservedBy);
        Assertions.assertEquals("John Doe", this.dog.ReservedBy.Name);
        Assertions.assertFalse(this.dog.Reserve("Jane Doe"));
    }
}
