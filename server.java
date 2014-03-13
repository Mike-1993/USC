
import java.net.*;
import java.io.*;

public class server extends Thread
{
   private ServerSocket serverSocket;
   
   public server(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
      //serverSocket.setSoTimeout(10000);
   }

   public void run()
   {
      while(true)
      {
         try
         {
            //System.out.println("Waiting for client on port " +
            //serverSocket.getLocalPort() + "...");
            Socket server = serverSocket.accept();
            //System.out.println("Just connected to "
            //      + server.getRemoteSocketAddress());
            DataInputStream in = new DataInputStream(server.getInputStream());
            
            String cmd = in.readUTF();
            String arg1 = in.readUTF();
            String arg2 =  in.readUTF();
            String arg3 =  in.readUTF();
            
            select tmp = new select();
            insert_table tmp1 = new insert_table();
            change tmp2 = new change();
            insert_table tmp3 = new insert_table();
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            
            switch (cmd.toLowerCase()) {
            case "check":
            	if (arg2.equals(tmp.passworduser(arg1))){
            		out.writeUTF("sucess");
            	}
            	break;
            	
            case "add":
            	tmp1.insrt_user(arg1, arg2);
            	out.writeUTF("sucess");
            	break;
            	
            case "chngpass":
            	tmp2.pass(arg1, arg2);
            	out.writeUTF("sucess");
            	break;
            	
            case "app":
            	tmp3.insrt_app(arg1, arg2, arg3);
            	out.writeUTF("sucess");
            	break;
            	
            case "online":
            	out.writeUTF("sucess");
            	break;
            	
            default: 
                System.out.println("Something went bananas! Wrong command from client");
                break;
            }
            System.out.println("Sucess!");
            
            
            
            server.close();
         }catch(SocketTimeoutException s)
         {
            System.out.println("Socket timed out!");
            break;
         }catch(IOException e)
         {
            e.printStackTrace();
            break;
         }
      }
   }
   public static void main(String [] args)
   {
      int port = Integer.parseInt(args[0]);
      if (args[1].equals("table")){
    	  select tmp = new select();
    	  tmp.showentry();
      }
      try
      {
         Thread t = new server(port);
         t.start();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}