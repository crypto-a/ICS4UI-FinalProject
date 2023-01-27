#### Program Name: Event
#### Programmer Name: Ali Rahbar
#### Program Date: January 21, 2023
#### Program Description: This program tracks the events happening in the code
#### Inputs: Event Object
#### Outputs: None

---

### IPO Chart:


| **Method Name**     | **Inputs**   | **Outputs**      | **Processes**                                                                  |
|---------------------|--------------|------------------|--------------------------------------------------------------------------------|
| Event               | None         | None             | Set initialValues                                                              |
| resetInput          | None         | None             | Set's a default value to the inputValues string                                |
| startEvent          | None         | None             | Set's isEventHappening to true                                                 |
| endEvent            | None         | None             | Set's isEventHappening to false                                                |
| buttonPressed       | index        | None             | Set's the value of the button with the given index to true                     |
| getEvent            | None         | eventCode        | Goes through all the buttons in the code and returns the related operationCode |
| setDisplayList      | newIndex     | None             | Changes the value of the active list                                           |
| displayList         | None         | displayList      | returns the displayList                                                        |
| setRowSelected      | rowIndex     | setRowSelected   | Changes the value of the rowSelected property                                  |
| rowSelected         | None         | rowSelected      | Returns the value of the rowSelected property                                  |
| setInputValues      | index, input | None             | Saves the given value to the given space in the inputValues array              |
| getInputValues      | None         | inputValues      | Return the inputValues array                                                   |
| getISEventHappening | None         | isEventHappening | Return the isEventHappening property                                           |

### PseudoCode:

```text
Import required files

Create class Event
{
    Properties
    {
        1. buttons Array
        2. inputValues Array
        3. isEventHappening Boolean
        4. rowSelected integer
        5. displayList integer
        6. displayListChange Boolean
    }
    
    In the constructor method
    {
        Set initial values to the properties in the object
    }
    
    In the resetInput method
    {
        Set a default value to the inputValues array
    }
    
    In the startEvent method
    {
        set isEventHappening to true
    }
    
    In the endEvent method
    {
        set isEventHappening to false
    }
    
    In the buttonPressed method
    {
        set the button with the given index to true
    }
    
    In the getEvent method
    {
        Check to see if any events have happened
        {
            return 0 if the displayList update is true
            return 1 if the value for button 0 is true     
            return 2 if the value for button 1 is true  
            return 3 if the value for button 2 is true  
            return 4 if the value for button 3 is true  
            return 5 if the value for button 4 is true  
            return 6 if the value for button 5 is true  
            return 7 if the value for button 6 is true     
        }
        else
        {
            return null
        }
    }
    
    In the setDisplayList method
    {
        If the given index is not as the same as what is in the property
        {
            Change the property
            
            Set the displayListChange property to true so the screen updates
        }
    }
    
    In the displayList method
    {
        Return the displayList method
    }
    
    In the setRowSelected method
    {
        Change the value of teh rowSelected property
    }
    
    In the rowSelected method
    {
        Return the rowSelected property
    }
    
    In the setInputValues method
    {
        Set the input values to the input
    }
    
    In the getInputValues method
    {
        Return the inputValues array
    }
    
    In the getIsEventHappening method
    {
        return the isEventHappening property
    }
}
```

