import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.awt.Color;

/**
 * Write a description of class TronRider here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TronRider2 extends TronBiker
{
    protected Grid<Actor> gr = null;
    protected Grid<Actor> grid = null;
    protected Location location = null;
    /**
     * Constructs a red Player controlled biker.
     */
    public TronRider2()
    {
        gr = RunGame.world.getGrid();
        setColor(Color.RED);
        putSelfInGrid(gr, new Location(3,7));
        setDirection(180);
    }

    /**
     * Constructs a Player controlled biker of a given color.
     * @param bikerColor the color for this biker
     */
    public TronRider2(Color bikerColor)
    {
        setColor(bikerColor);
    }

    /**
     * Moves if it can move, turns otherwise.
     */
    public void act()
    {
        RunGame.testGameState();
        if(canMove())
            move();
    }

    /**
     * Turns the player in the direction specified without changing its location.
     */
    public void turnRight()
    {
        if (getDirection() == 270)
        {
        }
        else
            setDirection(90);
    }
    
    /**
     * Turns the player in the direction specified without changing its location.
     */
    public void turnLeft()
    {
        if (getDirection() == 90)
        {
        }
        else
            setDirection(270);
    }
    
    /**
     * Turns the player in the direction specified without changing its location.
     */
    public void turnUp()
    {
        if (getDirection() == 180)
        {
        }
        else
            setDirection(0);
    }
    
    /**
     * Turns the player in the direction specified without changing its location.
     */
    public void turnDown()
    {
        if (getDirection() == 0)
        {
        }
        else
            setDirection(180);
    }

    /**
     * Moves the bug forward, putting a flower into the location it previously
     * occupied.
     */
    public void move()
    {
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        BikerWall wall = new BikerWall(getColor());
        wall.putSelfInGrid(gr, loc);
    }

    /**
     * Tests whether this biker can move forward into a location that is empty.
     * @return true if this biker can move.
     */
    public boolean canMove()
    {
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        if (neighbor == null)
            return (neighbor == null);
        else if (neighbor instanceof Wall) //make sure to change to gamestate over.
        {
            this.removeSelfFromGrid();
            return false;
        }
        else if (neighbor instanceof BikerWall)
        {
            this.removeSelfFromGrid();
            return false;
        }
        else if (neighbor instanceof TronRider2)
        {
            this.removeSelfFromGrid();
            return false;
        }
        else
            return (neighbor == null);
        // ok to move into empty location
        // not ok to move onto any other actor
    }
}