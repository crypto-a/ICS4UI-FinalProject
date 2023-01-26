/*****************************************
 /*Program Name: Fish
 /*Programmer Name: Ali Rahbar
 /*Program Date: January 15, 2023
 /*Program Description: This program is the object for Fish
 /*Inputs: Animal
 /*Outputs: None
 ******************************************/

package src.Objects.Fish;

import src.Objects.Base.Animal;

public class Fish extends Animal
{
    /*****************************************
     /*Method Name: Fish
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 12, 2023
     /*Method Description: This method constructs the object
     /*Method Inputs: name, age, type, color
     /*Method Outputs: None
     ******************************************/
    public Fish(String name, int age, String color, String type)
    {
        //Pass the properties to the Animal Constructor
        super(name, age, "Fish", color, type);

        //Set the sound of the cat
        setSound("Glub!");
    }
}
