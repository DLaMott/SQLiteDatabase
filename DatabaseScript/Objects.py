class Employee:
    def __init__(self, first, last):
        self.first = first
        self.last = last

    def fullname(self):
        return '{} {}'.format(self.first, self.last)

class Inventory:
    def __init__(self, description, price):
        self.description = description
        self.price = price

    def getDescription(self):
        return '{}'.format(self.description)

class Customer:
    def __init__(self, first, last):
        self.first = first
        self.last = last

    def fullname(self):
        return '{} {}'.format(self.first, self.last)

class Sales:
    def __init__(self, SQty, STotal, CID, EID, IID):
        self.SQty = SQty
        self.STotal = STotal
        self.CID = CID
        self.EID = EID
        self.IID = IID
    def get_FullSale(self):
        return '{} {} {} {} {}'.format(
            self.SQty, self.STotal, self.CID, self.EID, self.IID)

