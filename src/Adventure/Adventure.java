package Adventure;

import java.util.Scanner;

public class Adventure {
    Player player = new Player();


    public void play(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Welcome to WAKE ME UP!");
        System.out.println("\nAn evil hypnotist has put you in a hypnosis!" +
                "\nYou can't wake up unless you solve the problems in his fantasy land 'Disturbia'" +
                "\nWrite directions to move around on the map (ex. north, n og go north)" +
                "\nYou can write 'look' to get more details about the place you are at" +
                "\nAnd if you need help, simply write 'help' to get a hint to solve the problem");
        System.out.println("\nCurrently you are placed in a well. Write a direction:");
        player.getStarterRoom();

        boolean completed = true;
        while(completed){
            String userInput = sc.nextLine();
            scanCommand(userInput); //Registers user input
            discovery();
        }
        System.out.println("You won the game");
    }

    //Scenarios
    public void discovery(){
        if(player.getDiscoveryEnd()==1){
            System.out.println("You have discovered all rooms!");
            player.discoveryEnd=2;
        }
    }

    //CommandMenus
    public void commandMove(String input) {
        if (input.equals("north")) {
            if (player.playerRoom.north != null) {
                player.playerRoom = player.playerRoom.north;
                System.out.println("You traveled to " + player.playerRoom.roomName);
            } else {
                System.out.println("You cannot go that way");
            }
        }
        if (input.equals("east")) {
            if (player.playerRoom.east != null) {
                player.playerRoom = player.playerRoom.east;
                System.out.println("You traveled to " + player.playerRoom.roomName);
            } else {
                System.out.println("You cannot go that way");
            }
        }
        if (input.equals("south")) {
            if (player.playerRoom.south != null) {
                player.playerRoom = player.playerRoom.south;
                System.out.println("You traveled to " + player.playerRoom.roomName);
            } else {
                System.out.println("You cannot go that way");
            }
        }
        if (input.equals("west")) {
            if (player.playerRoom.west != null) {
                player.playerRoom = player.playerRoom.west;
                System.out.println("You traveled to " + player.playerRoom.roomName);
            } else {
                System.out.println("You cannot go that way");
            }
        }
    }
    public void commandMenu(String input) {
        Scanner menu = new Scanner(System.in);
        if (input.equals("look")) {
            System.out.println(player.name + " look around");
            player.setDiscovery();
            System.out.println(player.playerRoom.roomDescription);
            System.out.println(player.playerRoom.getItems());
        }
        if (input.equals("help")) {
            System.out.println(player.name + " ask for help");
            //System.out.println("Hints til hjælp");
        }
        if(input.equals("inventory")){
            if(player.inventory.size() == 0){
                System.out.println("Your inventory is empty");
            }else {
                System.out.println(player.getInventory());
            }
        }
        if(input.equals("take")){
            System.out.println("Which item would you like to take?");
            String take = menu.nextLine();
            Items temp = scanItems(take);
            if(temp!=null){
                player.takeItem(temp);
                System.out.println("You pick up " + temp.name);
            }
            else{System.out.println("This item does not exist in this room");
            }
        }
        if(input.equals("drop")){
            System.out.println("Which item would you like to drop?");
            String drop = menu.nextLine();
            Items temp = scanItems(drop);
            if(temp!=null){
                player.dropItem(temp);
                System.out.println("You drop " + temp.name);
            }
            else{
                System.out.println("You dont have this item");
            }
        }
        if (input.equals("restart")){
            Adventure newAdventure = new Adventure();
            newAdventure.play();
        }
        if (input.equals("exit")) {
            System.exit(0);
        }
    }
    public Items scanItems(String input){
        if(input.contains("rock")||input.contains("Rock")){
            return player.map.item1;
        }
        if(input.equalsIgnoreCase("cards")){
            return player.map.item2;
        }
        if(input.equalsIgnoreCase("gun")){
            return player.map.item3;
        }
        return null;
    }
    public void scanCommand(String userInput) {
        if ((userInput.equalsIgnoreCase("Go North")) || (userInput.equalsIgnoreCase("Go N")) || (userInput.equalsIgnoreCase("North")) || (userInput.equalsIgnoreCase("N"))) {
            commandMove("north");
        } else if ((userInput.equalsIgnoreCase("Go East")) || (userInput.equalsIgnoreCase("Go E")) || (userInput.equalsIgnoreCase("East")) || (userInput.equalsIgnoreCase("E"))) {
            commandMove("east");
        } else if ((userInput.equalsIgnoreCase("Go South")) || (userInput.equalsIgnoreCase("Go S")) || (userInput.equalsIgnoreCase("South")) || (userInput.equalsIgnoreCase("S"))) {
            commandMove("south");
        } else if ((userInput.equalsIgnoreCase("Go West")) || (userInput.equalsIgnoreCase("Go W")) || (userInput.equalsIgnoreCase("West")) || (userInput.equalsIgnoreCase("W"))) {
            commandMove("west");
        } else if ((userInput.equalsIgnoreCase("Inventory")) || (userInput.equalsIgnoreCase("Invent")) || (userInput.equalsIgnoreCase("Inv")) || (userInput.equalsIgnoreCase("I"))){
            commandMenu("inventory");
        } else if ((userInput.equalsIgnoreCase("Take"))){
            commandMenu("take");
        } else if ((userInput.equalsIgnoreCase("drop"))){
            commandMenu("drop");
        } else if (userInput.equalsIgnoreCase("Look")) {
            commandMenu("look");
        } else if (userInput.equalsIgnoreCase("Help")) {
            commandMenu("help");
        } else if(userInput.equalsIgnoreCase("Restart")){
            commandMenu("restart");
        } else if (userInput.equalsIgnoreCase("Exit")) {
            commandMenu("exit");
        } else{System.out.println("Invalid command");}
    }

    //main
    public static void main(String[] args) {
        Adventure newAdventure = new Adventure();
        newAdventure.play();
    }
}
