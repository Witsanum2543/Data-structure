import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Room previousRoom;
    private List<Room> allRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, lectureroom, pub, lab, office, office2, canteen, park;

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        lectureroom = new Room("in a lecture room");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab",true);
        office = new Room("in the computing admin office");
        office2 = new Room("in the science admin office");
        canteen = new Room("in the canteen");
        park = new Room("at the park");

        allRoom = Arrays.asList(outside, lectureroom, pub, lab, office, office2, canteen, park);

        // initialise room exits
        outside.setExits(null, lectureroom, lab, pub,null,null);
        lectureroom.setExits(null, canteen, null, outside,null,null);
        pub.setExits(null, outside, null, null,null,null);
        lab.setExits(outside, office, null, null,null,null);
        office.setExits(null, null, null, lab, office2,null);
        office2.setExits(null, null, null, null,null,office);
        canteen.setExits(null,park,null,lectureroom,null,null);
        park.setExits(null,null,null,canteen,null,null);

        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printCurrentLocationInfo();

    }

    // print current location information
    private void printCurrentLocationInfo(){
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("Exits: ");
        if(currentRoom.getNorthExit() != null) {
            System.out.print("north ");
        }
        if(currentRoom.getEastExit() != null) {
            System.out.print("east ");
        }
        if(currentRoom.getSouthExit() != null) {
            System.out.print("south ");
        }
        if(currentRoom.getWestExit() != null) {
            System.out.print("west ");
        }
        if(currentRoom.getUpExit() != null) {
            System.out.print("up ");
        }
        if(currentRoom.getDownExit() != null) {
            System.out.print("down ");
        }
        System.out.println();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else  if (commandWord.equals("look")) {
            look();
        }
        else  if (commandWord.equals("back")) {
            back();
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void look()
    {
        printCurrentLocationInfo();
    }

    private void back()
    {
        this.currentRoom = this.previousRoom;
        printCurrentLocationInfo();
    }

    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        this.previousRoom = currentRoom;
        Room nextRoom = null;
        if(direction.equals("north")) {

            nextRoom = currentRoom.getNorthExit();
        }
        if(direction.equals("east")) {
            nextRoom = currentRoom.getEastExit();
        }
        if(direction.equals("south")) {
            nextRoom = currentRoom.getSouthExit();
        }
        if(direction.equals("west")) {
            nextRoom = currentRoom.getWestExit();
        }
        if(direction.equals("up")) {
            nextRoom = currentRoom.getUpExit();
        }
        if(direction.equals("down")) {
            nextRoom = currentRoom.getDownExit();
        }

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            if(nextRoom.isMagicRoom()) {
                Random rand = new Random();
                Room randomRoom = allRoom.get(rand.nextInt(allRoom.size()));
                currentRoom = randomRoom;
                System.out.println("You enter magic room that send you to random location");
            } else {
                currentRoom = nextRoom;
            }
            printCurrentLocationInfo();
        }
    }


    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
