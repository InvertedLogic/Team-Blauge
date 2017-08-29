package testCom;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	static ComProtocol protocol;
	public static int clientcounter = 0;
		
	private static void handleConnection( Socket client ) throws IOException
	  {
	    InputStream in  = client.getInputStream();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	    StringBuilder builder = new StringBuilder();
	    PrintWriter out = new PrintWriter( client.getOutputStream(), true );

	    String string1 = reader.readLine();
	    String output = "Fail";
	    
	    protocol = new ComProtocol();
	    
	    if(string1.contains("changeAttrByID")) {
	    	Request req = protocol.valChangeAttrByID(string1);
		    output = "ID: "+req.id+"\tAttr: "+req.attr+"\tValue: "+req.value+"\tTimestamp: "+req.timeStamp;
	    }
	    out.println(output);
	  }

	  public static void main( String[] args ) throws IOException
	  {
	    ServerSocket server = new ServerSocket( 3141 );
	    while ( true )
	    {
	      Socket client = null;

	      try
	      {
	        client = server.accept();
	        handleConnection ( client );
	        clientcounter++;
	        System.out.println(clientcounter);
	      }
	      catch ( IOException e ) {
	        e.printStackTrace();
	      }
	      finally {
	        if ( client != null )
	          try { client.close(); } catch ( IOException e ) { }
	      }
	    }
	  }
	  
	  public static int functionA(int a, int b) {
		  return (a*b);
	  }
	  
	  public static int functionB(int a, int b) {
		  return (a*b*a*b);
	  }
}
