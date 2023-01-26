/*****************************************
 /*Program Name: Dog
 /*Programmer Name: Ali Rahbar
 /*Program Date: January 15, 2023
 /*Program Description: This program is the object for dogs
 /*Inputs: Animal
 /*Outputs: None
 ******************************************/

package Objects.Dog;

import Objects.Base.Animal;



public class Dog extends Animal
{
    /*****************************************
     /*Method Name: Dog
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 12, 2023
     /*Method Description: This method constructs the object
     /*Method Inputs: name, age, type, color
     /*Method Outputs: None
     ******************************************/
    public Dog(String name, int age, String type, String color)
    {
        //Pass the properties to the Animal Constructor
        super(name, age, "Dog", color, type);

        //Set the sound of the cat
        setSound("Woof!");
    }
}

