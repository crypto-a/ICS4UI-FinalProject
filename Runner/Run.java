/*****************************************
 /*Program Name: Run
 /*Programmer Name: Ali Rahbar
 /*Program Date: January 20, 2023
 /*Program Description: This program manages the general functionality of the code
 /*Inputs: ObjectManager, Event, GUI
 /*Outputs: None
 ******************************************/

package Runner;

import Objects.ObjectManager;
import GUI.GUI;
import GUI.Event.Event;

import javax.swing.*;


public class Run
{
    //Set the Initial properties
    private Event event;
    private ObjectManager objectManager;
    private GUI mainGui;

    /*****************************************
     /*Method Name: Run
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 20, 2023
     /*Method Description: This method constructs the object
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    public Run()
    {
        //Initialize the event Object
        this.event = new Event();

        //Initialize the ObjectManager
        this.objectManager = new ObjectManager(this.event);


        //Initialize the GUI object
        int[] frameSize = {800, 600};
        this.mainGui = new GUI("GUI Assessment", frameSize, this.event);
        this.mainGui.updateMainPage(this.objectManager);

        //Loop forever
        while (true)
        {
            //Call the eventHandler to handle events
            eventHandler();
        }


    }

    /*****************************************
     /*Method Name: eventHandler
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 20, 2023
     /*Method Description: This method handles the events that are happening
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    private void eventHandler()
    {
        /* Java Engine Timeout */
        try
        {
            //Time Out
            Thread.sleep(200);
        }
        catch (InterruptedException e)
        {
            //Print error
            e.printStackTrace();
        }

        //Collect event that is happening
        String eventCode = this.event.getEvent();

        //Depending on the event given, run a special piece of code
        switch(eventCode)
        {
            case "1":
                /* in case user inputs 1 */

                //Call the related method
                addAnimal();

                //Break out if the switch statement
                break;

            case "2":
                /* in case user inputs 2 */

                //Call the related method
                editAnimal();

                //Break out if the switch statement
                break;

            case "3":
                /* in case user inputs 3 */


                //Call the related method
                deleteAnimal();

                //Break out if the switch statement
                break;

            case "4":
                /* in case user inputs 4 */

                //End event
                this.event.endEvent();

                //Break
                break;

            case "5":
                /* in case user inputs 5 */

                //Call the related method
                sortByName();


                //Break out if the switch statement
                break;

            case "6":
                /* in case user inputs 6 */

                //Call the related method
                sortByAge();

                //Break out if the switch statement
                break;

            default:
                break;

        }

        //Update screen Ony after an event happens
        if (!(eventCode.equals("null")))
        {
            //Update GUI main page
            this.mainGui.updateMainPage(this.objectManager);
        }
    }


    /*****************************************
     /*Method Name: addAnimal
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 20, 2023
     /*Method Description: This method collects the values to add a new animal to the list
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    private void addAnimal()
    {
        //Create the page to collect User Input
        int[] addFrameSize = {300, 250};
        GUI addPage = new GUI("Add Animal", addFrameSize, this.event);

        //reset the input variables for new input
        this.event.resetInput();

        //Update the add animal page to show content
        addPage.updateAddPage(this.objectManager);

        //Wait for the page to get submitted
        while (this.event.getEvent() != "7")
        {
            //If the operation is canceled by the user
            if (this.event.getIsEventHappening() == false)
            {
                //Terminate page
                addPage.terminate();

                //Set row selected to 0 again
                this.event.setRowSelected(0);

                //Return
                return;
            }

            /* Java Engine Timeout */

            try
            {
                //Sleep
                Thread.sleep(200);
            }
            catch (InterruptedException e)
            {
                //Print error
                e.printStackTrace();
            }
        }

        //Pass the collected value sot the objectManager to create the new object
        this.objectManager.addAnimal(this.event.getInputValues()[0], Integer.parseInt(this.event.getInputValues()[1]), this.event.getInputValues()[2], this.event.getInputValues()[3]);

        //Terminate page
        addPage.terminate();

        //End event
        this.event.endEvent();

    }

    /*****************************************
     /*Method Name: editAnimal
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 20, 2023
     /*Method Description: This method edits the values of the selected animal Object
     /*Method Inputs: possibleAnimalSelect
     /*Method Outputs: None
     ******************************************/
    private void editAnimal()
    {
        //Check if the active list is empty or there isn't a value assigned to rowSelected property
        if (this.objectManager.pullData().isEmpty() || this.event.rowSelected() == 0)
        {
            //Display error message
            JOptionPane.showMessageDialog(null, "Please Select A Row First", "Error", JOptionPane.ERROR_MESSAGE);

            //Return to end execution
            return;
        }

        //Create the page to collect User Input
        int[] editFrameSize = {300, 250};
        GUI editPage = new GUI("Edit Animal", editFrameSize, this.event);

        //reset the input variables for new input
        this.event.resetInput();

        //Update page to show the GUI
        editPage.updateEditPage(this.objectManager);

        //Wait for the page to get submitted
        while (this.event.getEvent() != "7")
        {
            //If the operation is canceled by the user
            if (this.event.getIsEventHappening() == false)
            {
                //Terminate page
                editPage.terminate();

                //Set row selected to 0 again
                this.event.setRowSelected(0);

                //Return
                return;
            }

            /* Java Engine Timeout */

            try
            {
                //Sleep
                Thread.sleep(200);
            }
            catch (InterruptedException e)
            {
                //Print error
                e.printStackTrace();
            }
        }

        //Pass the properties to the object manager to change the values
        this.objectManager.editAnimal(this.event.getInputValues()[0], Integer.parseInt(this.event.getInputValues()[1]), this.event.getInputValues()[2], this.event.getInputValues()[3], this.event.rowSelected());

        //Terminate page
        editPage.terminate();

        //Set row selected to 0 again
        this.event.setRowSelected(0);

        //End event
        this.event.endEvent();
    }

    /*****************************************
     /*Method Name: Run
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 20, 2023
     /*Method Description: This method deletes an object from the list
     /*Method Inputs: possibleAnimalSelect
     /*Method Outputs: None
     ******************************************/
    private void deleteAnimal()
    {
        //Check if the active list is empty or there isn't a value assigned to rowSelected property
        if (this.objectManager.pullData().isEmpty() || this.event.rowSelected() == 0)
        {
            //Display error message
            JOptionPane.showMessageDialog(null, "Please Select A Row First", "Error", JOptionPane.ERROR_MESSAGE);

            //Return to end execution
            return;
        }

        //Pass the value to the objectManager to delete the object from the selected list
        this.objectManager.deleteAnimal(this.event.rowSelected());

        //Set row selected to 0 again
        this.event.setRowSelected(0);

        //End Event
        this.event.endEvent();
    }

    /*****************************************
     /*Method Name: sortByName
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 20, 2023
     /*Method Description: This method calls the sort method to Sort By Name
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    private void sortByName()
    {
        //Call tht sort method to sort by name
        objectManager.sortByName();

        //End Event
        this.event.endEvent();
    }

    /*****************************************
     /*Method Name: SortByAge
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 20, 2023
     /*Method Description: This method calls teh sort method to Sort By Age
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    private void sortByAge()
    {
        //Call the sort method to sort by age
        objectManager.sortByAge();

        //End Event
        this.event.endEvent();
    }
}
