import java.sql.*;

public class server_database
{
  public static void main( String args[] )
  {
	new_table nt = new new_table();
	nt.create();
  }
}

class new_table{
	public void create(){
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "CREATE TABLE user " +
	                   "(id INT PRIMARY KEY     NOT NULL," +
	                   " username      TEXT    NOT NULL, " + 
	                   " password      CHAR(15)     NOT NULL)"; 
	      stmt.executeUpdate(sql);
	      System.out.println("Creation Successful");
	      stmt.close();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      String sql = "CREATE TABLE app " +
		                   "(id INT NOT NULL," +
		                   " appname      TEXT    NOT NULL, " + 
		                   " time     text      NOT NULL)"; 
		      stmt.executeUpdate(sql);
		      System.out.println("Creation Successful");
		      stmt.close();
		      c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
	
}

class insert_table{
	public void insrt_user(String username , String password){
	Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");
      select a = new select();
      int id  = a.last_id() + 1;
      if (!a.username(username)){
      stmt = c.createStatement();
      String sql = "INSERT INTO user (id, username, password) " +
                   "VALUES ("+id+","+"'"+username+"'"+"," + "'" + password + "'" + ");"; 
      stmt.executeUpdate(sql);
      stmt.close();
      c.commit();
      }
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Records created successfully");
  }
	//Insert username, appname and datetime
	public void insrt_app(String username , String app, String date){
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");
	      //select a = new select();
	      //int id  = a.last_id() + 1;
	      stmt = c.createStatement();
	      select tmp = new select();
	      String sql = "INSERT INTO app (id, appname, time) " +
	                   "VALUES ("+tmp.userid(username)+","+"'"+app+"'"+", '" + date + "');"; 
	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.commit();
	      c.close();
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Records created successfully");
	  }
}

class select{
	//Retrieve last id	
	public int last_id(){
		Connection c = null;
	    Statement stmt = null;
	    int id;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      c.setAutoCommit(false);
	      //System.out.println("Opened database successfully");
	
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT MAX(id) FROM user;" );
	      //while ( rs.next() ) {
	      id = rs.getInt("MAX(id)");
	      //System.out.println( "ID = " + id );
	      //}
	      rs.close();
	      stmt.close();
	      c.close();
	      return id;
	    }
	    catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      return 0;
	    }
	    //System.out.println("Operation done successfully");
	}
	
	//Retrive username based on id
	public String username(int id){
		Connection c = null;
	    Statement stmt = null;
	    String user;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      c.setAutoCommit(false);
	      //System.out.println("Opened database successfully");
	
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT username FROM user WHERE id ="+ id +";" );
	      //while ( rs.next() ) {
	      user = rs.getString("username");
	      //System.out.println( "ID = " + id );
	      //}
	      rs.close();
	      stmt.close();
	      c.close();
	      return user;
	    }
	    catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    //System.out.println("Operation done successfully");
	    return "nil";
	}
	//Select username based on username
	public Boolean username(String id){
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      c.setAutoCommit(false);
	      //System.out.println("Opened database successfully");
	
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT username FROM user WHERE username ="+ id +";" );
	      //while ( rs.next() ) {
	      String user = rs.getString("username");
	      System.out.println("Username" + user + " Exist");
	      //System.out.println( "ID = " + id );
	      //}
	      rs.close();
	      stmt.close();
	      c.close();
	      return true;
	    }
	    catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      return false;
	    }
	    //System.out.println("Operation done successfully");
	    //return "nil";
	}
	//Retrieve id from username
	public int userid(String username){
		Connection c = null;
	    Statement stmt = null;
	    int user;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      c.setAutoCommit(false);
	      //System.out.println("Opened database successfully");
	
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT id FROM user WHERE username ='"+ username +"';" );
	      //while ( rs.next() ) {
	      user = rs.getInt("id");
	      //System.out.println( "ID = " + id );
	      //}
	      rs.close();
	      stmt.close();
	      c.close();
	      return user;
	    }
	    catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    //System.out.println("Operation done successfully");
	    return 0;
	}
	//Retrieve password based on id
	public String password(int id){
		Connection c = null;
	    Statement stmt = null;
	    String user;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      c.setAutoCommit(false);
	      //System.out.println("Opened database successfully");
	
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT password FROM user WHERE id ="+ id +";" );
	      //while ( rs.next() ) {
	      user = rs.getString("password");
	      //System.out.println( "ID = " + id );
	      //}
	      rs.close();
	      stmt.close();
	      c.close();
	      return user;
	    }
	    catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    //System.out.println("Operation done successfully");
	    return "nil";
	}
	
	//Select password from user based on username
	public String passworduser(String id){//put username in arg
		Connection c = null;
	    Statement stmt = null;
	    String user;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	      c.setAutoCommit(false);
	      //System.out.println("Opened database successfully");
	
	      stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT password FROM user WHERE username='"+id+"';" );
	      //while ( rs.next() ) {
	      user = rs.getString("password");
	      //System.out.println( "ID = " + id );
	      //}
	      rs.close();
	      stmt.close();
	      c.close();
	      return user;
	    }
	    catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    //System.out.println("Operation done successfully");
	    return "nil";
}

	public void showentry(){
			Connection c = null;
		    Statement stmt = null;
		    try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:test.db");
		      c.setAutoCommit(false);
		      //System.out.println("Opened database successfully");
		      String username;
		      stmt = c.createStatement();
		      System.out.println("Users Registered!");
		      ResultSet rs = stmt.executeQuery( "SELECT username FROM user;" );
		      //while ( rs.next() ) {
		      username = rs.getString("username");
		      System.out.println( "Username = " + username + "\n" );
		      //}
		      rs.close();
		      stmt.close();
		      int id;
		      String app_name, time;
		      stmt = c.createStatement();
		      System.out.println("Users App Entries!");
		      ResultSet as = stmt.executeQuery( "SELECT id, appname, time FROM app ORDER BY id;" );
		      while ( as.next() ) {
		      id = as.getInt("id");
		      username = username(id);
		      app_name = as.getString("appname");
		      time = as.getString("time");
		      System.out.println( "  " + username + "\t" + app_name + "\t" + time);
		      System.out.println("-------------------------------------------------");
		      }
		      as.close();
		      stmt.close();
		      c.close();
		    }
		    catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    }
		    //System.out.println("Operation done successfully");
	}
}

class change{
	//Password change based on username
	public void pass(String username, String pswd){
		Connection c = null;
	    Statement stmt = null;
	    //String user;
	    try {
	    	Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:test.db");
	        c.setAutoCommit(false);
	        System.out.println("Opened database successfully");
	        stmt = c.createStatement();
	        //String sql = "INSERT INTO host (hostname) " +
	        //             "VALUES ('"+host+"');";
	        
	        String sql = "UPDATE user SET password = '" + pswd + "' WHERE username = '" + username + "';";
	        stmt.executeUpdate(sql);
	        stmt.close();
	        c.commit();
	        c.close();      
	    }
	    catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    //System.out.println("Operation done successfully");
	   	
	}
	
}