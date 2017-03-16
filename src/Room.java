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
        room_init();
    }

    public void room_init(){
        for(int i=0; i < room_capacity; i++)
            users_in_room[i]=null;
    }

    public void add_user_to_room(User u){

        if(clients_in_room > room_capacity){
            for(int i=0; i < room_capacity; i++){
                if(users_in_room[i] == null) {
                    users_in_room[i] = u;
                    clients_in_room++;
                }
            }
        }
    }

    public void remove_user_from_room(User u){

        for(int i=0; i < room_capacity; i++){
            if(users_in_room[i] != null){
                if(users_in_room[i].userName.equals(u.userName)) {
                    users_in_room[i] = null;
                }
            }
        }
    }
}
