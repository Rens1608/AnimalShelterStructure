import Animals.Animal;
import Animals.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AnimalTest {

    private Animal animal;

    @BeforeEach
    public void testInitialize(){
        animal = new Animal(Gender.Male, "Ugly Duckling");
    }

    @Test
    public void testConstructor(){
        Assertions.assertEquals("Ugly Duckling", animal.Name);
        Assertions.assertEquals(Gender.Male, animal.Gender);
        Assertions.assertNull(animal.ReservedBy);
    }

    @Test
    public void TestReservation()
    {
        Assertions.assertNull(animal.ReservedBy);
        Assertions.assertTrue(this.animal.Reserve("John Doe"));
        Assertions.assertNotNull(this.animal.ReservedBy);
        Assertions.assertEquals("John Doe", this.animal.ReservedBy.Name);
        Assertions.assertFalse(this.animal.Reserve("Jane Doe"));
    }
}
