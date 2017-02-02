package cms;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
	//public static String hostName = "127.0.0.1";
	public static int portNumber = 4444;
	 
	public void noodMelding_Documenteren(){	
		
	}
	
	public void camera_Aanzetten(){
		
	}
	
	@SuppressWarnings("resource")
	public static void socket_Listener() throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
		ServerSocket server_socket = null;
		Socket bericht_socket = null;
		server_socket = new ServerSocket(portNumber);
		System.out.println("waiting for connection");

		while(true){
			bericht_socket = server_socket.accept();
			 ServerThreads thread = new ServerThreads(bericht_socket);
	            thread.start(); 
			/*ObjectInputStream ois = new ObjectInputStream(bericht_socket.getInputStream());	
			ObjectOutputStream oos = new ObjectOutputStream(bericht_socket.getOutputStream());
            String message = (String) ois.readObject();
            System.out.println("Message Received: " + message);
	      
            oos.writeObject("Hi Client "+message);	
            ois.close();
            oos.close();*/
		} 
		
	
	}
				
	
	public static void main (String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
		socket_Listener();
	}


}
