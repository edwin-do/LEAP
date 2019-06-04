import random
import stats
import sys

#import classes used from other modules
from card import card
from suits import suits
from hands import hand

#Declare variables
ranks = ['A','K','Q','J',10,9,8,7,6,5,4,3,2]
player_hand = hand()
dealer_hand = hand()

#checks if a card has already been previously dealt
def check_dealt(card):
     for c in stats.dealt_cards:
          if c == card:
               return True
     return False

#checks to see if the user input is valid
def check_bet(b):
     try:
          if not str(b):
               print("Enter a number")
               return True
          elif(): #what goes here?
               print("You're betting too much!")
               return True
          elif(): #what goes here?
               print("Too little! Bet more!")
               return True
          else:
               return False
     except ValueError:
          print("Enter a number")
          return True

#checks the points and declares the result
def check_points():
     stats.bet = int(stats.bet)

     player_points = player_hand.get_total_points()
     dealer_points = dealer_hand.get_total_points_dealer()

     print("You have " + str(player_points) + " points")
     print("Dealer has " + str(dealer_points) + " points")

     #what goes here?
     if ():
          print("BUST! You lose")
          stats.balance -= stats.bet
     #what goes here?
     elif ():
          print("Dealer Bust! You Win")
          stats.balance += stats.bet
     #what goes here?
     elif ():
          print("You lose! Try again")
          stats.balance -= stats.bet
     #what goes here?
     elif ():
          print("You Win! Congrats")
          stats.balance += stats.bet

     if (stats.balance == 0):
          print("Sorry, you're out of money. Thanks for playing")
          sys.exit(0)

#gets a new random card 
def get_new_card():
     return card(random.choice(ranks), suits(random.randint(1,4)))

#allows the player to place a bet
def place_bet():
    print("Your current balance is " + str(stats.balance)) 
    stats.bet = input("Place Bet\n$")
    while(check_bet(stats.bet)):
         stats.bet = input("Try Again\n$")

#deals a card
def deal_card():
     c = get_new_card()
     while check_dealt(c):
         c = get_new_card()

     stats.dealt_cards.append(c)
     return c

#deals cards to the player 
def deal_player():
     p1 = deal_card()
     player_hand.add_card(p1)

     p2 = deal_card()
     player_hand.add_card(p2)

     print("Your cards are")
     for card in player_hand.get_hand():
         print(card.toString())

     p1.set_points('p')
     p2.set_points('p')

#deals a card to the dealer
def deal_dealer():
     d1 = deal_card()
     dealer_hand.add_card(d1)
     d1.set_points('d')
     print("Dealer's card is " + d1.toString())

#gives the player another card
def hit():
     p = deal_card();
     player_hand.add_card(p)
     print("Your cards are")
     for card in player_hand.get_hand():
         print(card.toString())
     p.set_points('p')  

#starts the game
def play_game():
     player_hand.restart()
     dealer_hand.restart()
     stats.dealt_cards = []

     place_bet()
     deal_player()
     print("You have " + str(player_hand.get_total_points()) + " points" )

     deal_dealer()


     extra = input("would you like another card? Enter 'y' for yes and any other key for no\n")
     while (extra == 'y'):
          hit()
          print("You have" + str(player_hand.get_total_points()))
          extra = input("would you like another card? Enter 'y' for yes and any other key for no\n")

     deal_dealer()

     while ( dealer_hand.get_total_points_dealer() <= player_hand.get_total_points() ):
          deal_dealer()

     check_points()
     print("Your new balance is " + str(stats.balance))
     play_again()

#asks player if they want to play again
def play_again():
     again = input("Continue to play? Enter y to continue or any other key to exit\n")
     if (again == 'y'):
          play_game()
     else:
          sys.exit(0)

play_game()