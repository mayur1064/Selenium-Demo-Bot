import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import com.tibco.tibjms.TibjmsConnectionFactory;

@Configuration
@EnableJms
public class JmsConfig {

    @Bean
    public ConnectionFactory connectionFactory1() {
        TibjmsConnectionFactory connectionFactory = new TibjmsConnectionFactory();
        connectionFactory.setServerUrl("tcp://broker1-url:7222");
        connectionFactory.setUserName("user1");
        connectionFactory.setUserPassword("password1");
        return new CachingConnectionFactory(connectionFactory);
    }

    @Bean
    public ConnectionFactory connectionFactory2() {
        TibjmsConnectionFactory connectionFactory = new TibjmsConnectionFactory();
        connectionFactory.setServerUrl("tcp://broker2-url:7222");
        connectionFactory.setUserName("user2");
        connectionFactory.setUserPassword("password2");
        return new CachingConnectionFactory(connectionFactory);
    }

    @Bean
    public JmsTemplate jmsTemplate1() {
        return new JmsTemplate(connectionFactory1());
    }

    @Bean
    public JmsTemplate jmsTemplate2() {
        return new JmsTemplate(connectionFactory2());
    }
}
