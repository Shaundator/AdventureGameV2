package Adventure;

import java.util.Scanner;

public class Parser {
    Map map = new Map();
    Game game = new Game();


    public Parser(){
        map.createMap();
    }
    public void userCommand(){
        Scanner sc = new Scanner(System.in);
        while(true) {
            String input = sc.nextLine();
            if ((input.equalsIgnoreCase("Go North")) || (input.equalsIgnoreCase("Go N")) || (input.equalsIgnoreCase("North")) || (input.equalsIgnoreCase("N"))) {
                game.move("North");
            } else if ((input.equalsIgnoreCase("Go East")) || (input.equalsIgnoreCase("Go E")) || (input.equalsIgnoreCase("East")) || (input.equalsIgnoreCase("E"))) {
                game.move("East");
            } else if ((input.equalsIgnoreCase("Go South")) || (input.equalsIgnoreCase("Go S")) || (input.equalsIgnoreCase("South")) || (input.equalsIgnoreCase("S"))) {
                game.move("South");
            } else if ((input.equalsIgnoreCase("Go West")) || (input.equalsIgnoreCase("Go W")) || (input.equalsIgnoreCase("West")) || (input.equalsIgnoreCase("W"))) {
                game.move("West");
            } else if (input.equalsIgnoreCase("Look")) {
                game.menu("Look");
            } else if (input.equalsIgnoreCase("Help")) {
                game.menu("Help");
            } else if (input.equalsIgnoreCase("Exit")) {
                game.menu("Exit");
            }
        }
    }
}
