/*****************************************
 /*Program Name: Event
 /*Programmer Name: Ali Rahbar
 /*Program Date: January 21, 2023
 /*Program Description: This program tracks the events happening in the code
 /*Inputs: Event
 /*Outputs: None
 ******************************************/
package GUI.Event;


public class Event
{
    //Initialize the properties
    private Boolean[] buttons;

    private String[] inputValues;

    private Boolean isEventHappening;

    private int rowSelected;

    private int displayList;

    private Boolean displayListChange;

    /*****************************************
     /*Method Name: Event
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 21, 2023
     /*Method Description: This method constructs the object
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    public Event()
    {
        //Set default values to properties
        this.buttons = new Boolean[]{false, false, false, false, false, false, false};
        this.inputValues = new String[] {"", "", "", ""};
        this.isEventHappening = false;
        this.displayList = 0;
        this.displayListChange = false;

    }

    /*****************************************
     /*Method Name: resetInput
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 21, 2023
     /*Method Description: This method assigns the default value for the inputValues array
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    public void resetInput()
    {
        //Set the inputValues property back to defuel value
        this.inputValues = new String[] {"", "", "", ""};
    }

    /*****************************************
     /*Method Name: startEvent
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 21, 2023
     /*Method Description: This method sets the value for the isEventHappening to true
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    private void startEvent ()
    {
        //Set is event to True
        this.isEventHappening = true;
    }

    /*****************************************
     /*Method Name: endEvent
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 21, 2023
     /*Method Description: This method sets the value for the isEventHappening to false
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    public int endEvent ()
    {
        //Set isEventHappening to False
        this.isEventHappening = false;

        //Return 0 for closing the page
        return 2;
    }

    /*****************************************
     /*Method Name: buttonPressed
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 21, 2023
     /*Method Description: This method sets the value of the given button to true so the getEvent can detect it
     /*Method Inputs: index
     /*Method Outputs: None
     ******************************************/
    public void buttonPressed (int index)
    {
        //Set the Chose buttons value to true
        this.buttons[index] = true;
    }

    /*****************************************
     /*Method Name: getEvent
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 21, 2023
     /*Method Description: This method checks all the events in the page and returns the related operation code
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    public String getEvent()
    {
        //Depending on the button pressed return different values for the event
        if (this.displayListChange)
        {
            //Set the display change to false
            this.displayListChange = false;

            //Return 0
            return "0";
        }
        //If the button 1 is clicked
        else if (this.buttons[0])
        {
            //Set the value to false
            this.buttons[0] = false;

            //Start event
            startEvent();

            //Return 1
            return "1";
        }
        //If button 2 is clicked
        else if (this.buttons[1])
        {
            //Set the value to false
            this.buttons[1] = false;

            //Start event
            startEvent();

            //Return 2
            return "2";
        }
        //If button 3 is clicked
        else if (this.buttons[2])
        {
            //Set the value to false
            this.buttons[2] = false;

            //Start event
            startEvent();

            //Return 3
            return "3";
        }
        //If button 4 is clicked
        else if (this.buttons[3])
        {
            //Set the value to false
            this.buttons[3] = false;

            //Start event
            startEvent();

            //Return 4
            return "4";
        }
        //If button 5 is clicked
        else if (this.buttons[4])
        {
            //Set the value to false
            this.buttons[4] = false;

            //Start event
            startEvent();

            //Return 5
            return "5";
        }
        //If button 6 is clicked
        else if (this.buttons[5])
        {
            //Set the value to false
            this.buttons[5] = false;

            //Start event
            startEvent();

            //Return 6
            return "6";
        }
        //If button 7 is clicked
        else if (this.buttons[6])
        {
            //Set the value to false
            this.buttons[6] = false;

            //Return 7
            return "7";
        }
        //If no event has happened
        else
        {
            //Return null
            return "null";
        }
    }

    /*****************************************
     /*Method Name: setDisplayList
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 21, 2023
     /*Method Description: This method changes the activated list
     /*Method Inputs: newIndex
     /*Method Outputs: None
     ******************************************/
    public void setDisplayList(int newIndex)
    {
        //Check if the index isn't the same
        if (!(this.displayList == newIndex))
        {
            //Change the value of the selected animal file
            this.displayList = newIndex;

            //Set the update display to true
            this.displayListChange = true;
        }
    }

    /*****************************************
     /*Method Name: displayList
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 21, 2023
     /*Method Description: This method constructs the object
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    public int displayList()
    {
        //Return the displayList property
        return this.displayList;
    }

    /*****************************************
     /*Method Name: setRowSelected
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 21, 2023
     /*Method Description: This method changes the property of the rowSelected
     /*Method Inputs: rowIndex
     /*Method Outputs: None
     ******************************************/
    public void setRowSelected (int rowIndex)
    {
        //Set the property of rowSelected
        this.rowSelected = rowIndex;
    }

    /*****************************************
     /*Method Name: rowSelected
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 21, 2023
     /*Method Description: This method returns the value of the rwoSelected
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    public int rowSelected()
    {
        //Return the value of rowSelected
        return this.rowSelected;
    }

    /*****************************************
     /*Method Name: setInputValues
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 21, 2023
     /*Method Description: This method saves the input typed by the user
     /*Method Inputs: index, input
     /*Method Outputs: None
     ******************************************/
    public void setInputValues (int index, String input)
    {
        //Set the given index of the input array to the given value
        this.inputValues[index] = input;
    }

    /*****************************************
     /*Method Name: getInputValues
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 21, 2023
     /*Method Description: This method returns the input array
     /*Method Inputs: None
     /*Method Outputs: inputValues array
     ******************************************/
    public String[] getInputValues()
    {
        //Return the inputValues array
        return this.inputValues;
    }

    /*****************************************
     /*Method Name: getIsEventHappening
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 25, 2023
     /*Method Description: This method returns the isEventHappening property
     /*Method Inputs: None
     /*Method Outputs: isEventHappening
     ******************************************/
    public boolean getIsEventHappening()
    {
        //Return isEventHappening
        return this.isEventHappening;
    }
}
