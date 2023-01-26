#### Program Name: AddAnimalPage
#### Programmer Name: Ali Rahbar
#### Program Date: January 19, 2023
#### Program Description: This program controls the content in the addAnimalPage
#### Inputs: Event object
#### Outputs: None

---

### IPO Chart:


| **Method Name** | **Inputs** | **Outputs**              | **Processes**                                            |
|-----------------|------------|--------------------------|----------------------------------------------------------|
| AddAnimalPage   | event      | None                     | Set initial values and actionListeners                   |
| requestPage     | animal     | JPanel object            | Returns the JPanel Object so it can be shown in the page |
| pushText        | index      | None                     | Writes the value in each textField to the event object   |
| buttonClicked   | None       | None                     | Logs the click of the button to the event object         |


### PseudoCode:

```text
Import required files

In class AddAnimalPage
{
    Properties
    {
        1.Elements of the page(imported by the Java UI Designer)
        2. event
    }
    
    In the constructor method
    {
        Set the initial values to some of the properties
        Add an integer input validator for the age field
        
        Add the ActionListeners for each element
        {
            1. When the submit button is clicked
            2. When user writes something to the nameField
            3. When user writes something to the ageField
            4. When user writes something to the typeField
            5. When user writes something to the colorField
        }
    }
    
    In the requestPage method
    {
        return the mainPanel 
    }
    
    In the pushText method
    {
        Depending on field that is being filed
        {
            0: write the nameField in the  index 0 of the inputValues in the arrayList
            1: write the ageField in the index 1 of the inputValues in the arrayList
            2: write the typeField in the index 2 of the inputValues in the arrayList
            3: write the colorField in the index 3 of the inputValues in the arrayList
        }
    }
    
    In the buttonClicked
    {
        Check is all values are filed
        {
            Log the click of button with index 6 on event object
        }
        else
        {
            return and cancel operation
        }
    }
}
```

