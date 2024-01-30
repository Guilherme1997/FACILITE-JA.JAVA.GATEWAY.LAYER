package com.facilite.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;


@Configuration
public class RabbitMQConfig {
	
	
	   @Value("${exchange.fanoutExchangePayment}")
	    private String fanoutExchange;

	    @Value("${queue.queuePayment}")
	    private String queue;

	   @Bean
	    public Exchange fanoutExchange() {
	        return new FanoutExchange(this.fanoutExchange);
	    }

	    @Bean
	    public Queue queue() {
	        return new Queue(this.queue);
	    }
	    
	    @Bean
        public Binding bindin(FanoutExchange fanoutExchange,
            Queue queue) {
            return BindingBuilder.bind(queue).to(fanoutExchange);
        }
	    
	    @Bean
	    public Jackson2JsonMessageConverter jsonMessageConverter() {
	        return new Jackson2JsonMessageConverter();
	    }

	    @Bean
	    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter jsonMessageConverter) {
	        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	        rabbitTemplate.setMessageConverter(jsonMessageConverter);
	        return rabbitTemplate;
	    }
		
}
