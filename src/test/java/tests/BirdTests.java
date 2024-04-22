package tests;

//Imports
import animals.petstore.pet.types.Dog;
import org.junit.jupiter.api.*;
import animals.AnimalType;
import animals.petstore.pet.attributes.Breed;
import animals.petstore.pet.attributes.Gender;
import animals.petstore.pet.attributes.Skin;
import animals.petstore.pet.types.Bird;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // define a test order for our tests
public class BirdTests {
    private static Bird actualBird;
    @BeforeAll // This will be run before any following method/test
    public static void createAnimals()
    {
        // This will set the initial attributes for the bird we will use in our tests
        actualBird = new Bird(AnimalType.DOMESTIC, Skin.FEATHERS, Gender.UNKNOWN, Breed.UNKNOWN);
    } // end of createAnimals

    @Test
    @Order(1)
    @DisplayName("Animal Test Type Tests Domestic")
    public void animalTypeTests()
    {
        assertEquals(AnimalType.DOMESTIC, actualBird.getAnimalType(), "Animal Type Expected[" + AnimalType.DOMESTIC
                + "] Actual [" + actualBird.getAnimalType() + "]");
    } // end of animalTypeTests

    @Test
    @Order(1)
    @DisplayName("Bird Speak Chirp Tests")
    public void birdGoesChirpTest()
    {
        assertEquals("The bird goes chirp! chirp!", actualBird.speak(), "I was expecting chirp! chirp!");
    } // end of birdGoesChirpTest

    @Test
    @Order(1)
    @DisplayName("Bird Feathers is it Hyperallergetic")
    public void birdHyperAllergeticTests()
    {
        assertEquals("The bird is not hyperallergetic!", actualBird.birdHypoallergenic(),
                "The bird is not hyperallergetic!");
    } // end of birdHyperAllergeticTests

    @Test
    @Order(1)
    @DisplayName("Bird has legs Test")
    public void legTests()
    {
        Assertions.assertNotNull(actualBird.getNumberOfLegs());
    } // end of legTests

    @Test
    @Order(2)
    @DisplayName("Bird Gender Test FeMale")
    public void genderTestFeMale()
    {
        actualBird = new Bird(AnimalType.WILD, Skin.UNKNOWN,Gender.FEMALE, Breed.UNKNOWN);
        assertEquals(Gender.FEMALE, actualBird.getGender(), "Expecting FeMale Gender!");
    } // end of genderTestFemale

    @Test
    @Order(2)
    @DisplayName("Dog Breed Test Hawk")
    public void genderBirdBreed() {
        actualBird = new Bird(AnimalType.WILD, Skin.UNKNOWN,Gender.FEMALE, Breed.HAWK);
        assertEquals(Breed.HAWK, actualBird.getBreed(), "Expecting Breed Hawk!");
    } // end of genderBirdBreed

    @Test
    @Order(2)
    @DisplayName("Bird Speak AAA Tests")
    public void birdGoesAAATest()
    {
        actualBird = new Bird(AnimalType.WILD, Skin.UNKNOWN,Gender.UNKNOWN, Breed.UNKNOWN);
        assertEquals("The bird goes AAA! AAA!", actualBird.speak(), "I was expecting AAA!");
    } // end of birdGoesAAATest

    @Test
    @Order(2)
    @DisplayName("Bird Speak Chirp Tests")
    public void birdGoesPeepTest()
    {
        actualBird = new Bird(AnimalType.UNKNOWN, Skin.UNKNOWN,Gender.UNKNOWN, Breed.UNKNOWN);
        assertEquals("The bird goes Peep! Peep!", actualBird.speak(), "I was expecting Chirp!");
    } // end of birdGoesPeepTest
}
