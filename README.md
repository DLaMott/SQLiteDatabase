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
--------------------------------------

Connection made
--------------------------------------

Employees
--------------------------------------
  
     First name  Last Name
        John        Doe
        Marty       Joe
        Shannon     Thea
        Marci       Jules
        Joe         Creg
        Marcus      Max
        Allie       Bart
        Shelly      Cornwall
        Sue         Bell
        Jim         Lahey
        
--------------------------------------
--------------------------------------

Customers
--------------------------------------

     First name    Last Name
        Betty        Loue
        Jim          Holland
        Anne         Thompson
        Louie        Domo
        Matthew      Teal
        Sue          Howery
        Max          Felt
        Regina       Shore
        Tom          Keaton
        Mac          Miller
--------------------------------------

Inventory
--------------------------------------

        IID Description
          1 Black pants.
          2 Brown pants.
          3 White pants.
          4 Blue pants.
          5 Black dress shirt.
          6 Blue dress shirt.
          7 White dress shirt.
          8 Pink dress shirt.
          9 White Dress.
         10 Black dress.
--------------------------------------

Sales
-----------------------------------------------------------------------------------

        SID   Quantity      Total        EID        IID        CID
          1          1         10          1          1          1
          2          2         20          2          1          1
          3          2         60          3         10         10
          4          3         90          5          9          8
          5          1         10          4          3          2
          6          1         20          6          7          6
          7          4         40          3          4          5
          8          2         20          8          2          7
          9          5        100          7          8          2
         10          1         30         10         10         10
-----------------------------------------------------------------------------------
