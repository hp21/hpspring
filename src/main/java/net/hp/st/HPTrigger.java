package net.hp.st;

import java.util.Date;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;

public class HPTrigger implements Trigger {

  //@Override
  public Date getNextRunTime(Date lastScheduledRunTime, Date lastCompleteTime) {
    Date lc = null == lastCompleteTime ? new Date() : lastCompleteTime;

    return new Date(lc.getTime() + 1200);
  }

  @Override
  public Date nextExecutionTime(TriggerContext arg0) {
    // TODO Auto-generated method stub
    return null;
  }

}
