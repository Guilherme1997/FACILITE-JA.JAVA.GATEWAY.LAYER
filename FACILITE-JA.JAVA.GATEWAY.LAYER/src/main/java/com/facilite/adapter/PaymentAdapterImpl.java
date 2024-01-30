package com.facilite.adapter;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.facilite.dto.PaymentDTO;



@Component
public class PaymentAdapterImpl  implements  PaymentAdapter{

	@Value("${exchange.fanoutExchangePayment}")
	private String fanoutExchange;
	
	@Override
	public void sendingPayment(PaymentDTO dto) {
		sendMessage(dto);
	}
	
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendMessage(PaymentDTO dto) {
        rabbitTemplate.convertAndSend(fanoutExchange, "", dto);
        System.out.println("Message sent: " + dto);
    }
	


}
