import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;


public class dailyadviceclient {

	public void go()
	{
		try
		{
			Socket s=new Socket("127.0.0.1",8080);
			InputStreamReader readr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(readr);
			String advice=br.readLine();
			System.out.println("Today you should"+advice);
			br.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Exception"+ex.getMessage());
		}
	}
	
	public static void main(String[] args) 
	{
		dailyadviceclient cl=new dailyadviceclient();
		cl.go();
	}
}
