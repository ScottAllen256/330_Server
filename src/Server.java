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

                        if(dos.available() > 0){
                            parseMessage(dos, u);
                        }
                    }
                    catch(IOException e){

                    }

                }
            }
        }

        private void parseMessage(DataInputStream in, User u) throws IOException{
            char[] protocol_formed_charArray = DataInput_to_charArray(in);

            char cmd = protocol_formed_charArray[0];

            switch(cmd){
                case 'a' : //TODO
                    break;
                case 'b' : //TODO
                    break;
                case 'c' : //TODO
                    break;
                case 'd' : //TODO
                    break;
                case 'e' : //TODO
                    break;
                case 'f' : //TODO
                    break;
                case 'g' : //TODO
                    break;
                case 'h' : //TODO
                    break;
                case 'l' : //TODO
                    break;
                case 'n' : //TODO
                    break;
                case 'r' : roomMessage(protocol_formed_charArray,u);
                    break;
                case 's' : //TODO
                    break;
                case 'w' : //TODO
                    break;
                default  : //TODO
                    break;
            }
        }

        /**
        *   Creates a char[] from the DataInputStream
         *   returns a char[]
         */
        public char[] DataInput_to_charArray(DataInputStream in){
            char[] buff = new char[2000];
            int counter =0;

            try {
                while (in.available() > 0) {
                    buff[counter] = in.readChar();
                    counter ++;
                }
            }
            catch(IOException e){
                return null;
            }

            char[] protocol_format_chararray = new char[counter];

            for(int i = 0; i< counter; i++){
                protocol_format_chararray[i] = buff[i];
            }


            //Use this to see if the protocol is being received correctly.
//            for(char c : protocol_format_chararray){
//                if(c != '\0'){
//                    System.out.print(c);
//                }
//                else
//                    System.out.print('~');
//            }

            return protocol_format_chararray;

        }

        public void roomMessage(char[] protocol, User u){

        }
    }

}





