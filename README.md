# SQLiteDatabase

## Building
The project is managed by Gradle, and can be built with:
`./gradlew build`

## Testing
Automated tests can be run with
```./gradlew test```

## Running

Navigate to the dirctory of the created .jar. 

Once in the correct directory enter java -jar CSC289DatabaseTest-1.0-SNAPSHOT.jar

Successful build will show output such as:
--------------------------------------

Connection made
--------------------------------------

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
