package net.hp.st;

import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.channel.ChannelInterceptor;

public class HPInterceptor implements ChannelInterceptor {

  @Override
  public Message<?> preSend(Message<?> message, MessageChannel channel) {
    System.out.println("preSend" + message + "/" + channel);

    return message;
  }

  @Override
  public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
    System.out.println("postSend" + message + "/" + channel + "/" + sent);

  }

  @Override
  public boolean preReceive(MessageChannel channel) {
    System.out.println("preReceive " + channel);
    return true;
  }

  @Override
  public Message<?> postReceive(Message<?> message, MessageChannel channel) {
    System.out.println("postReceive " + message + "/" + channel);
    return message;
  }

}
