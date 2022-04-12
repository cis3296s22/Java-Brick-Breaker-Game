import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

import java.awt.*;
import java.io.IOException;

public class GameBoardTest {
    GameBoard gb;

    @Before
    public void setup() throws IOException {
        gb = new GameBoard();
    }

    @Test
    public void scoreZeroAtStart(){
        int score;
        score = gb.score;
        assertEquals("Score should be zero", 0, score);
    }

    @Test
    public void scoreIncrementsAfterBrickDestroyed() throws IOException {
        int score;
        gb.bricks[0].doDamage();
        gb.checkCollision();
        score = gb.score;
        assertEquals("Score should be 1 after 1 brick destroyed", 1, score);
    }

    @Test
    public void scoreResetsWhenRestarted() throws IOException {
        //Add score
        gb.score = 4;
        //restart is clicked
        gb.restartButton.doClick();
        assertEquals("Score should be reset to 0 after restarted", 0, gb.score);

    }

    @Test
    public void speedIsOneAtStart(){
        assertEquals(1, gb.speed, "Should be 1");
    }

    @Test
    public void speedIsOnePointTwoAfterFiveBricksDestroyed() throws IOException {
        gb.score = 5;
        gb.checkCollision();
        assertEquals(1.2, gb.speed, "Should be 1.5");
    }

    @Test
    public void speedIsDoubleAfterFifteenBricksDestroyed() throws IOException {
        gb.score = 15;
        gb.checkCollision();
        assertEquals(2, gb.speed, "Should be 2");
    }

    @Test
    public void speedIsResetOnRestart() throws IOException {
        //speed set to 2
        gb.speed = 2;
        //click restart
        gb.restartButton.doClick();

        assertEquals(1, gb.speed, "Should be 1");
    }
}