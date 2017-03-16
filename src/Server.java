/**
 * Created by collin on 3/14/2017.
 */
import sun.misc.IOUtils;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Server {
    // SimpleServer.java: A simple server program.
    protected static ArrayList<User> users = new ArrayList<>();

    protected static Room general;
    protected static Room roomOne;
    protected static Room roomTwo;
    protected static Room roomThree;

    public static void main(String args[]) throws IOException {

        general = new Room("general", 0, 20);
        roomOne = new Room("x", 1, 2);
        roomTwo = new Room("y", 2, 2);
        roomThree = new Room("z", 3, 2);

        Thread connections = new Thread(new connect_runnable());
        connections.start();

        Thread read_from_users = new Thread(new read_from_users());
        read_from_users.start();


    }


    private static class connect_runnable implements Runnable{
        @Override
        public void run(){
            User newUser;

            try {
                ServerSocket s = new ServerSocket(1254);

                while (true) {
                    Socket s1 = s.accept();

                    newUser = new User(s1);
                    users.add(newUser);
                    general.add_user_to_room(newUser);

                    s1=null;
                    newUser = null;
                }
            }
            catch(IOException e){

            }
        }
    }

    private static class read_from_users implements Runnable{
        @Override
        public void run(){
            InputStream s1out;


            while(true){
                for(User u : users){
                    try{
                        s1out = u.sockID.getInputStream();
                        DataInputStream dos = new DataInputStream (s1out);

                        if(dos != null){
                            parseMessage(dos);
                        }
                    }
                    catch(IOException e){

                    }

                }
            }
        }

        private void parseMessage(DataInputStream in) throws IOException{

            char cmd = in.readChar();

            switch(cmd){
                case 'a' :
                    break;
                case 'b' :
                    break;
                case 'c' :
                    break;
                case 'd' :
                    break;
                case 'e' :
                    break;
                case 'f' :
                    break;
                case 'g' :
                    break;
                case 'h' :
                    break;
                case 'l' :
                    break;
                case 'n' :
                    break;
                case 'r' :
                    break;
                case 's' :
                    break;
                case 'w' :
                    break;
                default  :
                    break;
            }
        }
    }

}





