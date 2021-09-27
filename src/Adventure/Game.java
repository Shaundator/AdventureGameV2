package Adventure;

public class Game {
    Player player = new Player("Jack");

    public Game(){
    }

    public void move(String input) {
        if (input.equals("North")) {
            if (player.playerRoom.north != null) {
                player.playerRoom = player.playerRoom.north;
                System.out.println("You travel to " + player.playerRoom.roomName);
            } else {
                System.out.println("You cannot travel this direction");
            }
        }
        if (input.equals("East")) {
            if (player.playerRoom.east != null) {
                player.playerRoom = player.playerRoom.east;
                System.out.println("You travel to " + player.playerRoom.roomName);
            } else {
                System.out.println("You cannot travel this direction");
            }
        }
        if (input.equals("South")) {
            if (player.playerRoom.south != null) {
                player.playerRoom = player.playerRoom.south;
                System.out.println("You travel to " + player.playerRoom.roomName);
            } else {
                System.out.println("You cannot travel this direction");
            }
        }
        if (input.equals("West")) {
            if (player.playerRoom.west != null) {
                player.playerRoom = player.playerRoom.west;
                System.out.println("You travel to " + player.playerRoom.roomName);
            } else {
                System.out.println("You cannot travel this direction");
            }
        }
    }
    public void menu(String input) {
        if (input.equals("Look")) {
            System.out.println(player.name + " looks around");
            System.out.println(player.playerRoom.roomDescription);
        }
        if (input.equals("Help")) {
            System.out.println(player.name + " asks for help");
        }
        if (input.equals("Exit")) {
            System.exit(0);
        }
    }
}

