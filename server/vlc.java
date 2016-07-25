import java.io.PrintStream;
import java.net.Socket;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.prefs.Preferences;

public class vlc
{
  public static void PauseAndPlay()
    throws Exception
  {
    Socket sock = new Socket("127.0.0.1", Integer.parseInt(server.pref.get("VLC_PORT", "")));
    PrintStream ps = new PrintStream(sock.getOutputStream());
    
    ps.print("pause");
    
    ps.close();
    sock.close();
    
    Calendar cal = new GregorianCalendar();
    int timme = cal.get(11);
    int minut = cal.get(12);
    int sekund = cal.get(13);
    int milis = cal.get(14);
    
    System.out.println("([Paused at] " + timme + ":" + minut + ":" + sekund + ":" + milis + ")\n");
  }
  
  public static void testVLC()
  {
    Socket sock = null;
    PrintStream PS = null;
    try
    {
      sock = new Socket("127.0.0.1", Integer.parseInt(server.pref.get("VLC_PORT", "")));
      PS = new PrintStream(sock.getOutputStream());
      PS.print("abc");
    }
    catch (Exception ex)
    {
      for (;;)
      {
        System.out.println("------------------");
        System.out.println("Could not make a connection to VLC on port " + server.pref.get("VLC_PORT", ""));
        System.out.println("Make sure you have followed these steps: ");
        System.out.println("1. Open up VLC");
        System.out.println("2. Go to Tools -> Preferences -> (click show settings: All)");
        System.out.println("3. Go to Interface -> Main interfaces");
        System.out.println("4. Tick the 'Remote Control Interface'");
        System.out.println("5. Go to Interface -> Main interfaces -> RC");
        System.out.println("6. Tick the 'Do not open a DOS command box interface'");
        System.out.println("7. In TCP command input, type '127.0.0.1:" + server.pref.get("VLC_PORT", "") + "'");
        System.out.println("8. Save your settings");
        System.out.println("9. Click View -> Add Interface and click on Console (even if it already seems to be chosen)");
        System.out.println("It should work now, press [ENTER]...");
        new Scanner(System.in).nextLine();
        
        sock = null;
        PS = null;
        try
        {
          sock.close();
          PS.close();
        }
        catch (Exception localException2) {}
      }
    }
    finally
    {
      try
      {
        sock.close();
        PS.close();
      }
      catch (Exception localException3) {}
    }
  }
}
