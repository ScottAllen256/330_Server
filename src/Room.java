/**
 * Created by Collin Nolen on 3/15/2017.
 */
public class Room {

    protected String room_name;
    protected int room_number; //might not be needed
    protected int room_capacity;
    protected int clients_in_room;
    protected User[] users_in_room;

    public Room(String name, int number, int capacity){
        room_name = name;
        room_number = number;
        room_capacity = capacity;
        clients_in_room = 0;
        users_in_room = new User[capacity];
    }
}
