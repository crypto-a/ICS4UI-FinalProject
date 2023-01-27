/*****************************************
 /*Program Name: GUI
 /*Programmer Name: Ali Rahbar
 /*Program Date: January 18, 2023
 /*Program Description: This program manages what happens in the GUI
 /*Inputs: Event object, Animal object, ObjectManager object
 /*Outputs: None
 ******************************************/
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import GUI.AddAnimalPage.AddAnimalPage;
import GUI.EditAnimalPage.EditAnimalPage;
import GUI.Event.Event;
import GUI.MainPage.MainPage;
import Objects.Base.Animal;
import Objects.ObjectManager;

public class GUI extends JFrame
{
    //Set Initial properties
    private String title;

    int[] frameSize;

    private JFrame frame;

    private Event event;

    /*****************************************
     /*Method Name: GUI
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 18, 2023
     /*Method Description: This method constructs the object
     /*Method Inputs: title, frameSize, event
     /*Method Outputs: None
     ******************************************/
    public GUI(String title, int[] frameSize, Event event)
    {
        //Set the values to the properties
        this.title = title;
        this.frameSize = frameSize;
        this.event = event;

        // Initializes the frame and puts "Window Name" in the top bar
        this.frame = new JFrame(this.title);

        // Makes the frame the maximum size on repl.it
        this.frame.setSize(this.frameSize[0], this.frameSize[1]);

        //Set display to the center of the screen
        frame.setLocationRelativeTo(null);

        // Makes the background of the frame grey
        this.frame.setLayout(new BorderLayout());

    }

    /*****************************************
     /*Method Name: updateMainPage
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 18, 2023
     /*Method Description: This method constructs the object
     /*Method Inputs: objectManager
     /*Method Outputs: None
     ******************************************/
    public void updateMainPage(ObjectManager objectManager)
    {
        //Set a closing operation for page
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create the GUI object
        MainPage mainPage = new MainPage(objectManager, this.event);

        //Clear the frame
        this.frame.getContentPane().removeAll();

        //Add the GUI content to the page
        this.frame.add(mainPage.requestPage());

        //Set visibility to true
        this.frame.setVisible(true);
    }

    /*****************************************
     /*Method Name: Event
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 18, 2023
     /*Method Description: This method updates the content in the addPage
     /*Method Inputs: objectManager
     /*Method Outputs: None
     ******************************************/
    public void updateAddPage(ObjectManager objectManager)
    {

        //Set a closing operation for page
        this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //Add an event listener for the closing of page
        this.frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e) {
                cancelPage();
            }
        });
        //Create the GUI object
        AddAnimalPage addPage = new AddAnimalPage(this.event);

        //Add the GUI content to the page
        this.frame.add(addPage.requestPage());

        //Set visibility to true
        this.frame.setVisible(true);
    }

    /*****************************************
     /*Method Name: Event
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 18, 2023
     /*Method Description: This method updates the content in the editPage
     /*Method Inputs: objectManger
     /*Method Outputs: None
     ******************************************/
    public void updateEditPage(ObjectManager objectManager)
    {
        //Set a closing operation for page
        this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //Add an event listener for the closing of page
        this.frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e) {
                cancelPage();
            }
        });

        //Pull out the animal that will be edited
        Animal animal = (Animal) objectManager.pullData().get(this.event.rowSelected()-1);

        //Create the GUI object
        EditAnimalPage editPage = new EditAnimalPage(this.event);

        //Add the GUI content to the page
        this.frame.add(editPage.requestPage(animal));

        //Set visibility to true
        this.frame.setVisible(true);
    }

    /*****************************************
     /*Method Name: terminate
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 18, 2023
     /*Method Description: This method terminates the page
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    public void terminate()
    {
        //Dispose the frame
        this.frame.dispose();
    }

    /*****************************************
     /*Method Name: cancelPage
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 18, 2023
     /*Method Description: This method ends the event
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    private void cancelPage()
    {
        //End event
        this.event.endEvent();
    }

}
