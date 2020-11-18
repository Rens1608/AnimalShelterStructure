import Animals.Animal;
import Animals.Cat;
import Animals.Gender;
import Animals.Species;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AnimalTest {

    private Animal animal;

    @BeforeEach
    public void testInitialize(){
        animal = new Cat(Gender.Male, "Ugly Duckling", "scratches", 0, Species.Cat);
    }

    @Test
    public void testConstructor(){
        Assertions.assertEquals("Ugly Duckling", animal.getName());
        Assertions.assertEquals(Gender.Male, animal.getGender());
        Assertions.assertNull(animal.getReservedBy());
    }

    @Test
    public void TestReservation()
    {
        Assertions.assertNull(animal.getReservedBy());
        Assertions.assertTrue(this.animal.Reserve("John Doe"));
        Assertions.assertNotNull(this.animal.getReservedBy());
        Assertions.assertEquals("John Doe", this.animal.getReservedBy().Name);
        Assertions.assertFalse(this.animal.Reserve("Jane Doe"));
    }
}
