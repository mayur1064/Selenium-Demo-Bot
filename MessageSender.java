import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {

    private final JmsTemplate jmsTemplate1;
    private final JmsTemplate jmsTemplate2;

    public MessageSender(JmsTemplate jmsTemplate1, JmsTemplate jmsTemplate2) {
        this.jmsTemplate1 = jmsTemplate1;
        this.jmsTemplate2 = jmsTemplate2;
    }

    public void sendMessageToQueue1(String message) {
        jmsTemplate1.convertAndSend("queue1", message);
    }

    public void sendMessageToQueue2(String message) {
        jmsTemplate2.convertAndSend("queue2", message);
    }
}
