package net.hp.st;

public class BBFundEntry {

  public String name;
  public double value;
  public String currency;

  public BBFundEntry(String name, double value, String currency) {
    super();
    this.name = name;
    this.value = value;
    this.currency = currency;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("BBFundEntry [name=").append(name).append(", value=").append(value).append(", currency=")
        .append(currency).append("]");
    return builder.toString();
  }

}
