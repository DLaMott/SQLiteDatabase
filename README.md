# SQLiteDatabase
This project was created as a final programming capstone project for GTCC. The goal was to create a database application
to better enable a business to track information for their company. We were to perform a SWOT analysis in order to better
determine the need for such a database.


# The entity relationship diagram is as follows:
![CSC 289 ERModel](https://user-images.githubusercontent.com/66742430/161339704-dda09e08-772d-4eb5-9b69-ec8a0c5ec7d7.png)

## Building
The project is managed by Gradle, and can be built with:
`./gradlew build`

## Testing
Automated tests can be run with
```./gradlew test```

## Running

Navigate to the directory of the created .jar. Ensure project.db and CSC289DatabaseTest-1.0.jar are in the same folder

Once in the correct directory enter java -jar CSC289DatabaseTest-1.0.jar

Successful execution will show output such as:
--------------------------------------

Connection made
--------------------------------------
```````````````````````angular2html
Welcome to the DB Connection tool
Please choose fom the following:
1. Customer menu
2. Employee menu
3. Sale menu
4. Inventory menu
5. Show all tables
6. Exit


```````````````````````
Each sub menu contains options for updating, deleting, viewing, and adding row information for the tables.

## Starting table example:

Employees

-----------------------------------------------------------------------------------
  
            First name            Last Name           EmployeeID
                 John                  Doe                    1
                Marty                  Joe                    2
              Shannon                 Thea                    3
                Marci                Jules                    4
                  Joe                 Creg                    5
               Marcus                  Max                    6
                Allie                 Bart                    7
               Shelly             Cornwall                    8
                  Sue                 Bell                    9
                  Jim                Lahey                   10
        
-----------------------------------------------------------------------------------

Customers

-----------------------------------------------------------------------------------

            First name            Last Name           CustomerID
                Betty                 Loue                    1
                  Jim              Holland                    2
                 Anne             Thompson                    3
                Louie                 Domo                    4
              Matthew                 Teal                    5
                  Sue               Howery                    6
                  Max                 Felt                    7
               Regina                Shore                    8
                  Tom               Keaton                    9
                  Mac               Miller                   10

-----------------------------------------------------------------------------------

Inventory

-----------------------------------------------------------------------------------

                  IID          Description                Price
                    1         Black pants.               $10.00
                    2         Brown pants.               $10.00
                    3         White pants.               $10.00
                    4          Blue pants.               $10.00
                    5   Black dress shirt.               $20.00
                    6    Blue dress shirt.               $20.00
                    7   White dress shirt.               $20.00
                    8    Pink dress shirt.               $20.00
                    9         White Dress.               $30.00
                   10         Black dress.               $30.00

-----------------------------------------------------------------------------------

Sales

-----------------------------------------------------------------------------------

       SID   Quantity      Total        EID        IID        CID
          1          1     $10.00          1          1          1
          2          2     $20.00          2          1          1
          3          2     $60.00          3         10         10
          4          3     $90.00          5          9          8
          5          1     $10.00          4          3          2
          6          1     $20.00          6          7          6
          7          4     $40.00          3          4          5
          8          2     $20.00          8          2          7
          9          5    $100.00          7          8          2
         10          1     $30.00         10         10         10
-----------------------------------------------------------------------------------
