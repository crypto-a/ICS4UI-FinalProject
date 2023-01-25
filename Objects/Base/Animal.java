/*****************************************
 /*Program Name: Animal
 /*Programmer Name: Ali Rahbar
 /*Program Date: January 12, 2023
 /*Program Description: This program is the animal object
 /*Inputs: None
 /*Outputs: None
 ******************************************/

package Objects.Base;


//Import required Classes
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class Animal implements Comparable<Animal>
{
    //Initialize properties
    private String name;
    private final String species;
    private int age;
    private String color;
    private String sound;

    private String type;

    /*****************************************
     /*Method Name: Animal
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 12, 2023
     /*Method Description: This method constructs the object
     /*Method Inputs: name, age, species, color, type
     /*Method Outputs: None
     ******************************************/
    public Animal(String name, int age, String species, String color, String type)
    {
        //Set the initial values for the main properties
        this.name = name;
        this.age = age;
        this.species = species;
        this.color = color;
        this.type = type;
    }

    /*****************************************
     /*Method Name: setSound
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 12, 2023
     /*Method Description: This method sets a value for the sound tha the animal makes
     /*Method Inputs: sound
     /*Method Outputs: None
     ******************************************/
    public void setSound (String sound)
    {
        //Set the sound to the user input
        this.sound = sound;
    }

    /*****************************************
     /*Method Name: getName
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 12, 2023
     /*Method Description: This method returns the name property of the animal
     /*Method Inputs: None
     /*Method Outputs: name
     ******************************************/
    public String getName()
    {
        //Return the name property of the object
        return this.name;
    }

    /*****************************************
     /*Method Name: getAge
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 12, 2023
     /*Method Description: This method returns the age property of the animal
     /*Method Inputs: None
     /*Method Outputs: age
     ******************************************/
    public int getAge()
    {
        //Return the age of the animal
        return this.age;
    }

    /*****************************************
     /*Method Name: getSpecies
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 12, 2023
     /*Method Description: This method returns the species property of the animal
     /*Method Inputs: None
     /*Method Outputs: species
     ******************************************/
    public String getSpecies()
    {
        //Return the species property of the animal
        return this.species;
    }

    /*****************************************
     /*Method Name: getColor
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 12, 2023
     /*Method Description: This method returns the color property of the animal
     /*Method Inputs: None
     /*Method Outputs: color
     ******************************************/
    public String getColor()
    {
        //Return the color property of the animal
        return this.color;
    }

    /*****************************************
     /*Method Name: getSound
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 12, 2023
     /*Method Description: This method returns the sound property of the animal
     /*Method Inputs: None
     /*Method Outputs: sound
     ******************************************/
    public String getSound()
    {
        //Return the species property of the animal
        return this.sound;
    }

    /*****************************************
     /*Method Name: getType
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 12, 2023
     /*Method Description: This method returns the type property of the animal
     /*Method Inputs: None
     /*Method Outputs: type
     ******************************************/
    public String getType()
    {
        //Return the type property of the animal
        return this.type;
    }

    /*****************************************
     /*Method Name: compareTo
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 12, 2023
     /*Method Description: This method overrides the compare to method in the comparable class
     /*Method Inputs: other animal
     /*Method Outputs: Comparison value
     ******************************************/
    @Override
    public int compareTo(Animal other)
    {
        //Return the compare value of the two objects age
        return Integer.compare(this.getAge(), other.getAge());
    }

    /*****************************************
     /*Method Name: sortByAge
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 12, 2023
     /*Method Description: This method sorts the given list by their age
     /*Method Inputs: list
     /*Method Outputs: None
     ******************************************/
    public static void sortByAge(List<Animal> list)
    {
        //Sort the list given by their age
        Collections.sort(list);
    }

    /*****************************************
     /*Method Name: sortByName
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 12, 2023
     /*Method Description: This method sorts the given list by their names
     /*Method Inputs: list
     /*Method Outputs: None
     ******************************************/
    public static void sortByName(List<Animal> list)
    {

        //Sort the objects by their names
        list.sort(new Comparator<Animal>() {
            @Override
            public int compare(Animal a1, Animal a2) {

                return a1.getName().compareTo(a2.getName());
            }
        });
    }

    /*****************************************
     /*Method Name: setName
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 12, 2023
     /*Method Description: This method givens the name property a new value
     /*Method Inputs: name
     /*Method Outputs: None
     ******************************************/
    public void setName(String name)
    {

        //Change the name property
        this.name = name;
    }

    /*****************************************
     /*Method Name: setAge
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 12, 2023
     /*Method Description: This method givens the age property a new value
     /*Method Inputs: age
     /*Method Outputs: None
     ******************************************/
    public void setAge(int age)
    {
        //Change the age property
        this.age = age;
    }

    /*****************************************
     /*Method Name: setType
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 12, 2023
     /*Method Description: This method givens the type property a new value
     /*Method Inputs: type
     /*Method Outputs: None
     ******************************************/
    public void setType(String type)
    {
        //Change the type property
        this.type = type;
    }

    /*****************************************
     /*Method Name: setColor
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 12, 2023
     /*Method Description: This method givens the color property a new value
     /*Method Inputs: color
     /*Method Outputs: None
     ******************************************/
    public void setColor(String color)
    {
        //Change the color property
        this.color = color;
    }
}