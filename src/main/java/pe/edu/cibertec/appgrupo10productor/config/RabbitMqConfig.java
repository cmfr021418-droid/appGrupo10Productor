package pe.edu.cibertec.appgrupo10productor.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    public static final String EXCHANGE = "Grupo10Exchange";
    public static final String QUEUE = "Grupo10Queue";
    public static final String ROUTING_KEY = "Grupo10Routing";

    @Bean
    public DirectExchange grupo10Exchange(){
        return new DirectExchange(EXCHANGE);
    }
    @Bean
    public Queue grupo10Queue(){return new Queue(QUEUE, true);}

    @Bean
    public Binding grupo10Binding(){
        return BindingBuilder.bind(grupo10Queue())
                .to(grupo10Exchange()).with(ROUTING_KEY);
    }
}
