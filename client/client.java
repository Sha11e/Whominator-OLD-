import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class client
{
  static Preferences pref = Preferences.userRoot().node("/shahin/whominator/client");
  static Thread alive = null;
  
  /* Error */
  public static void main(String[] args)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: aaload
    //   3: ldc 40
    //   5: invokevirtual 42	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
    //   8: ifne +13 -> 21
    //   11: invokestatic 48	client:settings	()V
    //   14: iconst_0
    //   15: invokestatic 50	java/lang/System:exit	(I)V
    //   18: goto +36 -> 54
    //   21: aload_0
    //   22: iconst_0
    //   23: aaload
    //   24: ldc 56
    //   26: invokevirtual 42	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
    //   29: ifne +13 -> 42
    //   32: invokestatic 58	client:uninstall	()V
    //   35: iconst_0
    //   36: invokestatic 50	java/lang/System:exit	(I)V
    //   39: goto +15 -> 54
    //   42: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   45: ldc 64
    //   47: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   50: goto +4 -> 54
    //   53: astore_1
    //   54: getstatic 24	client:pref	Ljava/util/prefs/Preferences;
    //   57: ldc 72
    //   59: ldc 74
    //   61: invokevirtual 76	java/util/prefs/Preferences:get	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   64: invokevirtual 80	java/lang/String:isEmpty	()Z
    //   67: ifeq +37 -> 104
    //   70: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   73: ldc 84
    //   75: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   78: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   81: ldc 86
    //   83: invokevirtual 88	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   86: new 91	java/util/Scanner
    //   89: dup
    //   90: getstatic 93	java/lang/System:in	Ljava/io/InputStream;
    //   93: invokespecial 97	java/util/Scanner:<init>	(Ljava/io/InputStream;)V
    //   96: invokevirtual 100	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   99: pop
    //   100: iconst_0
    //   101: invokestatic 50	java/lang/System:exit	(I)V
    //   104: invokestatic 104	vlc:testVLC	()V
    //   107: aconst_null
    //   108: astore_1
    //   109: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   112: ldc 109
    //   114: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   117: iconst_1
    //   118: istore_2
    //   119: getstatic 24	client:pref	Ljava/util/prefs/Preferences;
    //   122: ldc 111
    //   124: ldc 74
    //   126: invokevirtual 76	java/util/prefs/Preferences:get	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   129: invokestatic 113	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   132: astore_3
    //   133: goto +50 -> 183
    //   136: new 119	java/net/Socket
    //   139: dup
    //   140: aload_3
    //   141: getstatic 24	client:pref	Ljava/util/prefs/Preferences;
    //   144: ldc 121
    //   146: ldc 74
    //   148: invokevirtual 76	java/util/prefs/Preferences:get	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   151: invokestatic 123	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   154: invokespecial 128	java/net/Socket:<init>	(Ljava/net/InetAddress;I)V
    //   157: astore_1
    //   158: goto +25 -> 183
    //   161: astore 4
    //   163: iload_2
    //   164: ifne +11 -> 175
    //   167: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   170: ldc -125
    //   172: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   175: iconst_0
    //   176: istore_2
    //   177: ldc2_w 133
    //   180: invokestatic 135	java/lang/Thread:sleep	(J)V
    //   183: aload_1
    //   184: ifnull -48 -> 136
    //   187: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   190: ldc -115
    //   192: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   195: new 136	java/lang/Thread
    //   198: dup
    //   199: new 143	chat
    //   202: dup
    //   203: aload_1
    //   204: invokespecial 145	chat:<init>	(Ljava/net/Socket;)V
    //   207: invokespecial 148	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   210: astore 4
    //   212: aload 4
    //   214: invokevirtual 151	java/lang/Thread:start	()V
    //   217: new 154	java/io/BufferedReader
    //   220: dup
    //   221: new 156	java/io/InputStreamReader
    //   224: dup
    //   225: aload_1
    //   226: invokevirtual 158	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   229: invokespecial 162	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   232: invokespecial 163	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   235: astore 5
    //   237: aconst_null
    //   238: astore 6
    //   240: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   243: ldc -90
    //   245: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   248: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   251: ldc -88
    //   253: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   256: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   259: ldc -86
    //   261: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   264: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   267: ldc -84
    //   269: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   272: new 136	java/lang/Thread
    //   275: dup
    //   276: new 174	keepConnectionAlive
    //   279: dup
    //   280: invokespecial 176	keepConnectionAlive:<init>	()V
    //   283: invokespecial 148	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   286: putstatic 26	client:alive	Ljava/lang/Thread;
    //   289: getstatic 26	client:alive	Ljava/lang/Thread;
    //   292: invokevirtual 151	java/lang/Thread:start	()V
    //   295: invokestatic 177	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   298: astore 7
    //   300: goto +465 -> 765
    //   303: aload 5
    //   305: invokevirtual 183	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   308: astore 6
    //   310: goto +59 -> 369
    //   313: astore 8
    //   315: getstatic 26	client:alive	Ljava/lang/Thread;
    //   318: invokevirtual 186	java/lang/Thread:interrupt	()V
    //   321: invokestatic 189	chat:stop	()V
    //   324: aload_1
    //   325: invokevirtual 192	java/net/Socket:close	()V
    //   328: goto +5 -> 333
    //   331: astore 9
    //   333: aload_1
    //   334: invokevirtual 192	java/net/Socket:close	()V
    //   337: goto +31 -> 368
    //   340: astore 13
    //   342: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   345: new 195	java/lang/StringBuilder
    //   348: dup
    //   349: ldc -59
    //   351: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   354: aload 13
    //   356: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   359: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   368: return
    //   369: aload 6
    //   371: ifnonnull +42 -> 413
    //   374: invokestatic 189	chat:stop	()V
    //   377: aload_1
    //   378: invokevirtual 192	java/net/Socket:close	()V
    //   381: goto +31 -> 412
    //   384: astore 13
    //   386: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   389: new 195	java/lang/StringBuilder
    //   392: dup
    //   393: ldc -59
    //   395: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   398: aload 13
    //   400: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   403: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   412: return
    //   413: aload 6
    //   415: ifnull +350 -> 765
    //   418: aload 6
    //   420: ldc -43
    //   422: invokevirtual 42	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
    //   425: ifne +189 -> 614
    //   428: aload 7
    //   430: bipush 11
    //   432: invokevirtual 215	java/util/Calendar:get	(I)I
    //   435: istore 8
    //   437: aload 7
    //   439: bipush 12
    //   441: invokevirtual 215	java/util/Calendar:get	(I)I
    //   444: istore 9
    //   446: aload 7
    //   448: bipush 13
    //   450: invokevirtual 215	java/util/Calendar:get	(I)I
    //   453: istore 10
    //   455: aload 7
    //   457: bipush 14
    //   459: invokevirtual 215	java/util/Calendar:get	(I)I
    //   462: istore 11
    //   464: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   467: new 195	java/lang/StringBuilder
    //   470: dup
    //   471: ldc -38
    //   473: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   476: iload 8
    //   478: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   481: ldc -33
    //   483: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: iload 9
    //   488: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   491: ldc -33
    //   493: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: iload 10
    //   498: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   501: ldc -33
    //   503: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: iload 11
    //   508: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   511: ldc -31
    //   513: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload 6
    //   518: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   527: goto +30 -> 557
    //   530: astore 8
    //   532: ldc 74
    //   534: astore 6
    //   536: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   539: ldc -29
    //   541: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   544: aload 8
    //   546: invokevirtual 229	java/lang/Exception:printStackTrace	()V
    //   549: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   552: ldc -24
    //   554: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   557: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   560: ldc -22
    //   562: invokevirtual 88	java/io/PrintStream:print	(Ljava/lang/String;)V
    //   565: getstatic 26	client:alive	Ljava/lang/Thread;
    //   568: invokevirtual 186	java/lang/Thread:interrupt	()V
    //   571: invokestatic 189	chat:stop	()V
    //   574: aload_1
    //   575: invokevirtual 192	java/net/Socket:close	()V
    //   578: aload_1
    //   579: invokevirtual 192	java/net/Socket:close	()V
    //   582: goto +31 -> 613
    //   585: astore 13
    //   587: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   590: new 195	java/lang/StringBuilder
    //   593: dup
    //   594: ldc -59
    //   596: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   599: aload 13
    //   601: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   604: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   613: return
    //   614: aload 6
    //   616: ldc -20
    //   618: invokevirtual 42	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
    //   621: ifne +144 -> 765
    //   624: new 238	java/util/GregorianCalendar
    //   627: dup
    //   628: invokespecial 240	java/util/GregorianCalendar:<init>	()V
    //   631: astore 7
    //   633: aload 7
    //   635: bipush 11
    //   637: invokevirtual 215	java/util/Calendar:get	(I)I
    //   640: istore 8
    //   642: aload 7
    //   644: bipush 12
    //   646: invokevirtual 215	java/util/Calendar:get	(I)I
    //   649: istore 9
    //   651: aload 7
    //   653: bipush 13
    //   655: invokevirtual 215	java/util/Calendar:get	(I)I
    //   658: istore 10
    //   660: aload 7
    //   662: bipush 14
    //   664: invokevirtual 215	java/util/Calendar:get	(I)I
    //   667: istore 11
    //   669: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   672: new 195	java/lang/StringBuilder
    //   675: dup
    //   676: ldc -38
    //   678: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   681: iload 8
    //   683: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   686: ldc -33
    //   688: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: iload 9
    //   693: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   696: ldc -33
    //   698: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: iload 10
    //   703: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   706: ldc -33
    //   708: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: iload 11
    //   713: invokevirtual 220	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   716: ldc -31
    //   718: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: aload 6
    //   723: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   729: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   732: goto +30 -> 762
    //   735: astore 8
    //   737: ldc 74
    //   739: astore 6
    //   741: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   744: ldc -15
    //   746: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   749: aload 8
    //   751: invokevirtual 229	java/lang/Exception:printStackTrace	()V
    //   754: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   757: ldc -24
    //   759: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   762: invokestatic 243	vlc:PauseAndPlay	()V
    //   765: aload 4
    //   767: invokevirtual 246	java/lang/Thread:isAlive	()Z
    //   770: ifne -467 -> 303
    //   773: goto +207 -> 980
    //   776: astore_3
    //   777: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   780: ldc -7
    //   782: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   785: aload_3
    //   786: invokevirtual 251	java/net/SocketException:printStackTrace	()V
    //   789: aload_1
    //   790: invokevirtual 192	java/net/Socket:close	()V
    //   793: goto +222 -> 1015
    //   796: astore 13
    //   798: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   801: new 195	java/lang/StringBuilder
    //   804: dup
    //   805: ldc -59
    //   807: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   810: aload 13
    //   812: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   815: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   821: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   824: goto +191 -> 1015
    //   827: astore_3
    //   828: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   831: new 195	java/lang/StringBuilder
    //   834: dup
    //   835: ldc -2
    //   837: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   840: aload_3
    //   841: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   844: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   850: aload_1
    //   851: invokevirtual 192	java/net/Socket:close	()V
    //   854: goto +161 -> 1015
    //   857: astore 13
    //   859: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   862: new 195	java/lang/StringBuilder
    //   865: dup
    //   866: ldc -59
    //   868: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   871: aload 13
    //   873: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   876: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   882: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   885: goto +130 -> 1015
    //   888: astore_3
    //   889: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   892: ldc_w 259
    //   895: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   898: aload_3
    //   899: invokevirtual 261	java/lang/InterruptedException:printStackTrace	()V
    //   902: aload_1
    //   903: invokevirtual 192	java/net/Socket:close	()V
    //   906: goto +109 -> 1015
    //   909: astore 13
    //   911: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   914: new 195	java/lang/StringBuilder
    //   917: dup
    //   918: ldc -59
    //   920: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   923: aload 13
    //   925: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   928: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   934: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   937: goto +78 -> 1015
    //   940: astore 12
    //   942: aload_1
    //   943: invokevirtual 192	java/net/Socket:close	()V
    //   946: goto +31 -> 977
    //   949: astore 13
    //   951: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   954: new 195	java/lang/StringBuilder
    //   957: dup
    //   958: ldc -59
    //   960: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   963: aload 13
    //   965: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   968: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   974: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   977: aload 12
    //   979: athrow
    //   980: aload_1
    //   981: invokevirtual 192	java/net/Socket:close	()V
    //   984: goto +31 -> 1015
    //   987: astore 13
    //   989: getstatic 60	java/lang/System:out	Ljava/io/PrintStream;
    //   992: new 195	java/lang/StringBuilder
    //   995: dup
    //   996: ldc -59
    //   998: invokespecial 199	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1001: aload 13
    //   1003: invokevirtual 201	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1006: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1012: invokevirtual 66	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   1015: return
    // Line number table:
    //   Java source line #29	-> byte code offset #0
    //   Java source line #30	-> byte code offset #11
    //   Java source line #31	-> byte code offset #21
    //   Java source line #32	-> byte code offset #32
    //   Java source line #34	-> byte code offset #42
    //   Java source line #36	-> byte code offset #53
    //   Java source line #39	-> byte code offset #54
    //   Java source line #41	-> byte code offset #70
    //   Java source line #42	-> byte code offset #78
    //   Java source line #43	-> byte code offset #86
    //   Java source line #44	-> byte code offset #100
    //   Java source line #54	-> byte code offset #104
    //   Java source line #56	-> byte code offset #107
    //   Java source line #57	-> byte code offset #109
    //   Java source line #59	-> byte code offset #117
    //   Java source line #62	-> byte code offset #119
    //   Java source line #64	-> byte code offset #133
    //   Java source line #68	-> byte code offset #136
    //   Java source line #70	-> byte code offset #161
    //   Java source line #72	-> byte code offset #163
    //   Java source line #74	-> byte code offset #167
    //   Java source line #76	-> byte code offset #175
    //   Java source line #77	-> byte code offset #177
    //   Java source line #64	-> byte code offset #183
    //   Java source line #82	-> byte code offset #187
    //   Java source line #84	-> byte code offset #195
    //   Java source line #86	-> byte code offset #212
    //   Java source line #88	-> byte code offset #217
    //   Java source line #89	-> byte code offset #237
    //   Java source line #91	-> byte code offset #240
    //   Java source line #92	-> byte code offset #248
    //   Java source line #93	-> byte code offset #256
    //   Java source line #94	-> byte code offset #264
    //   Java source line #100	-> byte code offset #272
    //   Java source line #101	-> byte code offset #289
    //   Java source line #102	-> byte code offset #295
    //   Java source line #104	-> byte code offset #300
    //   Java source line #108	-> byte code offset #303
    //   Java source line #110	-> byte code offset #313
    //   Java source line #113	-> byte code offset #315
    //   Java source line #114	-> byte code offset #321
    //   Java source line #115	-> byte code offset #324
    //   Java source line #116	-> byte code offset #331
    //   Java source line #216	-> byte code offset #333
    //   Java source line #218	-> byte code offset #340
    //   Java source line #220	-> byte code offset #342
    //   Java source line #221	-> byte code offset #354
    //   Java source line #220	-> byte code offset #365
    //   Java source line #117	-> byte code offset #368
    //   Java source line #138	-> byte code offset #369
    //   Java source line #140	-> byte code offset #374
    //   Java source line #216	-> byte code offset #377
    //   Java source line #218	-> byte code offset #384
    //   Java source line #220	-> byte code offset #386
    //   Java source line #221	-> byte code offset #398
    //   Java source line #220	-> byte code offset #409
    //   Java source line #141	-> byte code offset #412
    //   Java source line #144	-> byte code offset #413
    //   Java source line #146	-> byte code offset #418
    //   Java source line #152	-> byte code offset #428
    //   Java source line #153	-> byte code offset #437
    //   Java source line #154	-> byte code offset #446
    //   Java source line #155	-> byte code offset #455
    //   Java source line #156	-> byte code offset #464
    //   Java source line #159	-> byte code offset #530
    //   Java source line #161	-> byte code offset #532
    //   Java source line #162	-> byte code offset #536
    //   Java source line #163	-> byte code offset #544
    //   Java source line #164	-> byte code offset #549
    //   Java source line #166	-> byte code offset #557
    //   Java source line #168	-> byte code offset #565
    //   Java source line #169	-> byte code offset #571
    //   Java source line #170	-> byte code offset #574
    //   Java source line #216	-> byte code offset #578
    //   Java source line #218	-> byte code offset #585
    //   Java source line #220	-> byte code offset #587
    //   Java source line #221	-> byte code offset #599
    //   Java source line #220	-> byte code offset #610
    //   Java source line #171	-> byte code offset #613
    //   Java source line #173	-> byte code offset #614
    //   Java source line #177	-> byte code offset #624
    //   Java source line #178	-> byte code offset #633
    //   Java source line #179	-> byte code offset #642
    //   Java source line #180	-> byte code offset #651
    //   Java source line #181	-> byte code offset #660
    //   Java source line #182	-> byte code offset #669
    //   Java source line #185	-> byte code offset #735
    //   Java source line #187	-> byte code offset #737
    //   Java source line #188	-> byte code offset #741
    //   Java source line #189	-> byte code offset #749
    //   Java source line #190	-> byte code offset #754
    //   Java source line #192	-> byte code offset #762
    //   Java source line #104	-> byte code offset #765
    //   Java source line #200	-> byte code offset #776
    //   Java source line #201	-> byte code offset #777
    //   Java source line #203	-> byte code offset #785
    //   Java source line #216	-> byte code offset #789
    //   Java source line #218	-> byte code offset #796
    //   Java source line #220	-> byte code offset #798
    //   Java source line #221	-> byte code offset #810
    //   Java source line #220	-> byte code offset #821
    //   Java source line #205	-> byte code offset #827
    //   Java source line #207	-> byte code offset #828
    //   Java source line #216	-> byte code offset #850
    //   Java source line #218	-> byte code offset #857
    //   Java source line #220	-> byte code offset #859
    //   Java source line #221	-> byte code offset #871
    //   Java source line #220	-> byte code offset #882
    //   Java source line #208	-> byte code offset #888
    //   Java source line #209	-> byte code offset #898
    //   Java source line #216	-> byte code offset #902
    //   Java source line #218	-> byte code offset #909
    //   Java source line #220	-> byte code offset #911
    //   Java source line #221	-> byte code offset #923
    //   Java source line #220	-> byte code offset #934
    //   Java source line #213	-> byte code offset #940
    //   Java source line #216	-> byte code offset #942
    //   Java source line #218	-> byte code offset #949
    //   Java source line #220	-> byte code offset #951
    //   Java source line #221	-> byte code offset #963
    //   Java source line #220	-> byte code offset #974
    //   Java source line #223	-> byte code offset #977
    //   Java source line #216	-> byte code offset #980
    //   Java source line #218	-> byte code offset #987
    //   Java source line #220	-> byte code offset #989
    //   Java source line #221	-> byte code offset #1001
    //   Java source line #220	-> byte code offset #1012
    //   Java source line #225	-> byte code offset #1015
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1016	0	args	String[]
    //   53	1	1	localException1	Exception
    //   108	873	1	sock	java.net.Socket
    //   118	59	2	isFirstTime	boolean
    //   132	9	3	ip	java.net.InetAddress
    //   776	10	3	e	java.net.SocketException
    //   827	14	3	e	java.io.IOException
    //   888	11	3	e	InterruptedException
    //   161	3	4	ex	Exception
    //   210	556	4	outgoing	Thread
    //   235	69	5	ins	java.io.BufferedReader
    //   238	502	6	line	String
    //   298	363	7	cal	java.util.Calendar
    //   313	3	8	io	java.io.IOException
    //   435	42	8	timme	int
    //   530	15	8	e	Exception
    //   640	42	8	timme	int
    //   735	15	8	e	Exception
    //   331	1	9	localException2	Exception
    //   444	43	9	minut	int
    //   649	43	9	minut	int
    //   453	44	10	sekund	int
    //   658	44	10	sekund	int
    //   462	45	11	milis	int
    //   667	45	11	milis	int
    //   940	38	12	localObject	Object
    //   340	15	13	ie	java.io.IOException
    //   384	15	13	ie	java.io.IOException
    //   585	15	13	ie	java.io.IOException
    //   796	15	13	ie	java.io.IOException
    //   857	15	13	ie	java.io.IOException
    //   909	15	13	ie	java.io.IOException
    //   949	15	13	ie	java.io.IOException
    //   987	15	13	ie	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   0	50	53	java/lang/Exception
    //   136	158	161	java/lang/Exception
    //   303	310	313	java/io/IOException
    //   315	328	331	java/lang/Exception
    //   333	337	340	java/io/IOException
    //   377	381	384	java/io/IOException
    //   428	527	530	java/lang/Exception
    //   578	582	585	java/io/IOException
    //   624	732	735	java/lang/Exception
    //   119	333	776	java/net/SocketException
    //   369	377	776	java/net/SocketException
    //   413	578	776	java/net/SocketException
    //   614	773	776	java/net/SocketException
    //   789	793	796	java/io/IOException
    //   119	333	827	java/io/IOException
    //   369	377	827	java/io/IOException
    //   413	578	827	java/io/IOException
    //   614	773	827	java/io/IOException
    //   850	854	857	java/io/IOException
    //   119	333	888	java/lang/InterruptedException
    //   369	377	888	java/lang/InterruptedException
    //   413	578	888	java/lang/InterruptedException
    //   614	773	888	java/lang/InterruptedException
    //   902	906	909	java/io/IOException
    //   119	333	940	finally
    //   369	377	940	finally
    //   413	578	940	finally
    //   614	789	940	finally
    //   827	850	940	finally
    //   888	902	940	finally
    //   942	946	949	java/io/IOException
    //   980	984	987	java/io/IOException
  }
  
  private static void settings()
  {
    try
    {
      Scanner scn = new Scanner(System.in);
      
      String[] theProperties = { "CONNECT_TO_IP", "CONNECT_TO_PORT", "VLC_PORT", "SEND_DELAY(MS)" };
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
  
  private static void uninstall()
    throws BackingStoreException
  {
    pref.clear();
    System.out.println("Removed all info, you can now remove the exe!");
  }
}
