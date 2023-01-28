## Optimization Report
#### By Ali Rahbar
***

> This code is a program that connects to a SQLite database and allows for data to be read from and written to a table. The code uses the SQLite JDBC driver to connect to the specified database, and creates a connection and a statement object to interact with the database. The program has two main methods: "getDataFromTable" which retrieves data from a specified table and returns it as a 2D array, and "writeToTable" which takes a 2D array and writes it to a specified table in the database. The code also includes a constructor that connects to the database and creates the statement object when the program is initialized. The program uses 2074992 bytes of memory.

> The getDataFromTable method in the code was changed. The current code is as following:
```
public String[][] getDataFromTable(String tableName)
    {
        /* Read from database */
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
```

The Following piece of code was changed to the following:
```
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

            for (int i = 0; i < arrayData.length; i++)
            {
                String[] singleRow = new String[4];

                for (int j = 0; j < 4; j++)
                {
                    singleRow[j] = result.getString(j + 1);
                }

                arrayData[i] = singleRow;
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
```

> After the optimization in the code the total memory use was 