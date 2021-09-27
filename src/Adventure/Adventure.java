package Adventure;

public class Adventure {

    public static void main(String[] args) {
        Parser parser = new Parser();

        System.out.print("Welcome to WAKE ME UP!");
        System.out.println("\nAn evil hypnotist has put you in a hypnosis!" +
                           "\nYou can't wake up unless you solve the problems in his fantasy land 'Disturbia'" +
                           "\nWrite directions to move around on the map (ex. north, n og go north)" +
                           "\nYou can write 'look' to get more details about the place you are at" +
                           "\nAnd if you need help, simply write 'help' to get a hint to solve the problem");
        System.out.println("\nCurrently you are placed in a well. Write a direction:");
        while(true){
            parser.userCommand(); //Registers user input
        }

    }
}
