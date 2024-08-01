import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @JmsListener(destination = "queue1", containerFactory = "jmsListenerContainerFactory1")
    public void receiveMessageFromQueue1(String message) {
        System.out.println("Received message from Queue1: " + message);
    }

    @JmsListener(destination = "queue2", containerFactory = "jmsListenerContainerFactory2")
    public void receiveMessageFromQueue2(String message) {
        System.out.println("Received message from Queue2: " + message);
    }
}
