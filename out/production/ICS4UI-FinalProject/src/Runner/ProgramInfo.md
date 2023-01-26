#### Program Name: Run
#### Programmer Name: Ali Rahbar
#### Program Date: January 20, 2023
#### Program Description: This program manages the general functionality of the code
#### Inputs: ObjectManager, Event, GUI
#### Outputs: None

---

### IPO Chart:


| **Method Name**  | **Inputs**           | **Outputs**          | **Processes**                                                               |
|------------------|----------------------|----------------------|-----------------------------------------------------------------------------|
| Run              | None                 | None                 | Creates the ObjectManager object and calls the eventHandler method for ever |
| eventHandler     | None                 | None                 | Collects the user input and depending on choice calls the related function  |
| addAnimal        | None                 | None                 | Collects userInput and passed it to the objectManager addAnimal method      |
| editAnimal       | possibleAnimalSelect | None                 | Collects userInput and passed it to the objectManager editAnimal method     |
| deleteAnimal     | possibleAnimalSelect | None                 | Collects userInput and passed it to the objectManager deleteAnimal method   |
| sortByName       | None                 | None                 | Calls the sortByName method in objectManager                                |
| sortByAge        | None                 | None                 | Calls the sortByAge method in objectManager                                 |

### PseudoCode:

```text
Import required files


Create a Run Object
{
    Set the following properties
    {
         1. objectManager
         2. event
         3. mainGui
    }
    
    In the Run method
    {
        Create a new ObjectManager
        
        Loop forever
        {
            Call the eventHandler Method
        }
    }
    
    In the eventHandler method
    {
        
        Collect the user Event input using the event object
        
        Run on of the following methods depending on user choice
        {
            1: addAnimal
            2: editAnimal
            3: deleteAnimal
            4: Do nothing
            5: sortByName
            6: sortByAge
            default: Do nothing
        }
    }
    
    In the addAnimal method
    {
        Create the addAnimalPage
        
        Wait until user submits the page, if the operation is canceled terminate page and return
        
        Collect user input from the event object
        
        Pass the collected value to the objectManager to do said operation
        
        Terminate page
        
        End event
    }
    
    In the editAnimalMethod
    {
        Break out of the method if there is no value selected in the list or the list is empty
        Create the addAnimalPage
        
        Wait until user submits the page, if the operation is canceled terminate page and return
        
        Collect user input from the event object
        
        Pass the collected value to the objectManager to do said operation
        
        Terminate page
        
        End event
    }
    
    In the deleteAnimalMethod
    {
        Collect the index of the animal the user has selected in the row
        
        Pass the collected value to the objectManager to do said operation
        
        End Event
    }
    
    In the sortByName method
    {
        Call the related sort method in the objectManager
        
        End Event
    }
    
    In the sortByAge method
    {
        Call the related sort method in the objectManager
        
        End Event
    }
}
```
