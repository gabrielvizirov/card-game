***	README.txt	******************************************************
------------------------------------------------------------------------------
Fulltime Project Card Game

Title: Card Game
File (main): cardGame.java
Author: Vizirov, Gabriel
Last Modified: August 21, 2016
------------------------------------------------------------------------------

Specifics:
Java programming language was used.
I used Eclipse Neon Java IDE on Windows 10 to write, compile, and test the program.
Eclipse IDE for Java Developers
Version: Neon Release (4.6.0)
Build id: 20160613-1800
I used 'JavaSE-1.8' (jre 1.8.0_101)
cardGame.java is the main file to run the game.
(no .exe file was created)

Items that might need to be downloaded to run the program:
Eclipse Neon Java IDE, found at "https://www.eclipse.org/downloads/"
JavaSE JDK and JRE, found at "http://www.oracle.com/technetwork/java/javase/downloads/index.html"

Java will need to be installed in Windows OS if you do not have it already installed.
Java should already be installed, by default, to the kernel in Linux or Unix.

-------------------------------------------------
Run:

To run the program in Eclipse IDE for Java Developers in a Windows OS:
1. Open Eclipse Java Neon
2. Create a workspace directory or use the default given, press the "OK" Button.
3. Select "File->New->Java Project"
4. A box will open, go to the "Project name:" textbox and enter "cardgame" (all lowercase).
5. Click on the "Finish" Button.
6. In the "Package Explorer" window, select the "cardgame" folder, right-click and select "New->Package"
7. A box will open, go to the "Name:" textbox and enter "cardgame" (all lowercase).
8. Click on the "Finish" Button.
9. Go to the folder directory you have the java files stored on your PC.
10. Drag the java files into the "cardgame" package we have just created.
11. A box will appear with "Copy files" already selected. Click on the "OK" Button to continue.
12.double click on cardgame.java in the package explorer which should open up in the code window.
13. Click on "Project->Build All" at the top menu to compile the code, or use the hotkey "CTRL-B". (This step should not be needed as Eclipse auto compiles the code in Neon.)
14. Click on "Run->Run" at the top menu to start the program,or press the play button on the toolbar, or use the hotkey "CTRL-F11"
15. Click on the "Console" window to press Enter when the game asks for the "Enter" Key Press.
16. Run the game till it asks to press "Enter" to exit and quit


To run the program in a Linux Terminal:
1. Go to the Directory where the files are located.
2. Type "javac *.java" and press ENTER to compile all the java files.
3. Type "java cardgame" to run the program.
4. Follow the instructions given in the game.


-------------------------------------------------
To Play:
Follow the instructions given in the game or here.
1. The game will ask for the amount of players.
- Type in the number of players from 2 to 4 and press "Enter"
- if you type an invalid number, the game will ask to type again

2. The game will then ask to type a unique name for every player. Press "ENTER" after typing a name.
- the game will not allow duplicate names. If you type a name that is not unique, it will as you to type again.
- the game will also not allow an empty name.

3. The game will  shuffle the card deck and ask a player to press enter to draw a card.
- Press "ENTER" and a card will be drawn.

4. The game will continue to ask players to press "ENTER" to draw cards till all players have drawn a card.
- The players will go in the order that the name was given at the start of the game.

5. After each round, the game will tell which player won that round
- The game will also print a scoreboard with all the players and their points.

6. The next round will start and will repeat over and over until one player reaches a score that is over 21 points total and 2 more points above the other players.

7. After we get a winner, the game over information appears telling who won.

8. The game will ask the player to press "ENTER" to then exit and quit the program.

-------------------------------------------------
Object of the Game:
(Similar to the card game "War" but with addition of 4 penalty cards)
This is a 2-4 player card game.
Each player draws a card from a shuffled deck of cards.
The player with the highest value card will get 2 points that round.
Values range from (2,3,4,5,6,7,8,9,10,Jack,Queen,King,Ace) with "2" being lowest and "Ace" being highest.
If the players get the same value cards, the outcome will then be decided by the Suit of the card which ranges from (Club < Diamond < Heart < Spade) where "Spade is the highest value suit.
If a player gets a penalty card, that player will lose 1 point.
The player will not lose a point if their score is already at 0.
If all players get penalty cards, no one wins that round and all players will get a 1 point reduction to their scores.
After the round, the cards get placed back into the deck and the deck then gets shuffled again.
The players will continue to play till one player reaches a score of 21 or higher.
The player must lead the other players by 2 points. (example if one player scores 21, and another player scores 20, the game will still continue.)
Once a player reaches the score of 21 or higher, that player is the winner of the game.

-------------------------------------------------
The files provided include: 
(No .exe file was created)
a. cardgame.java - the main program file for the user to run. Calls Game.java to start the game.
b. Game.java - This is the file that cardgame.java calls in order to initialize, start, play, and end the game
c. PlayerSet.java - This file stores a list of players, as well as prints out their scores.
d. Player.java - This file stores a players name and score.
e. Deck.java - This file stores a list of cards. It also shuffles the cards in random order and prints out the cards on screen.
f. Card.java - This file stores a cards value(2,3,4,5,6,7,8,9,10,Jack,Queen,King,Ace) and the suit(Club, Diamond, Heart, Spade).