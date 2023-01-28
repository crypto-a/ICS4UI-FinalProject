package database;

public class TestDB
{
    public static void main(String[] args)
    {

        Runtime runtime = Runtime.getRuntime();

        //Run the SQLit Class
        SQLiteDB db = new SQLiteDB("database.db");

        String[][] array = db.getDataFromTable("Cats");

        db.writeToTable("Cats", array);

        db.closeDB();

        runtime.gc();

        //Print the total memory used
        long memory = runtime.totalMemory() - runtime.freeMemory();

        System.out.println(memory);
    }
}
