#### Program Name: SQLiteDB
#### Programmer Name: Ali Rahbar
#### Program Date: January 26, 2023
#### Program Description: This program connects to the database
#### Inputs: None
#### Outputs: None

---

### IPO Chart:


| **Method Name**  | **Inputs**      | **Outputs** | **Processes**                                        |
|------------------|-----------------|-------------|------------------------------------------------------|
| SQLiteDB         | databaseName    | None        | Opens the database                                   |
| getDataFromTable | tableName       | data        | Reads everything in the database and returns a table |
| writeToTable     | tableName, data | None        | Deletes the table values and writes the new files    |
| closeDB          | None            | None        | Closes the database                                  |

### PseudoCode:

```text
Import required files

Create class SQLiteDB
{
    Properties
    {
        1. connection
        2. statement
    }
    
    In the object constructor
    {
        connect tot he database
        
        Create a statement to execute commands
    }
    
    In the getDataFromTable method
    {
        Get all the data in the inputted table
        
        Put it in a arrayList
        
        convert the arraylist into an array
        
        return the array
    }
    
    In the writeToTable method
    {
        Delete everything from the table
        
        For every element in the array list
        {
            Write the value to the database
        }
    }
    
    In the closeDB method
    {
        Close the database connection
    }
}
```



