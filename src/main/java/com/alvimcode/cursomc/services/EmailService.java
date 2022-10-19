package com.alvimcode.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.alvimcode.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
