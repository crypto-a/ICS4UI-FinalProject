/*****************************************
 /*Program Name: AddAnimalPage
 /*Programmer Name: Ali Rahbar
 /*Program Date: January 19, 2023
 /*Program Description: This program controls the content in the addAnimalPage
 /*Inputs: Event object
 /*Outputs: None
 ******************************************/
package GUI.AddAnimalPage;

import GUI.Event.Event;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AddAnimalPage
{
    //Set the elements in the page
    private JButton addButton;
    private JFormattedTextField nameField;
    private JFormattedTextField ageField;
    private JFormattedTextField colorField;
    private JTextField typeField;
    private JPanel mainPanel;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel typeLabel;
    private JLabel colorLabel;
    private Event event;

    /*****************************************
     /*Method Name: AddAnimalPage
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 19, 2023
     /*Method Description: This method constructs the object
     /*Method Inputs: event object
     /*Method Outputs: None
     ******************************************/
    public AddAnimalPage(Event event)
    {

        //Save the value to the property
        this.event = event;


        //Add an action listener for nameField
        this.nameField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                pushText(0);
            }
        });

        //Add an action listener for ageField
        this.ageField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                pushText(1);
            }
        });

        //Add an action listener for typeField
        this.typeField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                pushText(2);
            }
        });

        //Add an action listener for colorField
        this.colorField.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
                pushText(3);
            }
        });

        //Add an action listener for the submit button
        this.addButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                buttonClicked();
            }
        });
    }

    /*****************************************
     /*Method Name: requestPage
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 19, 2023
     /*Method Description: This method returns teh mainPanel object
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    public JPanel requestPage()
    {
        //Return the mainPanel
        return this.mainPanel;
    }

    /*****************************************
     /*Method Name: pushText
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 19, 2023
     /*Method Description: This method saves the input in the event
     /*Method Inputs: index
     /*Method Outputs: None
     ******************************************/
    private void pushText(int index)
    {
        //Save in a different place depending on the field that is being completed
        switch (index)
        {
            case 0:
                /* If the nameField is filled */

                //Set the Input value in the event
                this.event.setInputValues(index, this.nameField.getText());

                //Breakout of switch statement
                break;

            case 1:
                /* If the ageField is filled */

                //Set the Input value in the event
                this.event.setInputValues(index, this.ageField.getText());

                //Breakout of switch statement
                break;

            case 2:
                /* If the typeField is filled */

                //Set the Input value in the event
                this.event.setInputValues(index, this.typeField.getText());

                //Breakout of switch statement
                break;

            case 3:
                /* If the colorField is filled */

                //Set the Input value in the event
                this.event.setInputValues(index, this.colorField.getText());

                //Breakout of switch statement
                break;
        }


    }

    /*****************************************
     /*Method Name: MainPage
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 19, 2023
     /*Method Description: This method logs the click of the button to the event
     /*Method Inputs: objectManager, event
     /*Method Outputs: None
     ******************************************/
    private void buttonClicked()
    {
        //Call the buttonPressed method to log the click of the button
        this.event.buttonPressed(6);
    }

}