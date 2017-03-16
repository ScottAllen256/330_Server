/**
 * Created by collin on 3/14/2017.
 */
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Server {
    // SimpleServer.java: A simple server program.
    protected static ArrayList<User> users = new ArrayList<>();



    public static void main(String args[]) throws IOException {

        Thread connections = new Thread(new connect_runnable());
        connections.start();

        Thread read_from_users = new Thread(new read_from_users());
        read_from_users.start();


    }


    private static class connect_runnable implements Runnable{
        @Override
        public void run(){
            try {
                ServerSocket s = new ServerSocket(1254);

                while (true) {
                    Socket s1 = s.accept();
                    users.add(new User(s1));
                    s1=null;
                }
            }catch(IOException e){

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
            String line = in.readUTF();

            if(line.length()<1)
                return;

            char cmd = line.charAt(0);

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





