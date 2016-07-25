import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.prefs.Preferences;

public class chat
  implements Runnable
{
  static BufferedReader ins = null;
  static PrintStream ios = null;
  static boolean stop = false;
  private static Scanner scn = new Scanner(System.in);
  
  public chat(Socket _sock)
  {
    try
    {
      ins = new BufferedReader(new InputStreamReader(_sock.getInputStream()));
      ios = new PrintStream(_sock.getOutputStream());
    }
    catch (IOException ex)
    {
      System.out.println("[EXCEPTION]: " + ex.getMessage());
      try
      {
        stop();
      }
      catch (Exception e)
      {
        System.out.println("3-");e.getMessage();
      }
    }
  }
  
  public void run()
  {
    try
    {
      String line = null;
      while (!stop)
      {
        line = scn.nextLine();
        System.out.println();
        if (line.compareToIgnoreCase("#end") == 0) {
          break;
        }
        if (line.compareToIgnoreCase("#p") == 0) {
          try
          {
            ios.println("#p");
            
            Calendar cal = new GregorianCalendar();
            int timme = cal.get(11);
            int minut = cal.get(12);
            int sekund = cal.get(13);
            int milis = cal.get(14);
            System.out.println("[SENT     | " + timme + ":" + minut + ":" + sekund + ":" + milis + "]: " + line.toLowerCase());
            
            Thread.sleep(Integer.parseInt(client.pref.get("SEND_DELAY(MS)", "")));
            vlc.PauseAndPlay();
          }
          catch (Exception e)
          {
            System.out.println("____chat.java____line_56____");
            e.printStackTrace();
            System.out.println("____________________________");
          }
        }
      }
      if (line.compareToIgnoreCase("#end") == 0)
      {
        try
        {
          ios.println("#end");
          
          Calendar cal = new GregorianCalendar();
          int timme = cal.get(11);
          int minut = cal.get(12);
          int sekund = cal.get(13);
          int milis = cal.get(14);
          
          System.out.println("[SENT     | " + timme + ":" + minut + ":" + sekund + ":" + milis + "]: " + line.toLowerCase());
        }
        catch (Exception e)
        {
          line = "";
          System.out.println("_____client.java___line_117_____");
          e.printStackTrace();
          System.out.println("_____________________________");
        }
        client.alive.interrupt();
        System.out.println("\nYou have sent an #end to terminate this session.\nPlease press [Enter] to close the program...");
        new Scanner(System.in).nextLine();
        stop();
        return;
      }
      return;
    }
    catch (Exception ex)
    {
      try
      {
        System.out.println("*1*" + ex.getMessage());
        stop();
      }
      catch (Exception exx)
      {
        stop();
        System.out.println("2-" + exx.getMessage());
      }
    }
  }
  
  public static void stop()
  {
    stop = true;
    try
    {
      ins.close();
      ios.close();
      Thread.currentThread().interrupt();
    }
    catch (IOException io)
    {
      System.out.println("9_: " + io.getMessage());
    }
  }
  
  public static void sendReady()
  {
    ios.println("rdy");
  }
  
  public static void sendKeepAlive()
  {
    ios.println("KeepAlive");
  }
}
