package testCom;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main( String[] args )
	  {
	    Socket server = null;

	    try
	    {
	      server = new Socket( "localhost", 3141 );
	      Scanner     in  = new Scanner( server.getInputStream() );
	      PrintWriter out = new PrintWriter( server.getOutputStream(), true );

	      out.println( "functionA(2,5)" );
	      System.out.println( in.nextLine() );
	      
	      server.close();

	      server = new Socket( "localhost", 3141 );
	      in  = new Scanner( server.getInputStream() );
	      out = new PrintWriter( server.getOutputStream(), true );

	      out.println( "functionB(2,5)" );
	      System.out.println( in.nextLine() );
	      
	      server.close();

	      server = new Socket( "localhost", 3141 );
	      in  = new Scanner( server.getInputStream() );
	      out = new PrintWriter( server.getOutputStream(), true );

	      out.println( "functionC(2,2)" );
	      System.out.println( in.nextLine() );
	    }
	    catch ( UnknownHostException e ) {
	      e.printStackTrace();
	    }
	    catch ( IOException e ) {
	      e.printStackTrace();
	    }
	    finally {
	      if ( server != null )
	        try { server.close(); } catch ( IOException e ) { }
	    }
	  }
}
