/*****************************************
 /*Program Name: SQLiteDB
 /*Programmer Name: Ali Rahbar
 /*Program Date: January 26, 2023
 /*Program Description: This program connects to the database
 /*Inputs: None
 /*Outputs: None
 ******************************************/

package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SQLiteDB {
    // Declare variables for the connection to the database
    private Connection connection;
    private Statement statement;

    /*****************************************
     /*Method Name: SQLiteDB
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 26, 2023
     /*Method Description: This method constructs the object
     /*Method Inputs: databaseName
     /*Method Outputs: None
     ******************************************/
    public SQLiteDB(String databaseName) {

        /* Connect to the database */
        //Try
        try
        {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Connect to the database
            this.connection = DriverManager.getConnection("jdbc:sqlite:" + databaseName);

            // create statement
            this.statement = this.connection.createStatement();
        }
        //If error occurs
        catch (Exception e)
        {
            //Print error
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }

    /*****************************************
     /*Method Name: getDataFromTable
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 26, 2023
     /*Method Description: This method returns the table values as a 2dArray array
     /*Method Inputs: tableName
     /*Method Outputs: data
     ******************************************/
    public String[][] getDataFromTable(String tableName)
    {
        /* Read from database */
        //Try
        try
        {
            //Create the 2dArray
            String[][] arrayData = new String[Integer.parseInt(this.statement.executeQuery("SELECT COUNT(*) FROM "+ tableName).getString(1))][4];

            // Execute a SELECT statement to retrieve data from the table
            ResultSet result = this.statement.executeQuery("SELECT * FROM " + tableName);

            //Create a variable to count the index of the array Data in filling order
            int i = 0;

            //While there is data to write
            while(result.next())
            {
                //Create a temporary array
                String[] singleRow = new String[4];

                //For every column(4 times)
                for (int j = 0; j < 4; j++)
                {
                    //Add teh data as a string to the array
                    singleRow[j] = result.getString(j + 1);
                }

                //Add the array to the 2dArray and increment the index
                arrayData[i++] = singleRow;
            }

            //Return the arrayData
            return arrayData;

        } catch (Exception e)
        {
            //Print error
            System.out.println("Error connecting to the database: " + e.getMessage());

            //Return null
            return null;
        }

    }

    /*****************************************
     /*Method Name: writeToTable
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 26, 2023
     /*Method Description: This method writes the given 2dArray to the table and saves it
     /*Method Inputs: tableName, data
     /*Method Outputs: None
     ******************************************/
    public void writeToTable (String tableName, String[][] data)
    {
        // Delete everything in the table before inserting new data
        try {
            // create statement
            Statement statement = this.connection.createStatement();
            // Execute a DELETE statement to delete all data from the table
            statement.executeUpdate("DELETE FROM " + tableName);

            statement.close();
        } catch (Exception e)
        {
            System.out.println("Error deleting data from table: " + e.getMessage());
        }

        /* Write the new data to the database */
        //Try
        try
        {

            // Insert new data into the table
            for (int row = 0; row < data.length; row++) {
                String insertSQL = "INSERT INTO " + tableName + " (name, age, type, color) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = this.connection.prepareStatement(insertSQL);
                preparedStatement.setString(1, data[row][0]);
                preparedStatement.setInt(2, Integer.parseInt(data[row][1]));
                preparedStatement.setString(3, data[row][2]);
                preparedStatement.setString(4, data[row][3]);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
        }
        //If error occurs
        catch (Exception e)
        {
            System.out.println("Error writing to db: " + e.getMessage());
        }
    }


    /*****************************************
     /*Method Name: Run
     /*Programmer Name: Ali Rahbar
     /*Method Date: January 26, 2023
     /*Method Description: This method closes the database connection
     /*Method Inputs: None
     /*Method Outputs: None
     ******************************************/
    public void closeDB()
    {
        /* disconnect the database */

        try
        {
            this.statement.close();
            this.connection.close();
        }
        catch (Exception e)
        {
            //Print error
            System.out.println("Error closing to the database: " + e.getMessage());
        }
    }
}

