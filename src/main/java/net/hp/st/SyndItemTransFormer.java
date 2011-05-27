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

    // Állampapír [5.4505HUF] --- Bonitas [1.8578HUF] --- Budapest Abszolút
    // Hozam Alap [1.3156HUF] --- Euró Pénzpiaci [1.3629HUF] --- Ingatlan AA
    // [1.3322HUF] --- Kötvény [4.3143HUF] --- Nemz.Részv. [0.7018HUF] ---
    // Növekedési [2.6565HUF] --- Pénzpiaci [1.179952HUF] ---
    List<BBFundEntry> arrayList = parseEntry(syndEntry.getDescription().getValue());
    for (BBFundEntry bbFundEntry : arrayList) {
      bbFundEntry.setPublishedDate(syndEntry.getPublishedDate());
    }
    return arrayList;
  }

  /**
   * @param priceLine
   *          TODO
   * @return
   */
  private List<BBFundEntry> parseEntry(String priceLine) {
    List<BBFundEntry> ret = new ArrayList<BBFundEntry>();

    String[] priceItems = priceLine.split("\\s+---\\s+");

    for (String str : priceItems) {
      String[] items = str.split("\\s*\\[");

      String name = items[0];
      Double value = getValue(items[1]);
      String currency = getCurrency(items[1]);

      ret.add(new BBFundEntry(name, value, currency));
    }

    return ret;
  }

  private String getCurrency(String item) {
    Pattern pattern2 = COMPILE2;
    Matcher matcher2 = pattern2.matcher(item);

    String currency;
    if (matcher2.find()) {
      currency = matcher2.group();
    } else {
      currency = "XXX";
    }
    return currency;
  }

  private Double getValue(String item) {
    Matcher matcher1 = COMPILE1.matcher(item);

    Double value;
    if (matcher1.find()) {
      value = Double.valueOf(matcher1.group());
    } else {
      value = 0.0;
    }
    return value;
  }

}
