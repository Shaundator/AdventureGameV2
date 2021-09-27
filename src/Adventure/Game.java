package Adventure;

public class Game {
    Room currentRoom = null;
    String currentInput;

    public Game() {
        Map map = new Map();
    }
    public void getStarterRoom(Room startRoom){
        currentRoom=startRoom;
    }

    public boolean validateInput(String input){
            if ((input.equalsIgnoreCase("Go North")) || (input.equalsIgnoreCase("Go N")) || (input.equalsIgnoreCase("North")) || (input.equalsIgnoreCase("N"))) {
                currentInput="north";
                return true;
            } else if ((input.equalsIgnoreCase("Go East")) || (input.equalsIgnoreCase("Go E")) || (input.equalsIgnoreCase("East")) || (input.equalsIgnoreCase("E"))) {
                return true;
            } else if ((input.equalsIgnoreCase("Go South")) || (input.equalsIgnoreCase("Go S")) || (input.equalsIgnoreCase("South")) || (input.equalsIgnoreCase("S"))) {
                input = "south";
                return true;
            } else if ((input.equalsIgnoreCase("Go West")) || (input.equalsIgnoreCase("Go W")) || (input.equalsIgnoreCase("West")) || (input.equalsIgnoreCase("W"))) {
                input = "west";
                return true;
            } else if (input.equalsIgnoreCase("look")) {
                input = "look";
                return true;
            } else if (input.equalsIgnoreCase("Help")) {
                input = "help";
                return true;
            } else if (input.equalsIgnoreCase("Exit")) {
                return true;
            }
            return false;
    } //Is userInput Command
    public void userInput(String input) {
        if ((input.equalsIgnoreCase("Go North")) || (input.equalsIgnoreCase("Go N")) || (input.equalsIgnoreCase("North")) || (input.equalsIgnoreCase("N"))) {
            if (currentRoom.north != null) {
                currentRoom = currentRoom.north;
                System.out.println("You travel to " + currentRoom.roomName);
            } else {
                System.out.println("You cannot travel this direction");
            }
        } else if ((input.equalsIgnoreCase("Go East")) || (input.equalsIgnoreCase("Go E")) || (input.equalsIgnoreCase("East")) || (input.equalsIgnoreCase("E"))) {
            if (currentRoom.east != null) {
                currentRoom = currentRoom.east;
                System.out.println("You travel to " + currentRoom.roomName);
            } else {
                System.out.println("You cannot travel this direction");
            }
        } else if ((input.equalsIgnoreCase("Go South")) || (input.equalsIgnoreCase("Go S")) || (input.equalsIgnoreCase("South")) || (input.equalsIgnoreCase("S"))) {
            if (currentRoom.south != null) {
                currentRoom = currentRoom.south;
                System.out.println("You travel to " + currentRoom.roomName);
            } else {
                System.out.println("You cannot travel this direction");
            }
        } else if ((input.equalsIgnoreCase("Go West")) || (input.equalsIgnoreCase("Go W")) || (input.equalsIgnoreCase("West")) || (input.equalsIgnoreCase("W"))) {
            if (currentRoom.west != null) {
                currentRoom = currentRoom.west;
                System.out.println("You travel to " + currentRoom.roomName);
            } else {
                System.out.println("You cannot travel this direction");
            }
        } else if (input.equalsIgnoreCase("look")) {
            System.out.println(currentRoom.roomName);
            System.out.println(currentRoom.roomDescription);
        } else if (input.equalsIgnoreCase("Help")) {
            System.out.println("You ask for help");
        } else if (input.equalsIgnoreCase("Exit")) {
            System.exit(0);
        }
        else{
            System.out.println("Not a valid command");
        }
    } //Menu
}

