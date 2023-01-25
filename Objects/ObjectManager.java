/*****************************************
 /*Program Name: ObjectManager
 /*Programmer Name: Ali Rahbar
 /*Program Date: January 20, 2023
 /*Program Description: This program manages the lists of each of the animal groups
 /*Inputs: Animal, Cats, Dog, Fish
 /*Outputs: None
 ******************************************/

package Objects;

//Import required classes
import GUI.Event.Event;
import Objects.Dog.Dog;
import Objects.Cat.Cat;
import Objects.Fish.Fish;
import Objects.Base.Animal;
import java.util.*;

public class ObjectManager
{
    //Initialize the properties of the object
    private ArrayList animals = new ArrayList();

    private Event event;

    /*****************************************
     /*Method Name: ObjectManager
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 20, 2023
     /*Method Description: This method constructs the object
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    public ObjectManager(Event event)
    {
        //Initialize the three arraylists
        ArrayList<Dog> dogs = new ArrayList();
        ArrayList<Cat> cats = new ArrayList();
        ArrayList<Fish> fishes = new ArrayList();


        //Set the value for the event Object
        this.event = event;


        //Put the address of the files in the lists
        this.animals.add(dogs);
        this.animals.add(cats);
        this.animals.add(fishes);

        //Add multiple type of dogs to the array list
        dogs.add(new Dog("Barkley", 3, "Golden Retriever", "Golden"));
        dogs.add(new Dog("Rufus", 5, "Shih Tzu", "Brown and White"));
        dogs.add(new Dog("Daisy", 2, "Beagle", "Tri-colored"));
        dogs.add(new Dog("Max", 4, "Labrador Retriever", "Black"));
        dogs.add(new Dog("Lola", 6, "Pomeranian", "Orange"));

        //Add multiple types of cats to the array list
        cats.add(new Cat("Whiskers", 2, "Siamese", "Gray"));
        cats.add(new Cat("Socks", 4, "Tabby", "White and Brown"));
        cats.add(new Cat("Mittens", 6, "Persian", "White"));
        cats.add(new Cat("Bella", 1, "Sphynx", "Hairless"));
        cats.add(new Cat("Oliver", 3, "Maine Coon", "Orange"));

        //Add multiple types of fishes to the array list
        fishes.add(new Fish("Nemo", 1, "Clownfish", "Orange"));
        fishes.add(new Fish("Dory", 2, "Tang", "Blue and Yellow"));
        fishes.add(new Fish("Bubbles", 3, "Goldfish", "Gold"));
        fishes.add(new Fish("Gill", 4, "Angelfish", "Black and White"));
        fishes.add(new Fish("Jacques", 5, "Cleaner Shrimp", "Brown"));
    }

    /*****************************************
     /*Method Name: pullData
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 20, 2023
     /*Method Description: This method returns teh data of the chosen type of animal as an untyped arraylist
     /*Method Inputs: None
     /*Method Outputs: ArrayList
     ******************************************/
    public ArrayList pullData()
    {
        //Turn the typed list into an unordered list and return it
        return (ArrayList) this.animals.get(this.event.displayList());
    }

    /*****************************************
     /*Method Name: sortByAge
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 20, 2023
     /*Method Description: This method sorts the chosen arraylist by age
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    public void sortByAge()
    {
        //Sort the chosen animal list by age
        Animal.sortByAge((List<Animal>) this.animals.get(this.event.displayList()));
    }

    /*****************************************
     /*Method Name: sortByName
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 20, 2023
     /*Method Description: This method sorts the object by name
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    public void sortByName()
    {
        //Sort the list of the chosen animal by its name
        Animal.sortByName((List<Animal>) this.animals.get(this.event.displayList()));
    }

    /*****************************************
     /*Method Name: addAnimal
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 20, 2023
     /*Method Description: This method adds a new animal to the selected array list
     /*Method Inputs: name, age, type, color
     /*Method Outputs: None
     ******************************************/
    public void addAnimal(String name, int age, String type, String color)
    {
        //Save the chosen animal Arraylist to a variable
        List<Animal> animal = (List<Animal>) this.animals.get(this.event.displayList());

        //Depending on hat animal was chosen
        switch (this.event.displayList())
        {
            case 0:
                /* if the chosen animal is dogs */

                //Add teh new dog to the list
                animal.add(new Dog(name, age, type, color));

                //Break out of the switch statement
                break;

            case 1:
                /* if the chosen animal is cats */

                //Add the new cat to the list
                animal.add(new Cat(name, age, type, color));

                //Break out of the switch statement
                break;

            case 2:
                /* if the chosen animal is fishes */

                //Add the new Fish to the list
                animal.add(new Fish(name, age, type, color));

                //Break out of the switch statement
                break;
        }

    }

    /*****************************************
     /*Method Name: editAnimal
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 20, 2023
     /*Method Description: This method edits the properties of an animal of a selected array list
     /*Method Inputs: name, age, type, color, editAnimal
     /*Method Outputs: None
     ******************************************/
    public void editAnimal(String name, int age, String type, String color, int editAnimal)
    {
        //Save the chosen array list to a variable
        List<Animal> animal = (List<Animal>) this.animals.get(this.event.displayList());

        //Pull out the object that is being edited
        Animal selectedAnimal = animal.get(editAnimal-1);

        //Change its properties only if the default value has changes
        if (!(name == ""))
        {
            //Change name
            selectedAnimal.setName(name);
        }

        if (!(age == 0))
        {
            //Change Age
            selectedAnimal.setAge(age);
        }

        if (!(type == ""))
        {
            //Change Type
            selectedAnimal.setType(type);
        }


        if (!(color == ""))
        {
            //Change Color
            selectedAnimal.setColor(color);
        }

    }

    /*****************************************
     /*Method Name: deleteAnimal
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 20, 2023
     /*Method Description: This method deleted the chosen animal form the selected array list
     /*Method Inputs: deleteAnimal
     /*Method Outputs: None
     ******************************************/
    public void deleteAnimal(int deletedAnimal)
    {
        //Save the value of the chosen list to a new variable
        List<Animal> animal = (List<Animal>) this.animals.get(this.event.displayList());

        //Remove the selected object from it
        animal.remove(deletedAnimal - 1);

    }
}
