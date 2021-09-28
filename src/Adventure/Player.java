package Adventure;

import java.util.ArrayList;

public class Player {
    Map map = new Map();
    String name;
    Room playerRoom;
    ArrayList<Items> inventory = new ArrayList();

    public Player(){
        this.name="You";
    }
    public Player(String name){
        this.name=name;
    }

    public void takeItem(Items item){
        for(int i=0; i<playerRoom.items.size(); i++){
            if(item==playerRoom.items.get(i)){
                inventory.add(item);
                playerRoom.removeItems(item);
            }
        }
    }
    public void dropItem(Items item){
        for(int i=0; i<inventory.size(); i++){
            if(item==inventory.get(i)){
                inventory.remove(item);
                playerRoom.addItems(item);
            }
        }
    }
    public String getInventory(){
        int itemAmount = inventory.size();
        String result = "Items in inventory: ";
        for(int i=0; i<itemAmount; i++){
            result += "\n" + inventory.get(i).name;
        }
        return result;
    }
    public void getStarterRoom(){
        playerRoom=map.room1;
        map.createMap();
        map.putItems();
    }
    public int getDiscoveryEnd() {
        return discoveryEnd;
    } //Equals 1 if all rooms has been discovered
    public void setDiscovery() {
        if(discoveryEnd==1){
            return;
        }

        for (int i = 0; i < discoveredRooms.length; i++) {
            if (discoveredRooms[i] == playerRoom) {
                return;
            }
        }
        for (int i = 0; i < discoveredRooms.length; i++){
            if (discoveredRooms[i]==null){
                discoveredRooms[i]=playerRoom;
                discovery++;
                i=1000;
            }
        }
        if(discovery==9){
            discoveryEnd++;
        }
    } //How many rooms has been discovered
    public Room getPlayerRoom() {
        return getPlayerRoom();

    }
    public void setPlayerRoom(Room nextRoom) {
        this.playerRoom=nextRoom;
    }

    //Discovered Rooms
    Room[] discoveredRooms = new Room[9]; //Number of different rooms
    int discovery;
    int discoveryEnd;

}
