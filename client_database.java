import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class client_database
{
  public static void main( String args[] )
  {
	
  }
  void not_exist()
  {
	new_table_client nt = new new_table_client();
	nt.create();
	insert_table_client it = new insert_table_client();
	it.insrt_user("veeraj", "vee91raj", "draigoon", "192.168.0.10");
  }
}

class new_table_client{
	public void create(){
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      //System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "CREATE TABLE host " +
	                   "(hostname   TEXT    NOT NULL, ip TEXT    NOT NULL, username TEXT NOT NULL, password TEXT NOT NULL)"; 
	      stmt.executeUpdate(sql);
	      System.out.println("Creation Successful");
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      //System.exit(0);
	    }
		
	}
	public void drop(){
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      //System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "DELETE from host;";
	      stmt.executeUpdate(sql);
	      c.commit();
	      System.out.println("Deletion Successful");
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      //System.exit(0);
	    }
		
	}

	
}

class insert_table_client{
	public void insrt_user(String username, String password, String host_name , String ip){
	Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");
      stmt = c.createStatement();
      String sql = "INSERT INTO host (hostname, ip, username, password) " +
                   "VALUES ('"+host_name+"', '"+ip+"', '"+ username +"', '"+ password +"');"; 
      stmt.executeUpdate(sql);
      stmt.close();
      c.commit();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    System.out.println("Records created successfully");
  }
}

class select1{
	
//Retrieve Host
public String host(){
	Connection c = null;
    Statement stmt = null;
    String id;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);
      //System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT hostname FROM host;" );
      //while ( rs.next() ) {
      id = rs.getString("hostname");
      //System.out.println( "ID = " + id );
      //}
      rs.close();
      stmt.close();
      c.close();
      return id;
    }
    catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    //System.out.println("Operation done successfully");
    return "nil";
}

//Retrieve IP
public String ip(){
	Connection c = null;
    Statement stmt = null;
    String id;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);
      //System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT ip FROM host;" );
      //while ( rs.next() ) {
      id = rs.getString("ip");
      //System.out.println( "ID = " + id );
      //}
      rs.close();
      stmt.close();
      c.close();
      return id;
    }
    catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    //System.out.println("Operation done successfully");
    return "nil";
}

//Retrieve username
public String username(){
	Connection c = null;
    Statement stmt = null;
    String id;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);
      //System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT username FROM host;" );
      //while ( rs.next() ) {
      id = rs.getString("username");
      //System.out.println( "ID = " + id );
      //}
      rs.close();
      stmt.close();
      c.close();
      return id;
    }
    catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    //System.out.println("Operation done successfully");
    return "nil";
}

//Retrieve password
public String password(){
	Connection c = null;
    Statement stmt = null;
    String id;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);
      //System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT password FROM host;" );
      //while ( rs.next() ) {
      id = rs.getString("password");
      //System.out.println( "ID = " + id );
      //}
      rs.close();
      stmt.close();
      c.close();
      return id;
    }
    catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      //System.exit(0);
    }
    //System.out.println("Operation done successfully");
    return "nil";
}
}

class replace {
	//Change host
	public void hostname(String host){
		Connection c = null;
	    Statement stmt = null;
	    //String id;
	    try {
	        Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:test.db");
	        c.setAutoCommit(false);
	        System.out.println("Opened database successfully");
	        stmt = c.createStatement();
	               
	        select1 a = new select1();
	        String sql = "UPDATE host SET hostname = '" + host + "' WHERE hostname = '" + a.host() + "';";
	        stmt.executeUpdate(sql);
	        stmt.close();
	        c.commit();
	        c.close();
	      } catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        //System.exit(0);
	      }
	      System.out.println("Host changed successfully");
	}
	
	//Change ip
	public void ipaddress(String ip){
		Connection c = null;
	    Statement stmt = null;
	    //String id;
	    try {
	        Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:test.db");
	        c.setAutoCommit(false);
	        System.out.println("Opened database successfully");
	        stmt = c.createStatement();
	        //String sql = "INSERT INTO host (hostname) " +
	        //             "VALUES ('"+host+"');";
	        
	        select1 a = new select1();
	        String sql = "UPDATE host SET ip = '" + ip + "' WHERE ip = '" + a.ip() + "';";
	        stmt.executeUpdate(sql);
	        stmt.close();
	        c.commit();
	        c.close();
	      } catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        //System.exit(0);
	      }
	      System.out.println("ip changed successfully");
	}
	
	//Change Username
	public void username(String user){
		Connection c = null;
	    Statement stmt = null;
	    //String id;
	    try {
	        Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:test.db");
	        c.setAutoCommit(false);
	        System.out.println("Opened database successfully");
	        stmt = c.createStatement();
	        //String sql = "INSERT INTO host (hostname) " +
	        //             "VALUES ('"+host+"');";
	        
	        select1 a = new select1();
	        String sql = "UPDATE host SET username = '" + user + "' WHERE username = '" + a.username() + "';";
	        stmt.executeUpdate(sql);
	        stmt.close();
	        c.commit();
	        c.close();
	      } catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        //System.exit(0);
	      }
	      System.out.println("username changed successfully");
	}
	
	
	//Change Password
	public void password(String pass){
		Connection c = null;
	    Statement stmt = null;
	    //String id;
	    try {
	        Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:test.db");
	        c.setAutoCommit(false);
	        System.out.println("Opened database successfully");
	        stmt = c.createStatement();
	        //String sql = "INSERT INTO host (hostname) " +
	        //             "VALUES ('"+host+"');";
	        
	        select1 a = new select1();
	        String sql = "UPDATE host SET password = '" + pass + "' WHERE password = '" + a.password() + "';";
	        stmt.executeUpdate(sql);
	        stmt.close();
	        c.commit();
	        c.close();
	      } catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        //System.exit(0);
	      }
	      System.out.println("password changed successfully");
	}
}