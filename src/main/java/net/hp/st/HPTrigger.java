package net.hp.st;

import java.util.Date;

import org.springframework.integration.scheduling.Trigger;

public class HPTrigger implements Trigger {

  @Override
  public Date getNextRunTime(Date lastScheduledRunTime, Date lastCompleteTime) {
    Date lc = null == lastCompleteTime ? new Date() : lastCompleteTime;

    return new Date(lc.getTime() + 1200);
  }

}
