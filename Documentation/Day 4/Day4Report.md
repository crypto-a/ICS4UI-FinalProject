# Testing Scope Document:
## Task: Testing the Database System For Errors (Unit testing)
## Assigned to: Simerus Mahesh
## Due Date: January 27, 2023
***

### Project Background and Objectives:

> The project's idea is to test the code structure of a Java class that is connected to an SQLite database. The objective of the project is to ensure that the code is functioning properly and is free of errors. The code will be provided for testing and error checking. The project manager is Ali Rahbar.

### Project Scope and Deliverables:

> The project's scope includes testing the code structure of the Java class and ensuring that it is properly connected to the SQLite database. Specific tasks that need to be accomplished include:
> * Verifying that the code structure is correct and follows best practices
> * Verifying that the code is properly connected to the SQLite database
> * Identifying and resolving any errors or bugs in the code
> * The deliverables that will be produced include a report detailing the results of the testing and any errors or bugs that were identified and resolved.


### Project Constraints and Assumptions:

> The project is constrained by a time frame of one Day. No budget constraints are known. The assumption is that the code and database provided are functional and that the project team has the necessary knowledge and skills to complete the task.


### Project Schedule and Milestones:

> The project schedule includes the following milestones:
>
> * Day 1: Test the code and check for errors.


### Project Budget and Resources:

> The Task has a budget of $100. The resources required for the project include a computer with Java and SQLite installed and access to the provided code and database.


### Quality Standards and Acceptance Criteria:

> The project must meet industry best practices for code structure and database connections. The quality standards will be measured by ensuring that the code is properly structured and connected to the database, and that any identified errors or bugs are resolved. The acceptance criteria for the deliverables include a report detailing the results of the testing and any errors or bugs that were identified and resolved.


### Communication and Reporting Requirements:

> Communication and reporting will be handled by the project manager, Ali Rahbar. The stakeholders that will be involved in communication and reporting include the project team members. The project team will report progress and any issues to the project manager.


### Risk Management and Contingency Plans:

> Potential risks to the project include the possibility of not identifying all errors or bugs in the code, or not being able to resolve them in the given time frame. The risk management process includes thorough testing and review of the code, as well as regular check-ins with the project manager. In the event that errors or bugs are not resolved within the given time frame, the contingency plan is to extend the project deadline by one day.


### Approval:

> Approved by _Ali Rahbar_, Project Manager, and the stakeholders who have reviewed and approved the scope of work document.

*** 

# Tester report:

# Testing Results:
#### By Simerus Mahesh
***

> The database system was thoroughly tested on January 27, 2023 by Simerus Mahesh using the white box testing method. The main objective of the testing was to evaluate the code structure of a Java class that was connected to an SQLite database and to ensure its proper functioning and error-free performance.
>
> The testing process covered a range of aspects, including verifying the correctness of code structure, checking the proper connection of the code to the SQLite database, and identifying and resolving any errors or bugs present in the code. The outcome of the testing was documented in a report that highlighted the results of the testing, including any errors or bugs that were identified and resolved.
>
> The project had a tight deadline of one day and no budget constraints were reported. The team had the necessary knowledge and skills to carry out the testing and was confident that the code and database provided were functional.
>
> The project schedule consisted of a single day of testing, with a budget of $100. The resources required for the project included a computer with Java and SQLite installed and access to the provided code and database.
>
> The project team followed industry best practices for code structure and database connections, and the quality standards were assessed by verifying that the code was structured properly and connected to the database, and by ensuring that any errors or bugs were resolved. The acceptance criteria for the testing included a detailed report that documented the results of the testing and any errors or bugs that were identified and resolved.
>
> Communication and reporting were managed by the project manager, Ali Rahbar, and involved the project team members. The project team provided regular updates and reported any issues to the project manager.
>
> Potential risks to the project included the possibility of not identifying all errors or bugs in the code or not being able to resolve them within the given time frame. The team managed these risks by performing thorough testing and reviewing the code and by regularly communicating with the project manager. In case errors or bugs were not resolved within the given time frame, the contingency plan was to extend the project deadline by one day.
>
> The scope of work document was reviewed and approved by Ali Rahbar, the Project Manager, and the stakeholders.
>
> In conclusion, the testing process was successful, and no errors or bugs were found in the code or database system. The team utilized the white box testing method and employed statement coverage, branch coverage, and path coverage techniques to thoroughly test the code and ensure its proper functioning.
*** 

# Optimization report:

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

> After the optimization in the code the total memory used was 2073504 bytes. Overall, we were able to save 1488 bytes of memory when reading and to write from and to the database.

# Day 4 Report (By project manager):
> Today everything went as planned and as expected. The test team found no errors and the optimization team was able to optimize the code so it uses less memory and works better when bigger sets of data are being used.

* Day 4 Gantt:

![Day 4 gantt](https://user-images.githubusercontent.com/72822222/215276552-76b6e3f6-4370-42fe-8176-b51c49d29f8e.png)


