import java.io.*;
import java.net.*;

public class dailyadviceserver 
{
	String[] adviceList = {"Take smaller bites", "Go for the tight jeans. No they do NOT make you look fat.", "One word: inappropriate", "Just for today, be honest. Tell yourboss what you *really* think", "You might want to rethink that haircut."};
	public void go()
	{
		try
		{
			ServerSocket sSock=new ServerSocket(8080);
			while(true)
			{
				Socket sock=sSock.accept();
				PrintWriter wrtr=new PrintWriter(sock.getOutputStream());
				String advice=getAdvice();
				wrtr.println(advice);
				wrtr.close();System.out.println(advice);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
	}//go
	public String getAdvice()
	{
		int random=(int)(Math.random()* adviceList.length);
		return adviceList[random];
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		dailyadviceserver sr=new dailyadviceserver();
		sr.go();
	}
}