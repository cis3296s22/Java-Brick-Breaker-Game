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

### UML
![image](https://user-images.githubusercontent.com/89605166/160735798-bda32cd7-d1e3-49ac-8881-925172340069.png)
![image](https://user-images.githubusercontent.com/89605166/160735657-424c4aaa-a611-4958-a4e7-43c8e83c4baf.png)


