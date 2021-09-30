package Adventure;

import java.util.Scanner;

public class Adventure {
    Player player = new Player();

    //The Game
    public void play(){
        System.out.print("Welcome to WAKE ME UP!\n" );
        System.out.println("""
                An evil hypnotist has put you in a hypnosis!
                You can't wake up unless you solve the problems in his fantasy land 'Disturbia'
                Write directions to move around on the map (ex. north, n og go north)
                You can write 'look' to get more details about the place you are at
                And if you need help, simply write 'help' to get a hint to solve the problem""");
        player.getStarterRoom();
        System.out.println("\nCurrently you are at " + player.playerRoom.roomName + ". Write a direction:");

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            //Eventually put different criteria for scenarios
            discovery();
            //Start of the normal input menu
            String input = scanner.nextLine(); //user writes command
            String command;
            String commandInput = "";
            if(input.contains(" ")) {
                command = input.substring(0, input.indexOf(" "));
                commandInput = input.substring(input.indexOf(" ") + 1);
            }
            else{
                command=scanCommand(input);
            }
            switch (command) { //Stole this from Peter
                case "go":
                    if(scanCommand(input).equals(command)){
                        go(input);
                        break;
                    }
                    go(commandInput);
                    break;
                case "look":
                    look();
                    break;
                case "inventory":
                    getInventory();
                    break;
                case "take":
                    take(commandInput);
                    break;
                case "drop":
                    drop(commandInput);
                    break;
                case "help":
                    help();
                    break;
                case "exit":
                    System.out.println("Goodbye");
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command: " + command);
            }
        }
    }

    //Scenarios
    public void discovery(){
        if(player.getDiscoveryEnd()==1){
            System.out.println("You have discovered all rooms!");
            player.discoveryEnd=2;
        }
    }

    //User Actions
    public void move(String input) {
        switch (input) {
            case "north":
                if (player.playerRoom.north != null) {
                    player.playerRoom = player.playerRoom.north;
                    System.out.println("You traveled to " + player.playerRoom.roomName);
                } else {
                    System.out.println("You cannot go that way");
                }
                break;
            case "east":
                if (player.playerRoom.east != null) {
                    player.playerRoom = player.playerRoom.east;
                    System.out.println("You traveled to " + player.playerRoom.roomName);
                } else {
                    System.out.println("You cannot go that way");
                }
                break;
            case "south":
                if (player.playerRoom.south != null) {
                    player.playerRoom = player.playerRoom.south;
                    System.out.println("You traveled to " + player.playerRoom.roomName);
                } else {
                    System.out.println("You cannot go that way");
                }
                break;
            case "west":
                if (player.playerRoom.west != null) {
                    player.playerRoom = player.playerRoom.west;
                    System.out.println("You traveled to " + player.playerRoom.roomName);
                } else {
                    System.out.println("You cannot go that way");
                }
                break;
            default:
                System.out.println(input + "is not a valid direction");
                break;
        }
    }
    public void go(String input) {
        move(scanDirection(input));
    }
    public void take(String input) {
        Items tempItem = player.playerRoom.findItem(input);
        if(tempItem!=null){
            if(player.itemWeightLimit(tempItem)) {
                player.takeItem(tempItem);
                System.out.println("You pick up " + tempItem.name);
            }
            else{
                System.out.println("Picking this up will exceed the weigth limit");
            }
        }
        else {
            System.out.println("This room does not contain " + input);
        }
    }
    public void drop(String input){
        Items tempItem = player.findItem(input);
        if(tempItem!=null){
            player.dropItem(tempItem);
            System.out.println("You drop " + tempItem.name);
        }
        else {
            System.out.println("You do not have " + input);
        }


    }

    //User Information
    public void getInventory(){
        if(player.inventory.size() == 0){
            System.out.println("Your inventory is empty");
        } else {
            System.out.println("Items in inventory:" +
                    player.getInventory());
        }
    }
    public void look(){
        System.out.println(player.name + " looks around");
        player.setDiscovery();
        System.out.println(player.playerRoom.roomDescription);
        System.out.println(roomItems());
    }
    public void help(){
        System.out.println("Asking for help");
    }

    //Information to String
    public String roomItems(){
        if(player.playerRoom.items.size()==0){
            return "\nThe room is empty of items.";
        }
        return "\nItems:" + player.playerRoom.getItems();
    }

    //Scanners
    public String scanDirection(String userInput) {
        if ((userInput.equalsIgnoreCase("North")) || (userInput.equalsIgnoreCase("N"))) {
            return "north";
        }
        else if ((userInput.equalsIgnoreCase("East")) || (userInput.equalsIgnoreCase("E"))) {
            return "east";
        }
        else if ((userInput.equalsIgnoreCase("South")) || (userInput.equalsIgnoreCase("S"))) {
            return "south";
        }
        else if ((userInput.equalsIgnoreCase("West")) || (userInput.equalsIgnoreCase("W"))) {
            return "west";
        }
        else return "invalid direction";
    }
    public String scanCommand(String userInput) {
        if ((userInput.equalsIgnoreCase("North")) || (userInput.equalsIgnoreCase("N"))) {
            return "go";
        }
        else if ((userInput.equalsIgnoreCase("East")) || (userInput.equalsIgnoreCase("E"))) {
            return "go";
        }
        else if ((userInput.equalsIgnoreCase("South")) || (userInput.equalsIgnoreCase("S"))) {
            return "go";
        }
        else if ((userInput.equalsIgnoreCase("West")) || (userInput.equalsIgnoreCase("W"))) {
            return "go";
        }
        else if ((userInput.equalsIgnoreCase("Inv")) || (userInput.equalsIgnoreCase("I"))){
            return "inventory";
        }
        else if ((userInput.equalsIgnoreCase("Take"))){
            return "take";
        }
        else if ((userInput.equalsIgnoreCase("drop"))){
            return "drop";
        }
        else if (userInput.equalsIgnoreCase("Look")) {
            return "look";
        }
        else if (userInput.equalsIgnoreCase("Help")) {
            return "help";
        }
        else if(userInput.equalsIgnoreCase("Restart")){
            return "restart";
        }
        else if (userInput.equalsIgnoreCase("Exit")) {
            return "exit";
        }
        else{return userInput;}
    }

    //Colors for String
    String resetColour = "\u001B[0m";
    String black = "\u001B[30m";
    String red = "\u001B[31m";
    String green = "\u001B[32m";
    String yellow = "\u001B[33m";
    String blue = "\u001B[34m";
    String purple = "\u001B[35m";
    String cyan = "\u001B[36m";
    String white = "\u001B[37m";

    //main
    public static void main(String[] args) {
        Adventure newAdventure = new Adventure();
        newAdventure.play();
    }


}
