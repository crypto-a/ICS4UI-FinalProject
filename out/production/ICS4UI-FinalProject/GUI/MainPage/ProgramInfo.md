#### Program Name: Main
#### Programmer Name: Ali Rahbar
#### Program Date: January 20, 2023
#### Program Description: This program runs the code
#### Inputs: Run Object
#### Outputs: None

---

### IPO Chart:


| **Method Name**    | **Inputs**           | **Outputs**   | **Processes**                                                    |
|--------------------|----------------------|---------------|------------------------------------------------------------------|
| MainPage           | objectManager, event | None          | Set the initializes and the ActionListeners                      |
| setDisplayMethod   | None                 | None          | Changes the value for the display list depending on the comboBox |
| selectedRow        | None                 | None          | Save the selected row number to the event object                 |
| buttonClicked      | index                | None          | Logs the click of the button with the given Index                |
| requestPage        | None                 | JPanel object | Returns the JPanel object to be displayed int he GUI             |
| createUIComponents | None                 | None          | Creates the JTable and comboBox for the page                     |

### PseudoCode:

```text
Import required files

In class MainPage
{
    Properties
    {
        1.Elements of the page(imported by the Java UI Designer)
        2. event
        3. objectManager
    }
    
    In the constructor method
    {
        Set the initial values to some of the properties
        
        Add the ActionListeners for each element
        {
            1. User clicks a button
            2. User selects a Row in the table
            3. User switches between animals
        }
    }
    
    In the setDisplayList
    {
        Call the Item from the comboBox
        
        Update the DisplayList in the event object
        
        Set the rowSelected value in the object to default, "0"
    }
    
    In the selectedRow method
    {
        Log the selected row in the table to the event object
    }
    
    In the buttonClicked
    {
        Log the click of button with index 6 on event object
    }
    
    In the requestPage method
    {
        setDefault values to the textFields and comboBox
        
        return the mainPanel 
    }
    
    In the createUIComponents
    {
        Pull the active arrayList
        
        Create a 2d array from the objects
        
        Set the values to the table
        
        Set the three names for the animals to the comboBox
    }
}
```

