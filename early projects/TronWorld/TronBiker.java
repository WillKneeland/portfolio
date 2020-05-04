
import info.gridworld.grid.*;
import info.gridworld.actor.*;

import java.awt.Color;

/**
 * Write a description of class TronBiker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TronBiker extends Bug
{
    protected Grid<Actor> gr = null;
    protected Location location = getLocation();
    /**
     * Constructs a red biker.
     */
    public TronBiker()
    {
        setColor(Color.RED);
        setAILocation(new Location(4,8));
    }

    /**
     * Constructs a biker of a given color.
     * @param bikerColor the color for this biker
     */
    public TronBiker(Color bikerColor)
    {
        setColor(bikerColor);
    }

    /**
     * Moves if it can move, turns otherwise.  Also occasionally turns.  Can also see walls ahead
     * of time.  Can also set if game over.
     */
    public void act()
    {
        int rand=((int)(Math.random()*16));
        if ((rand==2 || rand==4) & canMove())
            turn();
        else if ((rand==3 || rand==6 || rand==9) & canMove())
            turnLeft();
        else if (canMove())
            move();
        //else
            //gameover();
    }

    /**
     * Turns the bug 45 degrees to the right without changing its location.
     */
    public void turn()
    {
        setDirection(getDirection() + Location.RIGHT);
    }
    
    /**
     * Turns the bug 45 degrees to the left without changing its location.
     */
    public void turnLeft()
    {
        setDirection(getDirection() + Location.LEFT);
    }

    public void setAILocation(Location loc)
    {
        setLocation(loc);
    }

    /**
     * Moves the bug forward, putting a flower into the location it previously
     * occupied.
     */
    public void move()
    {
        Grid<Actor> gr = getGrid();
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
     * Tests whether this bug can move forward into a location that is empty or
     * contains a flower.
     * @return true if this bug can move.
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        if (neighbor == null)
            return (neighbor == null);
        else //make sure to change to gamestate over.
            return (neighbor == null);
        // ok to move into empty location
        // not ok to move onto any other actor
    }
    
//     /**
//      * Tests to see if there is a wall 2 blocks away from the biker.
//      */
//     public boolean isWall()
//     {
//         Grid<Actor> gr = getGrid();
//         if (gr == null)
//             return false;
//         Location first = getLocation();
//         Location second = first.getAdjacentLocation(getDirection());
//         Location third = second.getAdjacentLocation(getDirection());
//         Location last = third.getAdjacentLocation(getDirection());
//         if ((!gr.isValid(second) || !gr.isValid(third)) || !gr.isValid(last))
//             return false;
//         Actor neighbor1 = gr.get(second);
//         Actor neighbor2 = gr.get(third);
//         Actor neighbor3 = gr.get(last);
//         return ((neighbor1 == null || neighbor2 == null) || neighbor3 == null);
//     }
}
