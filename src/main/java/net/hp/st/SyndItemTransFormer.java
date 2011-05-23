package net.hp.st;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.syndication.feed.synd.SyndEntry;

public class SyndItemTransFormer {

  private static final Pattern COMPILE1 = Pattern.compile("\\d+.\\d*");
  private static final Pattern COMPILE2 = Pattern.compile("[A-Z]{3}");

  public List<BBFundEntry> transform(SyndEntry syndEntry) {

    // �llampap�r [5.4505HUF] --- Bonitas [1.8578HUF] --- Budapest Abszol�t
    // Hozam Alap [1.3156HUF] --- Eur� P�nzpiaci [1.3629HUF] --- Ingatlan AA
    // [1.3322HUF] --- K�tv�ny [4.3143HUF] --- Nemz.R�szv. [0.7018HUF] ---
    // N�veked�si [2.6565HUF] --- P�nzpiaci [1.179952HUF] ---
    List<BBFundEntry> arrayList = parseEntry(syndEntry.getDescription().getValue());
    return arrayList;
  }

  /**
   * @param priceLine
   *          TODO
   * @return
   */
  private List<BBFundEntry> parseEntry(String priceLine) {
    List<BBFundEntry> ret = new ArrayList<BBFundEntry>();

    String[] priceItems = priceLine.split(" --- ");

    for (String str : priceItems) {

      String[] items = str.split("\\s\\[");
      String name = items[0];

      Matcher matcher1 = COMPILE1.matcher(items[1]);

      Double value;
      if (matcher1.find()) {
        value = Double.valueOf(matcher1.group());
      } else {
        value = 0.0;
      }

      Pattern pattern2 = COMPILE2;
      Matcher matcher2 = pattern2.matcher(items[1]);

      String currency;
      if (matcher2.find()) {
        currency = matcher2.group();
      } else {
        currency = "XXX";
      }

      ret.add(new BBFundEntry(name, value, currency));

    }

    return ret;
  }

}
