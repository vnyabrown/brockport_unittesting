package animals.petstore.pet.types; // package together with petstore model

// Import all relevant pet model and attributes
import animals.AnimalType;
import animals.petstore.pet.Pet;
import animals.petstore.pet.attributes.Breed;
import animals.petstore.pet.attributes.Gender;
import animals.petstore.pet.attributes.PetType;
import animals.petstore.pet.attributes.Skin;

import java.math.BigDecimal;

/**
 * Bird attributes
 */
public class Bird extends Pet implements PetImpl {

    /* Properties */
    private int numberOfLegs;
    private Breed breed;

    /**
    * Constructor, define attributes
    * @param animalType {@link AnimalType} that defines if it domesticated or wild bird
    * @param skinType The {@link Skin} of the bird
    * @param gender The {@link Gender} of the bird
    * @param breed The type of bird {@link Breed}
    */
    public Bird(AnimalType animalType, Skin skinType, Gender gender, Breed breed)
    {
        this(animalType, skinType, gender, breed, new BigDecimal(0));
    } // end of Bird constructor

    /**
     * Constructor, define attributes w/ cost
     * @param animalType {@link AnimalType} that defines if it domesticated or wild bird
     * @param skinType The {@link Skin} of the bird
     * @param gender The {@link Gender} of the bird
     * @param breed The type of bird {@link Breed}
     * @param cost The cost of the bird
     */

    public Bird(AnimalType animalType, Skin skinType, Gender gender, Breed breed, BigDecimal cost)
    {
        this(animalType, skinType, gender, breed, cost,0);
    } // end of Bird constructor (cost)

    /**
     * Constructor, define and initializing attributes w/ cost and petstore id
     * @param animalType {@link AnimalType} that defines if it domesticated or wild bird
     * @param skinType The {@link Skin} of the bird
     * @param gender The {@link Gender} of the bird
     * @param breed The type of bird {@link Breed}
     * @param cost The cost of the bird
     * @param petStoreId The pet store id
     */
    public Bird(AnimalType animalType, Skin skinType, Gender gender, Breed breed, BigDecimal cost, int petStoreId)
    {
        super(PetType.BIRD, cost, gender, petStoreId);
        super.skinType = skinType;
        super.animalType = animalType;
        this.numberOfLegs = 2;
        this.breed = breed;
    } // end of Bird Constructor (cost, petstoreid)

    /**
     * Is the bird allergy friendly determined by skin type
     * @return A message that tells if the bird is hypoallergenic
     */
    public String birdHypoallergenic()
    {
        return super.petHypoallergenic(this.skinType).replaceAll("pet", "bird");
    } // end of birdHypoallergenic

    /**
     * Depending on if the bird is domestic, wild, or neither what can the say
     * @return what birds would speak
     */
    public String speak()
    {
        String language;
        switch (this.animalType)
        {
            case DOMESTIC:
                language = "The bird goes chirp! chirp!";
                break;
            case WILD:
                language = "The bird goes AAA! AAA!";
            default:
                language = "The bird goes " + super.getPetType().speak + "! " + super.getPetType().speak + "!";
                break;
        }
        return language;
    } // end of speak

    private String numberOfLegs()
    {
        return "Birds have " + numberOfLegs + " legs!";
    } // end of numberOfLegs

    public int getNumberOfLegs()
    {
        return numberOfLegs;
    } // end of getNumberOfLegs

    public void setNumberOfLegs(int numberOfLegs)
    {
        this.numberOfLegs = numberOfLegs;
    } // end of setNumberOfLegs

    /**
     * {@inheritDoc}
     */
    // Functions to return bird attributes
    public Breed getBreed() {
        return this.breed;
    }
    public String typeOfPet() {
        return "The type of pet is " + petType + "!";
    }
    public AnimalType getAnimalType()
    {
        return super.animalType;
    } // end of getAnimalType

    // Output bird attributes as a string
    @Override
    public String toString() {
        return super.toString() +
                "The bird is " + this.animalType + "!\n" +
                "The bird breed is " + this.getBreed() + "!\n" +
                this.birdHypoallergenic() + "!\n" +
                this.speak() + "\n" +
                this.numberOfLegs();
    }

} // end of Bird class
