package Adventure;

public class Map {
    Room room1 = new Room("the well", "It's dark and cold and you can't see a thing");
    Room room2 = new Room("the flower meadow", "There are a lot of flowers (surprise) in different colors");
    Room room3 = new Room("the cave of mischief", "The cave is mysteriously bright and everything is painted white");
    Room room4 = new Room("the castle", "The castle is gigantic and placed in deserted surroundings");
    Room room5 = new Room("the cellar", "Bars surround you and there is only one way out");
    Room room6 = new Room("the garden of sand", "Well, there is a lot of sand");
    Room room7 = new Room("the biggest mountain of all time", "You can't see anything but mountainside");
    Room room8 = new Room("the Valley of Confusion", "The valley is green and blue and filled with shadows");
    Room room9 = new Room("the river of sadness", "The stream is strong, so be careful when you cross over");

    //  1 = 2 = 3
    //  |   X   |
    //  4 X 5 X 6
    //  |   |   |
    //  7 = 8 = 9

    public Map(){
    }
    public void createMap(){
        room1.setEast(room2);
        room2.setEast(room3);
        room1.setSouth(room4);
        room3.setSouth(room6);
        room4.setSouth(room7);
        room5.setSouth(room8);
        room6.setSouth(room9);
        room7.setEast(room8);
        room8.setEast(room9);
    }



}
