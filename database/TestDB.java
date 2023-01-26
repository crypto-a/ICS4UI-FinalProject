package database;

public class TestDB
{
    public static void main(String[] args)
    {

        //Run the SQLit Class
        SQLiteDB db = new SQLiteDB("database.db");

        String[][] array = db.getDataFromTable("Fish");

        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array[i].length; j++)
            {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        db.writeToTable("Fish", array);

        db.closeDB();

    }
}
