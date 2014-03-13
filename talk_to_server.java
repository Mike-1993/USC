import java.net.*;
import java.io.*;

public class talk_to_server
{
   public static void main(String [] args)
   {
	  send tmp = new send();
	  tmp.add("sneha", "123456");
	   
   }
}

class send{
	select1 temp = new select1();
    String server = temp.ip();
	//String server = "192.168.0.10";
    boolean chckconnect(){
    	try
	      {
	         int i = 6066;
	         Socket client = new Socket(server, i);
	         OutputStream outToServer = client.getOutputStream();
	         DataOutputStream out = new DataOutputStream(outToServer);
	         out.writeUTF("online");
	         out.writeUTF("0");
	         out.writeUTF("0");
	         out.writeUTF("null");
	         
	         InputStream inFromServer = client.getInputStream();
	         DataInputStream in =
	                        new DataInputStream(inFromServer);
	         String response = in.readUTF();
	         
	         switch(response){
	         case "sucess":
	        	 client.close();
	        	 return true;
	         default:
	        	 break;
	         }
	         client.close();
	         return false;
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	   }
		return false;	   
		
	}
    
	boolean check(String username, String pass){
		try
	      {
	         int i = 6066;
	         Socket client = new Socket(server, i);
	         OutputStream outToServer = client.getOutputStream();
	         DataOutputStream out = new DataOutputStream(outToServer);
	         out.writeUTF("check");
	         out.writeUTF(username);
	         out.writeUTF(pass);
	         out.writeUTF("null");
	         
	         InputStream inFromServer = client.getInputStream();
	         DataInputStream in =
	                        new DataInputStream(inFromServer);
	         String response = in.readUTF();
	         
	         switch(response){
	         case "sucess":
	        	 client.close();
	        	 return true;
	         default:
	        	 break;
	         }
	         client.close();
	         return false;
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	   }
		return false;	   
		
	}
	
	boolean add(String username, String pass){
		try
	      {
	         int i = 6066;
	         Socket client = new Socket(server, i);
	         OutputStream outToServer = client.getOutputStream();
	         DataOutputStream out = new DataOutputStream(outToServer);
	         out.writeUTF("add");
	         out.writeUTF(username);
	         out.writeUTF(pass);
	         out.writeUTF("null");
	         
	         InputStream inFromServer = client.getInputStream();
	         DataInputStream in =
	                        new DataInputStream(inFromServer);
	         String response = in.readUTF();
	         
	         switch(response){
	         case "sucess":
	        	 client.close();
	        	 return true;
	         default:
	        	 break;
	         }
	         client.close();
	         return false;
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	   }
		return false;	   
		
	}
	
	boolean chngpass(String username, String pass){
		try
	      {
	         int i = 6066;
	         Socket client = new Socket(server, i);
	         OutputStream outToServer = client.getOutputStream();
	         DataOutputStream out = new DataOutputStream(outToServer);
	         out.writeUTF("chngpass");
	         out.writeUTF(username);
	         out.writeUTF(pass);
	         out.writeUTF("null");
	         
	         InputStream inFromServer = client.getInputStream();
	         DataInputStream in =
	                        new DataInputStream(inFromServer);
	         String response = in.readUTF();
	         
	         switch(response){
	         case "sucess":
	        	 client.close();
	        	 return true;
	         default:
	        	 break;
	         }
	         client.close();
	         return false;
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	   }
		return false;	
		
	}
	
	boolean app(String username, String app, String date){
		try
	      {
	         int i = 6066;
	         Socket client = new Socket(server, i);
	         OutputStream outToServer = client.getOutputStream();
	         DataOutputStream out = new DataOutputStream(outToServer);
	         out.writeUTF("app");
	         out.writeUTF(username);
	         out.writeUTF(app);
	         out.writeUTF(date);
	         
	         InputStream inFromServer = client.getInputStream();
	         DataInputStream in = new DataInputStream(inFromServer);
	         String response = in.readUTF();
	         
	         switch(response){
	         case "sucess":
	        	 client.close();
	        	 return true;
	         default:
	        	 break;
	         }
	         client.close();
	         return false;
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	   }
		return false;	
		
	}
	
}
