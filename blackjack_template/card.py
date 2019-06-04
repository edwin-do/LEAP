class card:

    #The constructor for the object Card
    def __init__(self,rank,suit):
        self.rank = rank
        self.suit = suit
        self.point = 0

    #The accessor that gets the rank of the card
    def get_rank(self):
        return #what goes here?

    #The accessor that gets the suit of the card
    def get_suit(self):
        return #what goes here?

    #The accessor that returns the string of the card
    def toString(self):
        card_rank = ""
        if (self.rank == 'A'):
            card_rank = "Ace of "
        elif (self.rank == 'K'):
            card_rank = "King of "
        elif (self.rank == 'Q'):
            card_rank = "Queen of "
        elif (self.rank == 'J'):
            card_rank = "Jack of "
        else:
            card_rank = str(self.rank) + " of "

        return card_rank + str(self.suit)

    #The mutator that assign a point to the card
    def set_points(self,user):
        if (self.rank == 'A' and user == 'p'):
            eleven = input("Would you like your ace to count as eleven points? Enter y or n\n")
            if eleven == 'y':
                self.point = 11
            elif eleven == 'n':
                self.point = 1
            else:
                print("Wrong input, defaulting to one point")
                self.point = 1
        elif (self.rank == 'A' and user == 'd'): 
            return 1    
        elif (self.rank == 'K'):
            #what goes here?
        elif (self.rank == 'Q'):
            #what goes here?
        elif (self.rank == 'J'):
            #what goes here?
        else:
            #what goes here?

    #The accessor that returns the point of each card
    def get_points(self):
        return #what goes here?
