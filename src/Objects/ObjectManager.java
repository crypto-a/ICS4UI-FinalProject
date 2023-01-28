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
import database.SQLiteDB;

import java.util.*;

public class ObjectManager
{
    //Initialize the properties of the object
    private ArrayList animals = new ArrayList();
    private SQLiteDB dataBase;

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
        ArrayList<Fish> Fish = new ArrayList();


        //Set the value for the event Object
        this.event = event;
        this.dataBase = new SQLiteDB("database.db");


        //Put the address of the files in the lists
        this.animals.add(dogs);
        this.animals.add(cats);
        this.animals.add(Fish);

        //Load the data to the array lists
        loadData();
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
                /* if the chosen animal is Fish */

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

        //Change its properties
        selectedAnimal.setName(name);
        selectedAnimal.setAge(age);
        selectedAnimal.setType(type);
        selectedAnimal.setColor(color);

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

    /*****************************************
     /*Method Name: loadData
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 28, 2023
     /*Method Description: This method loads teh data from the database
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    public void loadData()
    {
        /* Load dogs */

        //Collect the array list
        ArrayList<Dog> dogs = (ArrayList<Dog>) this.animals.get(0);

        //Call the data from the database
        String[][] dataDogs = this.dataBase.getDataFromTable("Dogs");

        //Loop through the list
        for (int i = 0; i < dataDogs.length; i++)
        {
            //Add the object to the arraylist
            dogs.add(new Dog(dataDogs[i][0], Integer.parseInt(dataDogs[i][1]), dataDogs[i][2], dataDogs[i][3]));
        }

        /* Load cats */

        //Collect the array list
        ArrayList<Cat> cats = (ArrayList<Cat>) this.animals.get(1);

        //Call the data from the database
        String[][] dataCats = this.dataBase.getDataFromTable("Cats");

        //Loop through the list
        for (int i = 0; i < dataCats.length; i++)
        {
            //Add the object to the arraylist
            cats.add(new Cat(dataCats[i][0], Integer.parseInt(dataCats[i][1]), dataCats[i][2], dataCats[i][3]));
        }

        /* Load fish */

        //Collect the array list
        ArrayList<Fish> fish = (ArrayList<Fish>) this.animals.get(2);

        //Call the data from the database
        String[][] dataFish = this.dataBase.getDataFromTable("Fish");

        //Loop through the list
        for (int i = 0; i < dataFish.length; i++)
        {
            //Add the object to the arraylist
            fish.add(new Fish(dataFish[i][0], Integer.parseInt(dataFish[i][1]), dataFish[i][2], dataFish[i][3]));
        }
    }

    /*****************************************
     /*Method Name: saveData
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 28, 2023
     /*Method Description: This method loads teh data to the database
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    public void saveData()
    {
        /* save dogs */

        //Collect the array list
        ArrayList<Dog> dogs = (ArrayList<Dog>) this.animals.get(0);

        //Construct the 2d array
        String[][] dogArray = new String[dogs.size()][4];

        //Only if the list is not empty
        if (dogs.size() != 0)
        {
            //Loop through every element in the dogs arraylist
            for (int i = 0; i < dogs.size(); i++)
            {


                //Add the properties to the arrayList
                dogArray[i] = new String[] {dogs.get(i).getName(), Integer.toString(dogs.get(i).getAge()), dogs.get(i).getType(), dogs.get(i).getColor()};
            }

        }

        //Save the arrays to the database
        this.dataBase.writeToTable("Dogs", dogArray);


        /* save cats */

        //Collect the array list
        ArrayList<Cat> cats = (ArrayList<Cat>) this.animals.get(1);

        //Construct the 2d array
        String[][] catArray = new String[cats.size()][4];

        //Only if the list is not empty
        if (cats.size() != 0)
        {
            //Loop through every element in the dogs arraylist
            for (int i = 0; i < cats.size(); i++)
            {


                //Add the properties to the arrayList
                catArray[i] = new String[] {cats.get(i).getName(), Integer.toString(cats.get(i).getAge()), cats.get(i).getType(), cats.get(i).getColor()};
            }

        }

        this.dataBase.writeToTable("Cats", catArray);

        /* save Fish */

        //Collect the array list
        ArrayList<Fish> fish = (ArrayList<Fish>) this.animals.get(2);

        //Construct the 2d array
        String[][] fishArray = new String[fish.size()][4];

        //Only if the list is not empty
        if (fish.size() != 0)
        {
            //Loop through every element in the dogs arraylist
            for (int i = 0; i < fish.size(); i++)
            {


                //Add the properties to the arrayList
                fishArray[i] = new String[] {fish.get(i).getName(), Integer.toString(fish.get(i).getAge()), fish.get(i).getType(), fish.get(i).getColor()};
            }

        }

        this.dataBase.writeToTable("Fish", fishArray);


        //Disconnect the database
        this.dataBase.closeDB();
    }
}
