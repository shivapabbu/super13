package com.super13.notification.service;

import com.super13.notification.domain.NotificationType;
import com.super13.notification.domain.Recipient;

import javax.mail.MessagingException;
import java.io.IOException;

public interface EmailService {

	void send(NotificationType type, Recipient recipient, String attachment) throws MessagingException, IOException;

}
