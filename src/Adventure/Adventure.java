package Adventure;

import java.util.Scanner;

public class Adventure {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map map = new Map();
        Game game = new Game();
        map.createMap();
        game.getStarterRoom(map.room1);

        System.out.println("Write Directon:");
        while(true){
            String input = sc.nextLine();
            game.userInput(input);
        }

    }
}
