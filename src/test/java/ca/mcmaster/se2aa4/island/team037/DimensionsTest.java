package ca.mcmaster.se2aa4.island.team037;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DimensionsTest {
    private ExplorerFactory explorerFactory;
    // This for the test cases
    private Explorer explorer;

    public DimensionsTest() {
        explorerFactory = new ExplorerFactory();
    }

    @BeforeEach
    public void initialize() {
        this.explorer = explorerFactory.createExplorer();
    }

    @Test
    public void testGetLength() {
        // Go right as far as possible
        // then Go left as far as possible (Track the amount of units gone, this is the
        // length of the map)

        // Either that or use the ECHO command to get the information
    }

    @Test
    public void testGetWidth() {
        // Go down as far as possible
        // then Go up as far as possible (Track the amount of units gone, this is the
        // width of the map)

        // Either that or use the ECHO command to get the information
    }


    @Test
    public void moveToCorner() {
    }

}
