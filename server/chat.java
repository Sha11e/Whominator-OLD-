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
  char what;
  private static Scanner scn = new Scanner(System.in);
  
  public chat(Socket _sock, char watt)
  {
    try
    {
      this.what = watt;
      if (watt == 'i') {
        ins = new BufferedReader(new InputStreamReader(_sock.getInputStream()));
      } else {
        ios = new PrintStream(_sock.getOutputStream());
      }
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
        System.out.println("{3-]");e.getMessage();
      }
    }
  }
  
  public void run()
  {
    try
    {
      String line = null;
      String line2 = null;
      while (!stop) {
        if (this.what == 'o')
        {
          line2 = scn.nextLine();
          System.out.println();
          if (line2.compareToIgnoreCase("#end") == 0) {
            try
            {
              ios.println("#end");
              
              Calendar cal = new GregorianCalendar();
              int timme = cal.get(11);
              int minut = cal.get(12);
              int sekund = cal.get(13);
              int milis = cal.get(14);
              
              System.out.println("[SENT | " + timme + ":" + minut + ":" + sekund + ":" + milis + "]: " + line2.toLowerCase());
              
              System.out.println("You have sent an #end to terminate this session.\nPlease press [Enter] to close the program...");
              new Scanner(System.in).nextLine();
              server.alive.interrupt();
              stop();
              
              return;
            }
            catch (Exception e)
            {
              line2 = "";
              System.out.println("_____chat.java___line_77_____");
              e.printStackTrace();
              System.out.println("_____________________________");
            }
          }
          if (line2.compareToIgnoreCase("#p") == 0) {
            try
            {
              ios.println("#p");
              try
              {
                Calendar cal = new GregorianCalendar();
                int timme = cal.get(11);
                int minut = cal.get(12);
                int sekund = cal.get(13);
                int milis = cal.get(14);
                System.out.println("[SENT | " + timme + ":" + minut + ":" + sekund + ":" + milis + "]: " + line2.toLowerCase());
              }
              catch (Exception e)
              {
                line2 = "";
                System.out.println("_____chat.java___line_97_____");
                e.printStackTrace();
                System.out.println("_____________________________");
              }
              Thread.sleep(Integer.parseInt(server.pref.get("SEND_DELAY(MS)", "")));
              vlc.PauseAndPlay();
            }
            catch (Exception e)
            {
              System.out.println("____chat.java____line_82____");
              e.printStackTrace();
              System.out.println("____________________________");
            }
          }
        }
        else if (this.what == 'i')
        {
          line = ins.readLine();
          if (line == null)
          {
            stop();
            return;
          }
          if (line != null)
          {
            if (line.compareToIgnoreCase("#end") == 0)
            {
              try
              {
                Calendar cal = new GregorianCalendar();
                int timme = cal.get(11);
                int minut = cal.get(12);
                int sekund = cal.get(13);
                int milis = cal.get(14);
                
                System.out.println("[RECEIVED | " + timme + ":" + minut + ":" + sekund + ":" + milis + "]: " + line);
              }
              catch (Exception e)
              {
                line = "";
                System.out.println("_____chat.java___line_163_____");
                e.printStackTrace();
                System.out.println("_____________________________");
              }
              System.out.print("\nYour friend sent an #end and terminsated the session.\nPlease press [ENTER] to close the program...");
              server.alive.interrupt();
              stop();
              
              return;
            }
            if (line.compareToIgnoreCase("#p") == 0)
            {
              try
              {
                Calendar cal = new GregorianCalendar();
                int timme = cal.get(11);
                int minut = cal.get(12);
                int sekund = cal.get(13);
                int milis = cal.get(14);
                System.out.println("[RECEIVED | " + timme + ":" + minut + ":" + sekund + ":" + milis + "]: " + line);
              }
              catch (Exception e)
              {
                line = "";
                System.out.println("_____chat.java___line_93_____");
                e.printStackTrace();
                System.out.println("_____________________________");
              }
              vlc.PauseAndPlay();
            }
          }
        }
      }
    }
    catch (Exception ex)
    {
      try
      {
        System.out.println("[*1*}");
        ex.printStackTrace();
        server.alive.interrupt();
        stop();
      }
      catch (Exception exx)
      {
        stop();
        System.out.println("[2-)");
        exx.printStackTrace();
      }
    }
  }
  
  public static void stop()
  {
    stop = true;
    try
    {
      ios.close();
      ins.close();
    }
    catch (Exception ex)
    {
      System.out.println("[9_}: ");
      ex.printStackTrace();
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
