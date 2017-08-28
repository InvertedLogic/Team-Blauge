package testCom;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static int clientcounter = 0;
	
	private static void handleConnection( Socket client ) throws IOException
	  {
		clientcounter++;
	    Scanner in  = new Scanner( client.getInputStream() );
	    PrintWriter out = new PrintWriter( client.getOutputStream(), true );

	    String string1 = in.nextLine();
	    String output = "Fail";
	    if(string1.contains("functionA")) {
	    	String str1 = string1.split("\\(")[1];
	    	String str2 = str1.split("\\)")[0];
	    	
	    	int param1 = Integer.parseInt(str2.split(",")[0]);
	    	int param2 = Integer.parseInt(str2.split(",")[1]);
	    	
	    	output = Integer.toString(functionA(param1,param2));
	    }
	    if(string1.contains("functionB")) {
	    	String str1 = string1.split("\\(")[1];
	    	String str2 = str1.split("\\)")[0];
	    	
	    	int param1 = Integer.parseInt(str2.split(",")[0]);
	    	int param2 = Integer.parseInt(str2.split(",")[1]);
	    	
	    	output = Integer.toString(functionB(param1,param2));
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
