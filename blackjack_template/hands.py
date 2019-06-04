import card
class hand:

    #Constructor of the object Hand
    def __init__(self):
        self.hand = []

    #mutator that adds a card to the hand
    def add_card(self,card):
        self.hand.append(card)

    #accessor that returns the hand(array of cards)
    def get_hand(self):
        return #what goes here?
    
    #accessor that returns the total points of the hand
    def get_total_points(self):
        total = 0  
        for card in self.hand:
            total += card.get_points()
        return total

    #accessor that returns the total points of the dealer
    def get_total_points_dealer(self):
        total = 0  
        for card in self.hand:
            total += card.get_points()
        return total

    #mutator that restarts the hand 
    def restart(self):
        self.hand = []