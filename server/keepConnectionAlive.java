public class keepConnectionAlive
  implements Runnable
{
  public void run()
  {
    for (;;)
    {
      
      try
      {
        Thread.sleep(300000L);
      }
      catch (InterruptedException ex)
      {
        Thread.currentThread().interrupt();
        break;
      }
      catch (Exception localException) {}
    }
  }
}
