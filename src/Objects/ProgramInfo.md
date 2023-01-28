#### Program Name: ObjectManager
#### Programmer Name: Ali Rahbar
#### Program Date: January 20, 2023
#### Program Description: This program manages the lists of each of the animal groups
#### Inputs: Animal Object, Cat Object, Dog Object, Fish Object
#### Outputs: None

---

### IPO Chart:


| **Method Name**   | **Inputs**                         | **Outputs**      | **Processes**                                                        |
|-------------------|------------------------------------|------------------|----------------------------------------------------------------------|
| ObjectManager     | None                               | None             | Creates an animal object for the cat and gives it its properties     |
| pullData          | None                               | ArrayList Animal | Converts the active arraylist to non typed array list and returns it |
| sortByAge         | None                               | None             | Sorts the active array by age                                        |
| sortByName        | None                               | None             | Sorts the active array by name                                       |
| setSelectedAnimal | newIndex                           | None             | This method changes the active animal                                |
| addAnimal         | name, age, type, color             | None             | Crates a new class of said animal and adds it to the arraylist       |
| editAnimal        | name, age, type, color, editAnimal | None             | Change the properties of and animal                                  |
| deleteAnimal      | deleteAnimal                       | None             | delete the animal object                                             |
| loadData          | None                               | None             | Pull the data from the database                                      |
| saveData          | None                               | None             | Push the data to the database                                        |

### PseudoCode:

```text
Import required files


Create an ObjectManager object
{
    Properties
    {
        1. animals ArrayList
        2. Event event
    }
    In the ObjectManager method
    {
        Create 3 new arraylists
        
        Add them to a list and save the list as the object property
        
        Create new default values for each of the objects and add them to their arraylists
    }
    
    In the pullData method
    {
        Convert the active arraylist to an untyped arraylist and return it
    }
    
    In the sortByAge method
    {
        Using the methods in the animal object, sort the active arraylist by age
    }
    
    In ths sortByName method
    {
        Using the methods in the animal object, sort the active arraylist by Name
    }
    
    In the setSelectedAnimal method
    {
        Change the value of the selectedAnimal property
    }
    
    In the addAnimal method
    {
        Depending on the active arrayList
        {
            Add the said animal to the said arrayList
        }
    }
    
    In the editAnimal method
    {
        Call the chosen object and change its properties useing the methods in the Animal Object
    }
    
    In the deleteAnimal method
    {
        Delete the animal Object in the active arrayList with the chosen index
    }
    
    In the loadData method
    {
        Collect the data from the database and save it to the array lists
    }
    
    In the saveData method
    {
        Load the data to the database
    }
}
```
