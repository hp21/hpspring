package net.hp.st;

import java.util.Date;

public class BBFundEntry {

  public String name;
  public double value;
  public String currency;
  private Date publishedDate;

  public BBFundEntry(String name, double value, String currency) {
    this(name, value, currency, null);
  }

  public BBFundEntry(String name, double value, String currency, Date date) {
    super();
    this.name = name;
    this.value = value;
    this.currency = currency;
    this.publishedDate = date;
  }

  public Date getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(Date publishedDate) {
    this.publishedDate = publishedDate;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("BBFundEntry [name=").append(name).append(", value=").append(value).append(", currency=")
        .append(currency).append(", publishedDate=").append(publishedDate).append("]");
    return builder.toString();
  }

}
