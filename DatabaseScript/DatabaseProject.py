import os
import sqlite3

from Objects import Customer
from Objects import Employee
from Objects import Inventory
from Objects import Sales

connection = sqlite3.connect(os.path.realpath('../project.db'))

cursor = connection.cursor()

cursor.execute("CREATE TABLE IF NOT EXISTS Employees ("
               "EID INTEGER PRIMARY KEY AUTOINCREMENT,"
               " EFname TEXT,"
               " ELname TEXT)")

cursor.execute("CREATE TABLE IF NOT EXISTS Inventory ("
               "IID INTEGER PRIMARY KEY AUTOINCREMENT,"
               " IDesc TEXT,"
               " IPrice DECIMAL(10,2))")
cursor.execute("CREATE TABLE IF NOT EXISTS Customers ("
               "CID INTEGER PRIMARY KEY AUTOINCREMENT,"
               " CFname TEXT,"
               " CLname TEXT)")
cursor.execute("CREATE TABLE IF NOT EXISTS Sales ("
               "SID INTEGER PRIMARY KEY AUTOINCREMENT,"
               " SQty INTEGER,"
               " STotal DECIMAL(10,2),"
               " CID INTEGER,"
               " IID INTEGER,"
               " EID INTEGER, "
               " FOREIGN KEY(IID) REFERENCES Inventory(IID),"
               " FOREIGN KEY(EID) REFERENCES Employees(EID),"
               " FOREIGN KEY(CID) REFERENCES Customers(CID))")
connection.commit()

# Create employee objects
employee1 = Employee('John', 'Doe')
employee2 = Employee("Marty", "Joe")
employee3 = Employee("Shannon", "Thea")
employee4 = Employee("Marci", "Jules")
employee5 = Employee("Joe", "Creg")
employee6 = Employee("Marcus", "Max")
employee7 = Employee("Allie", "Bart")
employee8 = Employee("Shelly", "Cornwall")
employee9 = Employee("Sue", "Bell")
employee10 = Employee("Jim", "Lahey")

# Create Inventory Objects
inventory1 = Inventory("Black pants.", 10.00)
inventory2 = Inventory("Brown pants.", 10.00)
inventory3 = Inventory("White pants.", 10.00)
inventory4 = Inventory("Blue pants.", 10.00)
inventory5 = Inventory("Black dress shirt.", 20.00)
inventory6 = Inventory("Blue dress shirt.", 20.00)
inventory7 = Inventory("White dress shirt.", 20.00)
inventory8 = Inventory("Pink dress shirt.", 20.00)
inventory9 = Inventory("White Dress.", 30.00)
inventory10 = Inventory("Black dress.", 30.00)

# Create Customer Objects
customer1 = Customer("Betty", "Loue")
customer2 = Customer("Jim", "Holland")
customer3 = Customer("Anne", "Thompson")
customer4 = Customer("Louie", "Domo")
customer5 = Customer("Matthew", "Teal")
customer6 = Customer("Sue", "Howery")
customer7 = Customer("Max", "Felt")
customer8 = Customer("Regina", "Shore")
customer9 = Customer("Tom", "Keaton")
customer10 = Customer("Mac", "Miller")

# Create Sale Objects
# SALES : Quantity, Total, CID, EID, IID
sale1 = Sales(1, 10.00, 1, 1, 1)
sale2 = Sales(2, 20.00, 1, 2, 1)
sale3 = Sales(2, 60.00, 10, 3, 10)
sale4 = Sales(3, 90.00, 8, 5, 9)
sale5 = Sales(1, 10.00, 2, 4, 3)
sale6 = Sales(1, 20.00, 6, 6, 7)
sale7 = Sales(4, 40.00, 5, 3, 4)
sale8 = Sales(2, 20.00, 7, 8, 2)
sale9 = Sales(5, 100.00, 2, 7, 8)
sale10 = Sales(1, 30.00, 10, 10, 10)


# Insert Employees into Employee Table
def insert_employee(employee):
    cursor.execute("INSERT INTO Employees(EFname, ELname) VALUES(?, ?)", (employee.first, employee.last))


insert_employee(employee1)
insert_employee(employee2)
insert_employee(employee3)
insert_employee(employee4)
insert_employee(employee5)
insert_employee(employee6)
insert_employee(employee7)
insert_employee(employee8)
insert_employee(employee9)
insert_employee(employee10)
connection.commit()


# Insert Inventory items into Inventory table
def insert_inventory(inventory):
    cursor.execute("INSERT INTO Inventory(IDesc, IPrice) VALUES(?, ?)", (inventory.description, inventory.price))


insert_inventory(inventory1)
insert_inventory(inventory2)
insert_inventory(inventory3)
insert_inventory(inventory4)
insert_inventory(inventory5)
insert_inventory(inventory6)
insert_inventory(inventory7)
insert_inventory(inventory8)
insert_inventory(inventory9)
insert_inventory(inventory10)
connection.commit()

# Insert Customers into Customer table

def insert_customers(customer):
    cursor.execute("INSERT INTO Customers(CFname, CLname) VALUES(?, ?)", (customer.first, customer.last))


insert_customers(customer1)
insert_customers(customer2)
insert_customers(customer3)
insert_customers(customer4)
insert_customers(customer5)
insert_customers(customer6)
insert_customers(customer7)
insert_customers(customer8)
insert_customers(customer9)
insert_customers(customer10)
connection.commit()

# Insert Sales into Sales table

def insert_sales(sale):
    cursor.execute("INSERT INTO Sales(SQty, STotal, CID, IID, EID ) VALUES(?, ?, ?, ?, ?)",
                   (sale.SQty, sale.STotal, sale.CID, sale.IID, sale.EID))


insert_sales(sale1)
insert_sales(sale2)
insert_sales(sale3)
insert_sales(sale4)
insert_sales(sale5)
insert_sales(sale6)
insert_sales(sale7)
insert_sales(sale8)
insert_sales(sale9)
insert_sales(sale10)
connection.commit()


connection.commit()
connection.close()
