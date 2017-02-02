package cms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThreads extends Thread{
    Socket myClientSocket;
	
    public ServerThreads(){
    	super();
    }
	public void run(){
		try{
			System.out.println(Thread.currentThread());
			
			ObjectInputStream ois = new ObjectInputStream(myClientSocket.getInputStream());	
			ObjectOutputStream oos = new ObjectOutputStream(myClientSocket.getOutputStream());
			String message = (String) ois.readObject();
			System.out.println("Message Received: " + message);
			
			ServerReply antwoord = new ServerReply();
			antwoord.reply(message);
			oos.writeObject((antwoord.reply(message)));	
			ois.close();
			oos.close();
			Thread.currentThread().interrupt();
		}
		catch(Exception e) { 
            e.printStackTrace(); 
        } 
	}
	
	ServerThreads(Socket s){
		myClientSocket = s;
	}
}



