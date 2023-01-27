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
        //Try
        try
        {
            // Execute a SELECT statement to retrieve data from the table
            ResultSet result = this.statement.executeQuery("SELECT * FROM " + tableName);

            // Get the number of columns in the result set
            ResultSetMetaData metaData = result.getMetaData();
            int numCols = metaData.getColumnCount();

            // Create a List to store the data
            List<List<String>> data = new ArrayList<>();

            // Loop through the result set and add the data to the List
            while (result.next())
            {
                //Create a permeate list
                List<String> rowData = new ArrayList<>();


                //Save the data to the list
                for (int col = 0; col < numCols; col++)
                {
                    //Add the data to the list
                    rowData.add(result.getString(col + 1));
                }

                //Add row to data
                data.add(rowData);
            }

            // Convert the List to a 2D array
            int numRows = data.size();

            //Create the 2dArray
            String[][] arrayData = new String[numRows][numCols];

            //Loop through every element of the list
            for (int row = 0; row < numRows; row++)
            {
                //loop thou every sub element
                for (int col = 0; col < numCols; col++)
                {
                    //Add it to the array
                    arrayData[row][col] = data.get(row).get(col);
                }
            }

            //Return the array
            return arrayData;
        }
        //If error occurred
        catch (Exception e)
        {
            //Print error
            System.out.println("Error retrieving data from table: " + e.getMessage());

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

        //Delete everything from given table
        try {
            // Execute a DELETE statement to delete all data from the table
            this.statement.executeUpdate("DELETE FROM " + tableName);
        } catch (Exception e) {
            System.out.println("Error deleting data from table: " + e.getMessage());
        }

        //Try
        try {
            // Loop through the 2D array and add the data to the table
            for (int row = 0; row < data.length; row++) {
                //Collect the values
                String name = data[row][0];
                int age = Integer.parseInt(data[row][1]);
                String type = data[row][2];
                String color = data[row][3];

                // Use a prepared statement to insert the data into the table to prevent SQL injection attacks
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " + tableName + " (name, age, type, color) VALUES (?, ?, ?, ?)");

                //Assign values to the statement
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, age);
                preparedStatement.setString(3, type);
                preparedStatement.setString(4, color);

                //Execute the statement
                preparedStatement.executeUpdate();
            }
        }
        //If error occurs
        catch (Exception e) {
            System.out.println("error writing to db");
            e.printStackTrace();
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
        try
        {
            this.statement.close();
            this.connection.close();
        }
        catch (Exception e)
        {
            System.out.println("unable to close db");
            e.printStackTrace();
        }
    }
}

