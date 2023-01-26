/*****************************************
 /*Program Name: Cat
 /*Programmer Name: Ali Rahbar
 /*Program Date: January 12, 2023
 /*Program Description: This program is the cat object
 /*Inputs: None
 /*Outputs: None
 ******************************************/

package src.Objects.Cat;

import src.Objects.Base.Animal;

public class Cat extends Animal
{
    /*****************************************
     /*Method Name: Cat
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 12, 2023
     /*Method Description: This method constructs the object
     /*Method Inputs: name, age, color, type
     /*Method Outputs: None
     ******************************************/
    public Cat(String name, int age, String color, String type)
    {
        //Pass the properties to the Animal Constructor
        super(name, age, "Cat", color, type);

        //Set the sound of the cat
        setSound("Miaow!");
    }
}
