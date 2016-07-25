import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class server
{
  static Preferences pref = Preferences.userRoot().node("/shahin/whominator/server");
  static Thread alive = null;
  
  public static void main(String[] args)
    throws Exception
  {
    try
    {
      if (args[0].compareToIgnoreCase("settings") == 0)
      {
        settings();System.exit(0);
      }
      else if (args[0].compareToIgnoreCase("uninstall") == 0)
      {
        uninstall();System.exit(0);
      }
      else
      {
        System.out.println("This command-line arguement doesn't do shit, yo");
      }
    }
    catch (Exception localException) {}
    if (pref.get("VLC_PORT", "").isEmpty())
    {
      System.out.println("All settings are not set. Please open CMD and go to where the .exe is and type: fileName.exe settings");
      System.out.print("Press [ENTER] to exit the program...");
      new Scanner(System.in).nextLine();
      System.exit(0);
    }
    vlc.testVLC();
    
    int PORT = Integer.parseInt(pref.get("LISTEN_TO_PORT", ""));
    
    ServerSocket serv_sock = null;
    Socket sock = null;
    
    Thread ingoing = null;
    Thread outgoing = null;
    try
    {
      serv_sock = new ServerSocket(PORT);
      
      System.out.println("[Server] Waiting for a connection to be made...");
      
      sock = serv_sock.accept();
      serv_sock.close();
      
      System.out.println("A connection was made.");
      
      outgoing = new Thread(new chat(sock, 'o'));
      outgoing.start();
      
      ingoing = new Thread(new chat(sock, 'i'));
      ingoing.start();
      
      System.out.println("\n\n\n\n\n\n\n");
      System.out.println("-------COMMANDS-------");
      System.out.println("#p to paus or play, #end to terminate the program\n\n");
      System.out.println("READY FOR COMMANDS:\n");
      
      alive = new Thread(new keepConnectionAlive());
      alive.start();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  
  private static void settings()
  {
    try
    {
      Scanner scn = new Scanner(System.in);
      
      String[] theProperties = { "LISTEN_TO_PORT", "VLC_PORT", "SEND_DELAY(MS)" };
      int propertiesSize = theProperties.length;
      
      System.out.println("\n\t\t~~SETTINGS~~");
      System.out.println("*\tJust press [ENTER] on the settings you don't want to change\t*\n");
      for (int i = 0; i < propertiesSize; i++)
      {
        System.out.print(theProperties[i] + "=");
        keyboard_type(pref.get(theProperties[i], "").toCharArray());
        String newValue = scn.nextLine();
        pref.put(theProperties[i], newValue);
      }
      System.out.println("\nThe settings have been saved.\n");
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  private static void uninstall()
    throws BackingStoreException
  {
    pref.clear();
    System.out.println("Removed everything this program saved on your computer, you can now remove this .exe");
  }
  
  private static void keyboard_type(char[] word)
  {
    try
    {
      Robot r = new Robot();
      for (int i = 0; i < word.length; i++)
      {
        int keycode = KeyEvent.getExtendedKeyCodeForChar(word[i]);
        r.keyPress(keycode);
        r.keyRelease(keycode);
      }
    }
    catch (Exception e)
    {
      System.out.println(e);
    }
  }
}
