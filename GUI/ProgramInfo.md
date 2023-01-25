#### Program Name: GUI
#### Programmer Name: Ali Rahbar
#### Program Date: January 18, 2023
#### Program Description: This program manages what happens in the GUI
#### Inputs: Event object, Animal object, ObjectManager object
#### Outputs: None

---

### IPO Chart:


| **Method Name** | **Inputs**              | **Outputs** | **Processes**                                                |
|-----------------|-------------------------|-------------|--------------------------------------------------------------|
| GUI             | title, frameSize, event | None        | Sets the properties as well as teh information for the frame |
| updateMainPage  | objectManager           | None        | updates the content on the main page                         |
| updateAddPage   | objectManager           | None        | updates the content on the addAnimal page                    |
| updateEditPage  | objectManager           | None        | updates the content on the editAnimal page                   |
| terminate       | None                    | None        | Closes the GUI object                                        |

### PseudoCode:

```text
Import required files

In the GUI class
{
    Properties
    {
        1. title
        2. frameSize
        3. frame
        4. event
    }
    
    In the constructor method
    {
        Set values to the properties
        
        Set the frame name and size and create a new border layout for it
    }
    
    In the updateMainPage method
    {
        Set closing operation for page
        
        Create the page object
        
        add it to the frame
        
        set visibility to true
    }
    
    In the updateAddPage method
    {
        Set closing operation for page
        
        Create the page object
        
        add it to the frame
        
        set visibility to true
    }
    
    In the updateEditPage method
    {
        Set closing operation for page
        
        Create the page object and pass the property
        
        add it to the frame
        
        set visibility to true
    }
    
    In the terminate method
    {
        dispose the page
    }
}
```

