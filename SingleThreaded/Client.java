
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//import org.xml.sax.SAXException;

public class Client {
    public void run() throws UnknownHostException, IOException{
        int port =8010;
        InetAddress address=InetAddress.getByName("localhost");
        Socket socket= new Socket(address,port);
        PrintWriter toSocket= new PrintWriter(socket.getOutputStream());
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toSocket.println("Hello from the client");
        String line =fromSocket.readLine();
        System.out.println("Response from the oscket is :" + line);
        toSocket.close();
        fromSocket.close();
        socket.close();

    }
    public static void main(String[] args){
        try{
            Client client= new Client();
            client.run();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
