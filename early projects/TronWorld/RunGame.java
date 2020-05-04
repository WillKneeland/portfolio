/* 
 * TronWorld, a tron game in gridworld.
 * A 2 player game with music.
 * Made for the AP computer science final project.
 * 
 * Made by William Kneeland using gridworld methods.
 * 
 * Version 1.0 Completed 6/4/17
 */

import info.gridworld.actor.TronWorld;
import info.gridworld.actor.Wall;
import info.gridworld.actor.BikerWall;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.gui.GUIController;
import info.gridworld.world.World;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class runs a world that contains a bug and a rock, added at random
 * locations. Click on empty locations to add additional actors. Click on
 * populated locations to invoke methods on their occupants. <br />
 * To build your own worlds, define your own actors and a runner class. See the
 * BoxBugRunner (in the boxBug folder) for an example. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class RunGame
{
    private static TronRider1 player1;
    private static TronRider2 player2;
    private static String message;
    private static int P1score;
    private static int P2score;
    public static TronWorld world = new TronWorld(new BoundedGrid(15, 15));
    private static Sound music;
    /**
     * The main method that runs the game.
     */
   public static void main(String[] args)
    {
        //Sets up world's walls.
        for (int i=0; i<15; i++)
            world.add(new Location(0,i), new Wall());
        for (int i=0; i<15; i++)
            world.add(new Location(i,0), new Wall());
        for (int i=0; i<15; i++)
            world.add(new Location(14,i), new Wall());
        for (int i=0; i<15; i++)
            world.add(new Location(i,14), new Wall());
        
        //world.add(new TronBiker());  <-- code for AI, used for testing.
        addPlayers();
        message = "Player 1's Score: " + P1score + "\nPlayer 2's Score: " + P2score;
        world.setMessage(message);
        music = new Sound();
        world.show();
        world.getFrame().setSize(771, 893);
        instructions();
        
        //needed code for keyboard event handling
        java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager()
            .addKeyEventDispatcher(new java.awt.KeyEventDispatcher() {
            public boolean dispatchKeyEvent(java.awt.event.KeyEvent event) {
                String key = javax.swing.KeyStroke.getKeyStrokeForEvent(event).toString();
                if (key.equals("pressed A"))
                    player1.turnLeft();
                if (key.equals("pressed D"))
                    player1.turnRight();
                if (key.equals("pressed W"))
                    player1.turnUp();
                if (key.equals("pressed S"))
                    player1.turnDown();
                if (key.equals("pressed LEFT"))
                    player2.turnLeft();
                if (key.equals("pressed RIGHT"))
                    player2.turnRight();
                if (key.equals("pressed UP"))
                    player2.turnUp();
                if (key.equals("pressed DOWN"))
                    player2.turnDown();
                world.show();
                return true;
            }
        });
} 

public static void addPlayers()
{
    TronRider1 a = new TronRider1();
    player1 = a;
    TronRider2 b = new TronRider2();
    player2 = b;
}

public static void instructions()
{
    System.out.println("\t\t***************************************");
    System.out.println("\t\t\tWELCOME TO TRONWORLD!!!");
    System.out.println("\t\t***************************************");
    System.out.println();
    System.out.println();
    System.out.println("******************************************************************************");
    System.out.println("INSTRUCTIONS:");
    System.out.println();
    System.out.println("\tIn \"TronWorld\" there are 2 players who duel like a game of chicken.");
    System.out.println("Both players leave a trail of walls in their path. Both players are trying");
    System.out.println("to get the other player to run into a wall. The player who doesn't run into");
    System.out.println("a wall gets a point. The players play 3 to 5 rounds, depending on how many");
    System.out.println("rounds each player wins. The player with the highest score wins.");
    System.out.println("******************************************************************************");
    System.out.println();
    System.out.println();
    System.out.println("******************************************************************************");
    System.out.println("HOW TO PLAY:");
    System.out.println();
    System.out.println("Player1 -(Blue biker)- is controled with the WASD keys (w = turns up,");
    System.out.println("a = left, s = down and d = right)");
    System.out.println("Player2 -(Red biker)- is controled with the arrow keys (each key turning the");
    System.out.println("bike in the direction the arrow points)");
    System.out.println();
    System.out.println("\tTo begin a game, click \"Play\", and to pause the game, click \"Pause.\"");
    System.out.println("The game will not decide a winner if you click the red x button to exit the");
    System.out.println("game. To decide a winner, finish the game, and then when the dialog box");
    System.out.println("appears, the game will calculate who has the highest score, and declare");
    System.out.println("them the winner.");
    System.out.println();
    System.out.println("\tIf you wish for a faster game, use the speed sliding bar to change the");
    System.out.println("speed that the players move at. (RECOMMENDED TO LEAVE THE SPEED AS IS)");
    System.out.println();
    System.out.println("***IMPORTANT***: DO NOT CLOSE THIS WINDOW. IT TELLS YOU YOUR SCORE.");
    System.out.println("There is a score window above the game as well, but the score is printed");
    System.out.println("here too for when the game closes after it is over.");
    System.out.println();
    System.out.println("******************************************************************************");
}

/**
 * Tests the state of the game (still going, over, etc.)
 */
public static void testGameState()
{
    String p = "";
    if (player1.getLocation() == null)
    {
        //Location g;
        //Grid<Actor> gr;
        P2score++;
        message = "Player 1's Score: " + P1score + "\nPlayer 2's Score: " + P2score;
        world.setMessage(message);
        world.show();
        player2.removeSelfFromGrid();
        System.out.println("**Player 1's Score: " + P1score + "***\n\n***Player 2's Score: " + P2score + "***");
        System.out.println("**Player 2 Wins!!!***");
        JOptionPane.showMessageDialog(null, "Player 2 Wins!!!");
        // System.out.print("Would you like to play another round?(y = yes, n = no): ");
        // p = scan.nextLine();
        // if (p.toLowerCase().equals("y"))
        // {
            // for (int row=1; row<13; row++)
                // for (int col=1; col<13; col++)
                // {
                    // gr = RunGame.world.getGrid();
                    // g = new Location(row, col);
                    // if (gr.get(g) != null)
                    // {
                        // remove(gr, g);
                    // }
                // }       
            // addPlayers();
        //}
        System.exit(0);
    }
    if (player2.getLocation() == null)
    {
        //Location g;
        //Grid<Actor> gr;
        P1score++;
        message = "Player 1's Score: " + P1score + "\nPlayer 2's Score: " + P2score;
        world.setMessage(message);
        world.show();
        player1.removeSelfFromGrid();
        System.out.println("**Player 1's Score: " + P1score + "***\n\n***Player 2's Score: " + P2score + "***\n");
        System.out.println("**Player 1 Wins!!!***");
        JOptionPane.showMessageDialog(null, "Player 1 Wins!!!");
        // System.out.print("Would you like to play another round?(y = yes, n = no): ");
        // p = scan.nextLine();
        // if (p.toLowerCase().equals("y"))
        // {
            // for (int row=1; row<13; row++)
                // for (int col=1; col<13; col++)
                // {
                    // gr = RunGame.world.getGrid();
                    // g = new Location(row, col);
                    // if (gr.get(g) != null)
                    // {
                        // remove(gr, g);
                    // }
                // }       
            // addPlayers();
        // }
        System.exit(0);
    }
}

/**
     * Removes an actor from this world.
     * @param loc the location from which to remove an actor
     * @return the removed actor, or null if there was no actor at the given
     * location.
     */
    public static Actor remove(Grid<Actor> gr, Location loc)
    {
        Actor occupant = gr.get(loc);
        if (occupant == null)
            return null;
        occupant.removeSelfFromGrid();
        return occupant;
    }
}
