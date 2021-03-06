# BrickBreaker (Wall Breaker - Breakout)

A group school project in progress...

## Development:

We will use a timer task to create the game cycle.

**The game will have 13 java files:**

- **Main.java** - *is the class that holds the main method and starts our game.*

    -  the main method creates the game object and runs it...

- **GameObject.java** - *is the base abstract class for all game objects in the game.*

    -  **Basic constructor** -- only sets destroyed to false.
    
    -  **Getters and setters** -- for the field variables.
    
    -  **Methods** -- getRect(), getLeft(), and getRight(). All return a new Rectangle object.

- **Paddle.java** - *is the class that will encapsulate the paddle object in our game which will be controlled with the left and right arrow keys.*

    -  **Basic constructor** -- sets the image, width, height, x, and y coordinates.
    
    -  **Getter and setter** -- NONE.
    
    -  **Methods** -- move, keyPressed, and keyReleased.

- **Ball.java** - *is the class that will create our ball objects in the game and will set their speed and movements.*

    -  **Basic constructor** -- sets the image, initial speed + initial x, and y coordinates.
    
    -  **Overloading constructor** -- sets new x and y coordinates.
    
    -  **Getters and setters** -- for direction and speed.
    
    -  **Methods** -- move()

- **Brick.java** - *is the class that will create our brick objects.*

    -  **Basic constructor** -- sets x and y coordinates, image, and the powerup.
    
    -  **Getters and setters** -- only for the powerup.
    
    -  **Methods** -- NONE.

- **Spider.java** - *is the class that creates the moving spiders (power-ups) objects.*

    -  **Basic Constructor** -- sets x and y coordinates, image, destroyed to false, and the random extra.
    
    -  **Getters and setters** -- only for the boolean extra.
    
    -  **Methods** -- move() only in y direction.

- **FreeGift.java** - *is the class that creates the free gift drop after each game level.*

    -  **Basic Constructor** -- only sets x and y coordinates + the image.
    
    -  **Getters and setters** -- NONE.
    
    -  **Methods** -- move() only in y direction.

- **Board.java** - *is the class that will hold our main game logic.*

    -  **Basic Constructor** -- setFocusable, setDoubleBuffered, addKeyListener.
    
    -  **Getters and setters** -- NONE + all field variables should be private!
    
    -  **Methods** -- playGame, setBricks, override paintComponent(Graphics g), displayMessage, drawObjects, update, checkBrickCount, catchTheSpiders, giveFreeGift, catchTheGift, checkBallCollisions, getRandomBoolean, pause, resume, endGame.
    
    -  **private class** -- MyAdapter extending the KeyAdapter for the KeyEvents.

- **Breakout.java** - *is the class that creates the frame, menu bar items, and adds the game board.*

    -  **Basic Constructor** -- initGUI, setMenuBar, createEvents.

- **Animate.java** - *is the class for actions to be performed by the timer task.*

    -  **Runs the timer tasks** -- update and repaint.

- **Commons.java** - *is the interface file that will declare game constants and common methods.*

- **Sound.java** - *is the enum file that will load and play sound effects*

- **About.java** - *the about window*