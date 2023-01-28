package database;

public class TestDB
{
    public static void main(String[] args)
    {

        Runtime runtime = Runtime.getRuntime();

        //Run the SQLit Class
        SQLiteDB db = new SQLiteDB("database.db");

        String[][] array = db.getDataFromTable("Dogs");

//        for (int i = 0; i < array.length; i++)
//        {
//            for (int j = 0; j < array[i].length; j++) {
//                System.out.println(array[i][j]);
//            }
//        }
        db.writeToTable("Dogs", array);

        db.closeDB();

        runtime.gc();

        //Print the total memory used
        long memory = runtime.totalMemory() - runtime.freeMemory();

        System.out.println(memory);
    }
}
