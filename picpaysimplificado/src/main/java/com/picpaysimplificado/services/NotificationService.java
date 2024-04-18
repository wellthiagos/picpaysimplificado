package com.picpaysimplificado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.dtos.NotificationDTO;

@Service
public class NotificationService {
	@Autowired
	private RestTemplate restTemplate;
	
	public void sendNotification(User user, String message) throws Exception {
		String email = user.getEmail();
		NotificationDTO notificationRequest = new NotificationDTO(email, message);
		/*ResponseEntity<Boolean> notificationResponse = this.restTemplate.postForEntity("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6", notificationRequest, Boolean.class);
		
		if(!notificationResponse.getStatusCode().equals(HttpStatus.OK)) {
			System.out.println("Erro ao enviar notificação");
			throw new Exception("O servicço de notificação está indisponível.");
		}*/
		System.out.println("Notificação: " + notificationRequest);
		System.out.println("Notificação enviada para o usuário.");
	}
}
