<a id="org8720041"></a>

# Othello

This is the implementation of the table game Reversi, or Othello, whose rules can be viewed [here](https://en.wikipedia.org/wiki/Reversi) . This program was made as a project on the first year of university.


<a id="org6d1601b"></a>

## Using

To use the program, just run the makefile. This will create a Main.class file on the current directory. This will create all the `.class` files on the current, which can be removed by running `make clear`.

Enter `java Main` to run the program. Then a prompt will appear asking for the name of the players and the game will start. At each turn, the current table will appear and a prompt will ask where the next piece should be placed. Once there are no more valid moves, the game will end and the points of each player will be shown.

The program also accepts passing a text file as a command line argument to show the replay of a game.


<a id="org4505e93"></a>

## Testing

There is a program to do the basic tests. To run this test, first compile the test file with `make test`, and then run the Test class.

