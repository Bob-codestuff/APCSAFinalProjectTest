# APCSAFinalProjectTest
Higher or Lower Game
This project is a console-based card game called Higher or Lower, where the player bets money on whether the next card will be higher or lower than the current card. The game includes features such as betting, doubling winnings, and saving the player's money between rounds. The game ends when the player runs out of money.

How to Play
The player starts with $100.
At the beginning of each round, the player chooses how much money to bet.
A card is dealt, and the player guesses whether the next card will be higher or lower.
If the player guesses correctly, their bet doubles.
If the player guesses incorrectly, they lose their bet.
The player can leave the game mid-round and start another game later.
The game ends entirely when the player runs out of money.
Classes



1. Card
The Card class represents a single playing card.

Fields:

String suit: The suit of the card (e.g., Hearts, Diamonds).
String face: The face value of the card (e.g., Ace, King, 10).
int value: The numerical value of the card.
Methods:

getSuit(): Returns the suit of the card.
getFace(): Returns the face value of the card.
getValue(): Returns the numerical value of the card.
getAsciiArt(): Returns an ASCII art representation of the card.





2. Deck
The Deck class represents a standard deck of 52 playing cards.

Fields:

ArrayList<Card> cards: A list of Card objects representing the deck.
Methods:

Deck(): Initializes a shuffled deck of 52 cards.
shuffle(): Shuffles the deck.
dealCard(): Deals the top card from the deck.
cardsLeft(): Returns the number of cards left in the deck.





3. Dealer
The Dealer class manages the deck and deals cards to the player.

Fields:

String name: The name of the dealer.
Deck deck: The deck of cards managed by the dealer.
Methods:

Dealer(String name): Initializes the dealer with a name and a new deck.
dealCard(): Deals a card from the deck.
resetDeck(): Resets the deck to a full shuffled deck.
cardsLeft(): Returns the number of cards left in the deck.





4. Player
The Player class represents the player in the game.

Fields:

String name: The name of the player.
double money: The amount of money the player has.
Methods:

Player(String name): Initializes the player with a name and $100.
getName(): Returns the player's name.
setName(String name): Sets the player's name.
getMoney(): Returns the player's current money.
addMoney(double amount): Adds money to the player's total.
subtractMoney(double amount): Subtracts money from the player's total.





5. Game
The Game class manages the gameplay and user interaction.

Fields:
Player player: The player in the game.
Dealer dealer: The dealer managing the deck.
Scanner scanner: A scanner for user input.
Methods:

Game(): Initializes the game with a dealer and a scanner.
start(): Starts the game loop, allowing the player to bet, guess, and win or lose money.





Features
Betting System:

The player starts with $100.
The player can bet any amount up to their total money.
Correct guesses double the player's bet.
ASCII Art:

Cards are displayed with ASCII art for better visualization.
Exit Mid-Game:

The player can type exit during a round to leave the game and keep their remaining money.
Game Over:

The game ends when the player runs out of money.
Money Persistence:

The player's money is saved between rounds.






Example GamePlay:
Hello player, please enter your name:
John
Welcome to Higher or Lower, John!
You are starting with $100.00.
You are playing against Dealer.

How much would you like to bet? (You have $100.00)
50
You bet $50.00. Let's begin!

Dealing your first card...
First card:
  _____
 |A    |
 |  _  |
 | ( ) |
 |(_ _)|
 |  Y  |
 |____A|

Will the next card be (h)igher or (l)ower? (or type 'exit' to leave): h
Next card:
  _____
 |10   |
 |  /\  |
 | /  \ |
 | \  / |
 |  \/  |
 |___10 |
Correct! Your bet is now $100.00.

Will the next card be (h)igher or (l)ower? (or type 'exit' to leave): exit
You chose to leave the game. Your remaining money: $150.00.

Do you want to play again? (y/n): n
Thanks for playing, John! You leave with $150.00.





Future Improvements
Add a leaderboard to track the highest winnings.
Implement additional game modes or challenges.
Add a graphical user interface (GUI) for better user experience.
