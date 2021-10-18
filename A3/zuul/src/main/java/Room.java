import java.util.HashMap;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room 
{
    HashMap<String, Room> exit;
    public String description;
    private boolean isMagicRoom = false;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        exit = new HashMap<>();
        this.description = description;
    }
    public Room(String description, boolean isMagicRoom)
    {
        exit = new HashMap<>();
        this.description = description;
        this.isMagicRoom = isMagicRoom;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west, Room up, Room down)
    {
        if(north != null) {
            exit.put("northExit", north);
        }
        if(east != null) {
            exit.put("eastExit", east);
        }
        if(south != null) {
            exit.put("southExit", south);
        }
        if(west != null) {
            exit.put("westExit", west);
        }
        if(up != null) {
            exit.put("upExit", up);
        }
        if(down != null) {
            exit.put("downExit", down);
        }
    }

    public Room getNorthExit(){
        return exit.get("northExit");
    }
    public Room getEastExit(){
        return exit.get("eastExit");
    }
    public Room getSouthExit(){
        return exit.get("southExit");
    }
    public Room getWestExit(){
        return exit.get("westExit");
    }
    public Room getUpExit(){
        return exit.get("upExit");
    }
    public Room getDownExit(){
        return exit.get("downExit");
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    public boolean isMagicRoom(){
        return this.isMagicRoom;
    }

}
