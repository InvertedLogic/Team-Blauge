package testCom;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	static ComProtocol protocol;

	public static void main( String[] args )
	  {
	    Socket server = null;
	    protocol = new ComProtocol();

	    try
	    {
	      server = new Socket( "localhost", 3141 );
	      InputStream     in  =  server.getInputStream() ;
	      BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	      StringBuilder builder = new StringBuilder();
	      String s = protocol.reqChangeAttrByID(1, "name", "tom", 100);
	      
	      PrintWriter out = new PrintWriter( server.getOutputStream(), true );
	      out.println(s);
	      String line;
	      while((line=reader.readLine())!=null) {
	    	  builder.append(line);
	      }
	      System.out.println(builder.toString());
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
