package Adventure;

public class Player {
    Map map = new Map();
    String name;
    Room playerRoom;


    public Player(String name){
        this.name=name;
        playerRoom=map.room1;
        map.createMap();
    }

    public Room getPlayerRoom() {
        return getPlayerRoom();
    }
    public void setPlayerRoom(Room nextRoom) {
        this.playerRoom=nextRoom;
    }

}
