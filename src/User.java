import java.net.Socket;

/**
 * Created by collin on 3/14/2017.
 */
public class User{
    protected Socket sockID;
    protected String userName;
    protected int room;

    public User(Socket sock){
        sockID = sock;
        userName = "Guest" + sock.toString();
        room = 0;
    }

    public void setUserName(String name){
        userName = name;
    }
}
