//import java.io.IOException;
//import java.io.BufferedReader;
//import java.io.Console;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JDialog;


class OSValidator {
 
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	public String OS() {
 
		//System.out.println(OS);
 
		if (isWindows()) {
			//System.out.println("This is Windows");
			return("windows");
		} else if (isMac()) {
			//System.out.println("This is Mac");
			return("mac");
		} else if (isUnix()) {
			//System.out.println("This is Unix or Linux");
			return("unix");
		} else if (isSolaris()) {
			//System.out.println("This is Solaris");
			return("solaris");
		} else {
			System.out.println("Your OS is not support!!");
			return("none");
		}
	}
 
	public static boolean isWindows() {
 
		return (OS.indexOf("win") >= 0);
 
	}
 
	public static boolean isMac() {
 
		return (OS.indexOf("mac") >= 0);
 
	}
 
	public static boolean isUnix() {
 
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
 
	}
 
	public static boolean isSolaris() {
 
		return (OS.indexOf("sunos") >= 0);
 
	}
 
}


public class client{
	client(){
	}
	public void cli_start(String program_name){
		select1 db = new select1();
		String username = db.username();
		String hostname = db.ip();
		String password = db.password();
		OSValidator os = new OSValidator();
		send tts = new send();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String now = dateFormat.format(cal.getTime()) ;
		
		if (os.OS() == "unix"){
			if (tts.chckconnect()){
				cli_lin(program_name,username,hostname,password);
				if (tts.app(username, program_name, now)) {
					System.out.println("Sent to server!");};
			}
			else{
				try {
					error dialog = new error("No connection! Try again later or chcek Host IP");
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);				
				} catch (Exception es) {
					es.printStackTrace();
				}
			}
		}
		
		if (os.OS() == "windows"){
			if (tts.chckconnect()){
				cli_win(program_name,username,hostname,password);
				if (tts.app(username, program_name, now)) {
					System.out.println("Sent to server!");};
			}
		}
			
		if (os.OS() == "solaris"){cli_sol(program_name);}
		
		if (os.OS() == "mac"){cli_mac(program_name);}
		
		if(os.OS() == "none"){
			System.out.println("Aborting");
			System.exit(0);
		}
		
	}
	static void cli_win(String program, String username, String hostname, String password){
		try{
			String dir = System.getProperty("user.dir");
			//System.out.println(dir);
			Runtime.getRuntime().exec(dir + "\\xming :0 -clipboard -multiwindow");
			Runtime.getRuntime().exec("cmd /c echo y | " +  dir + "\\plink -pw "+ password +" -X " + username + "@"+hostname+" "+ program);
			//Console console = System.console();
			//String input = console.readLine("Enter input:");
		}
		catch(Exception e){}
	}
	static void cli_lin(String program, String username, String hostname, String password ){
		//Process p;
		try{
			 //p = 
			Runtime.getRuntime().exec("sshpass -p " + password + " ssh -X  -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no " + username + "@" + hostname + " " + program);
	         //p.waitFor();
	         System.out.println ("Running: "+ program );//+ p.exitValue()
	         //p.destroy();
		}
		catch(Exception e){}
		
	}
	static void cli_mac(String program){
		
	}
	static void cli_sol(String program){
		
	}
}
