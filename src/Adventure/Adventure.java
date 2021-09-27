package Adventure;

public class Adventure {

    public static void main(String[] args) {
        Parser parser = new Parser();

        System.out.println("Write Directon:");
        while(true){
            parser.userCommand(); //Registers user input
        }

    }
}
