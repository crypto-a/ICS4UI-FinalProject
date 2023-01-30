# ICS4UI-FinalProject
> The project is an inventory management system designed for pet shops. It allows users to easily add, edit, and delete animals from the inventory, including dogs, cats, and fish. The software also includes sorting options, allowing users to sort the animals by their name or age. Additionally, the software utilizes a database to store the data, ensuring that information is not lost when the software is closed. With this software, pet shop owners and managers can easily keep track of their inventory and ensure that their customers have access to the animals they need.

# Results screenShot:
![resultScreenShot](https://user-images.githubusercontent.com/72822222/215298156-1c3c02b2-699c-4ad6-be39-46cec38dfe92.png)


# Folder structure:
```lua
MyProject
|
+--- src
|    |
|    +--- Main.java
|    |
|    +--- database
|    |    |
|    |    +--- SQLiteDB.java
|    |
|    +--- GUI
|    |    |
|    |    +--- GUI.java 
|    |    |
|    |    +--- Event
|    |    |    |
|    |    |    +--- Event.java
|    |    |
|    |    +--- MainPage
|    |    |    |
|    |    |    +--- MainPage.java
|    |    |    |
|    |    |    +--- MainPage.form
|    |    |
|    |    +--- AddAnimalPage
|    |    |    |
|    |    |    +--- AddAnimalPage.java
|    |    |    |
|    |    |    +--- AddAnimalPage.form
|    |    |
|    |    +--- EditAnimalPage
|    |    |    |
|    |    |    +--- EditAnimalPage.java
|    |    |    |
|    |    |    +--- EditAnimalPage.form
|    |    |
|    |    +--- IntegerInputVerifier
|    |         |
|    |         +--- IntegerInputVerifier.java
|    |
|    +--- Objects
|    |    |
|    |    +--- ObjectManager.java
|    |    |
|    |    +--- Base
|    |    |    |
|    |    |    +--- Animal.java
|    |    |
|    |    +--- Cat
|    |    |    |
|    |    |    +--- MainPage.java
|    |    |
|    |    +--- Dog
|    |    |    |
|    |    |    +--- Cat.java
|    |    |
|    |    +--- Fish
|    |         |
|    |         +--- Fish.java
|    |
|    +--- runner
|         |
|         +--- Run.java
|
+--- database.db


```

# Steps to Run Code
1. clone the project
2. Download the ```JDBC driver``` for the database connection
3. Add the driver to the Java compiler
4. Run the code using the ```Main.java``` script


