/*****************************************
 /*Program Name: IntegerInputVerifier
 /*Programmer Name: Ali Rahbar
 /*Program Date: January 25, 2023
 /*Program Description: This program validates the integer input
 /*Inputs: None
 /*Outputs: None
 ******************************************/
package GUI.IntegerInputVerifier;


import javax.swing.*;

public class IntegerInputVerifier extends InputVerifier
{
    /*****************************************
     /*Method Name: verify
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 25, 2023
     /*Method Description: This method validates the input
     /*Method Inputs: input
     /*Method Outputs: true/false
     ******************************************/
    public boolean verify(JComponent input)
    {
        //Collect input
        JTextField textField = (JTextField) input;

        //Validate
        try
        {
            //Convert the input into an int
            Integer.parseInt(textField.getText());

            //Return true
            return true;
        }
        //If an error occurs
        catch (NumberFormatException e)
        {
            //Display error message
            JOptionPane.showMessageDialog(null, "Please Enter An Integer", "Error", JOptionPane.ERROR_MESSAGE);

            //Return False
            return false;
        }
    }
}
