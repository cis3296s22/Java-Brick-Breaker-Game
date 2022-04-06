# Java Brick Breaker Game
Java Brick Breaker Game is a game application that involves hand-eye coordination and quick thinking from the user. The goal of the game is to break all of the “bricks” that appear at the top of the game window using a “ball” and a “paddle” without letting the ball reach the bottom of the window. Once the user presses a start button, a circular entity representing the ball will start moving down the screen. The user can control the racket by moving it either left or right using the two arrow-key buttons on the keyboard. If timed correctly, the racket can reverse the ball’s direction if it touches it, making it go towards the bricks. If the ball manages to touch a brick, the brick will disappear and the ball will be deflected back towards the bottom of the screen. At the top of the window, there is also a score value that increments as a brick is obliterated. If the ball slips past the racket, or if the player successfully hits all bricks, the score will be shown on the middle of the screen and displaying either a win or lose. Levels will become progressively difficult as the player breaks all of the bricks.
This project is built off of an open-source project located in this GitHub Repository by Git-user janbodnar: https://github.com/janbodnar/Java-Breakout-Game

![image](https://user-images.githubusercontent.com/89492718/159178301-99cdba6c-e206-407f-955c-8cdb440b20c3.png)

# Project Board
https://trello.com/b/43fRtdGo/project-board

# How to run
- Download the latest binary from the Release section on the right on GitHub.  
- On the command line uncompress using
```
tar -xzf Java-Brick-Breaker-Game-<version>.tar.gz
```
- On the command, go to file location inside of uncompressed folder
```
cd Java-Brick-Breaker-Game-<version>/out/production/concept-AlexHarvey63
```
- Run by typing command:
```
java BrickBreaker
```
- After running, a window should open up and display the different sprites. Once a change is added that needs to be tested, run the program and see the results of the changes and act on them accordingly. Changes and modifications should be added to other classes by using a text editor or IDE when necessary.

### How to build
- Use this github repository
- Use main branch for the most stable release
- Use latest version of Intellij or other Java compatible IDE
- Requires JPanel, JFrame, and ImageIO packages
- Run the file with the main method, this can be found in BrickBreaker.java
- In terminal:
  - Change current directory to location of code by typing: `cd /<name of cloned repository>/src/main/java`
  - To compile: `javac BrickBreaker.java`
  - To run: `java BrickBreaker`

- After running the app, a window should pop-up and display the paddle, ball, and brick sprites along with additional details.

# UML
![image](https://user-images.githubusercontent.com/89605166/160741478-9e21a3fe-639c-41a0-b2f4-9af7b0143d39.png)
![image](https://user-images.githubusercontent.com/89605166/160741483-c92232b9-dfb7-4899-91d0-a8b93b060bb6.png)
![image](https://user-images.githubusercontent.com/77736858/161879447-8809d9c4-3985-40b9-a860-c0178a79a625.png)

figure 3 updated on April 5, 22

### Brief UML Overview
The sprite class includes the get and set methods that are used to help generate the visual, moving elements of the game such as the racket, ball and bricks. Naturally, the racket, ball, and brick classes extend sprite, allowing them to initialize their respective positions in the game and generate their visuals. The racket class implements the basicallity functionality of the racket such as move and responding to pressed keys by the user. The ball class behaves similarly, initializing its position while also creating its unique, private move function to define its behavior. Finally, Brick acts in a similar manner, but includes a boolean variable tracking whether or not it has been touched by the ball. If it touched by the ball, its status is update to destroyed.  
The GameBoard, HighScoreBoard, and MenuScreen classes all extend JPanel, a container class. HighScoreBoard and MenuScreen both initialize the visualize components of their respective features. They both use nested private classes, such as returnHandler and startHandler to implement different features of the game such as start and return. GameBoard implements instances of the racket, bricks and ball. It is responsible for printing messages to the user such as “game over”. GameBoard also implements user functionality features like pause and resume by also using nested private classes to handle the functions. Similarly, it contains a nested class to track each time the user pushes and releases a game key. The program package also includes the configuartions interface. This interface includes only attributes relating to the dimensions of each of the game pieces. Lastly, the BrickBreaker class extends the JFrame class and houses the only main() function for the entire program and is responsible for launching the game.




