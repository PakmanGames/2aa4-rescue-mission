package ca.mcmaster.se2aa4.island.teamXXX;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.island.team37.Explorer;

public class ActionsTest {
    private ExplorerFactory explorerFactory;
    // This for the test cases
    private Explorer explorer;

    public ActionsTest() {
        explorerFactory = new ExplorerFactory();
    }

    @BeforeEach
    public void initialize() {
        this.explorer = explorerFactory.createExplorer();
    }

    @Test
    public void testFlyAction() {

    }

    @Test
    public void testHeadingAction() {

    }

    @Test
    public void testEchoAction() {

    }

    @Test
    public void testScanAction() {

    }

    @Test
    public void testStopAction() {

    }
}
