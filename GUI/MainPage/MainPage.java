/*****************************************
 /*Program Name: MainPage
 /*Programmer Name: Ali Rahbar
 /*Program Date: January 18, 2023
 /*Program Description: This program controls the content in the mainPage
 /*Inputs: Event object, Animal object, ObjectManager object
 /*Outputs: None
 ******************************************/
package GUI.MainPage;

import GUI.Event.Event;
import Objects.Base.Animal;
import Objects.ObjectManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.List;

public class MainPage {
    //Set the elements in the page
    private JTable infoTable;
    private JPanel panelMain;
    private JComboBox comboBox1;
    private JButton addAnimalButton;
    private JButton editAnimalButton;
    private JButton deleteAnimalButton;
    private JButton sortByAgeButton;
    private JButton sortByNameButton;
    private JButton exportCSVButton;
    private JPanel animalSelect;
    private JPanel buttonPanel;
    private JPanel tablePanel;
    private Event event;
    private ObjectManager objectManager;


    /*****************************************
     /*Method Name: MainPage
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 19, 2023
     /*Method Description: This method constructs the object
     /*Method Inputs: objectManager, event
     /*Method Outputs: None
     ******************************************/
    public MainPage(ObjectManager objectManager, Event event)
    {
        //Set the values to the properties
        this.event = event;
        this.objectManager = objectManager;

        // Add an action listener to the button1
        this.addAnimalButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                buttonClicked(0);
            }
        });

        // Add an action listener to the button2
        this.editAnimalButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                buttonClicked(1);
            }
        });

        // Add an action listener to the button3
        this.deleteAnimalButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                buttonClicked(2);
            }
        });

        // Add an action listener to the button4
        this.exportCSVButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                buttonClicked(3);
            }
        });

        // Add an action listener to the button5
        this.sortByNameButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                buttonClicked(4);
            }
        });

        // Add an action listener to the button6
        this.sortByAgeButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                buttonClicked(5);
            }
        });

        //Add actionListener to the infoTable
        this.infoTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e)
            {
                selectedRow();
            }
        });

        //Add action listener to the comboBox1
        this.comboBox1.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                if (e.getStateChange() == ItemEvent.SELECTED)
                {
                    setDisplayList();
                }

            }
        });


    }

    /*****************************************
     /*Method Name: setDisplayList
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 19, 2023
     /*Method Description: This method sets the active list in the code
     /*Method Inputs: title, frameSize, event
     /*Method Outputs: None
     ******************************************/
    private void setDisplayList()
    {
        //Collect the value in the comboBox1
        String selectedItem = (String) this.comboBox1.getSelectedItem();


        //If the value id Dogs
        if (selectedItem.equals("Dogs"))
        {
            //Call the setDisplayList method in the events and pass the related index
            this.event.setDisplayList(0);
        }
        //If the value was Cats
        else if (selectedItem.equals("Cats"))
        {
            //Call the setDisplayList method in the events and pass the related index
            this.event.setDisplayList(1);
        }
        //If the value was Fishes
        else if (selectedItem.equals("Fishes"))
        {
            //Call the setDisplayList method in the events and pass the related index
            this.event.setDisplayList(2);
        }

        //Set the rowSelected back to default Value
        this.event.setRowSelected(0);

    }

    /*****************************************
     /*Method Name: selectedRow
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 19, 2023
     /*Method Description: This method saves the selectedRowValue
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    private void selectedRow()
    {
        //Set the selected row
        this.event.setRowSelected(infoTable.getSelectedRow() + 1);
    }

    /*****************************************
     /*Method Name: buttonClicked
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 19, 2023
     /*Method Description: This method sets teh value of the button clicked to true
     /*Method Inputs: index
     /*Method Outputs: None
     ******************************************/
    private void buttonClicked(int index)
    {
        //Call the buttonPressed method and pass the given index
        this.event.buttonPressed(index);
    }

    /*****************************************
     /*Method Name: requestPage
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 19, 2023
     /*Method Description: This method sets teh values for the page and returns it
     /*Method Inputs: None
     /*Method Outputs: JPanel
     ******************************************/
    public JPanel requestPage()
    {
        //Depending on the active list
        switch (this.event.displayList())
        {
            case 0:
                /* If the value is Dogs */

                //Set the value in the comboBox
                this.comboBox1.setSelectedItem("Dogs");


                //Break out of switch statement
                break;

            case 1:
                /* If the value is Cats */

                //Set the value in the comboBox
                this.comboBox1.setSelectedItem("Cats");

                //Break out of switch statement
                break;

            case 2:
                /* If the value is Fishes */

                //Set the value in the comboBox
                this.comboBox1.setSelectedItem("Fishes");

                //Break out of switch statement
                break;
        }


        //Return the panelMain property
        return this.panelMain;
    }

    /*****************************************
     /*Method Name: setDisplayList
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 19, 2023
     /*Method Description: This method creates teh custom UIComponents in the page
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    private void createUIComponents()
    {
        //Pulls the data for the active
        List<Animal> animal = objectManager.pullData();

        //Create the columnNames array and set values to it
        String[] columnNames = {"Num", "Name", "Age", "Type", "Color"};

        //Create the data array
        Object[][] data = {};

        //For every element in the arrayList
        for (int i = 0; i < animal.size(); i++)
        {
            //Create an array for the animal
            String[] animalArray = {Integer.toString(i+1), animal.get(i).getName(), Integer.toString(animal.get(i).getAge()), animal.get(i).getType(), animal.get(i).getColor()};

            //Add the array to the data array
            data = Arrays.copyOf(data, data.length + 1);
            data[data.length - 1] = animalArray;
        }

        //Set the infoTable to null
        this.infoTable = null;

        //Create a newValue for the JTable and save it to the infoTable
        this.infoTable = new JTable(data, columnNames);

        //Don't allow user changes on the Table
        this.infoTable.setRowSelectionAllowed(false);

        //Set the array for the items in the comboBox
        String[] items = {"Dogs", "Cats", "Fishes"};

        //Create new comboBox and set the item values to it
        this.comboBox1 = new JComboBox<String>(items);

    }

}
