package com.super13.notification.controller;

import com.super13.notification.domain.Recipient;
import com.super13.notification.service.RecipientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/recipients")
public class RecipientController {

	@Autowired
	private RecipientService recipientService;

	@RequestMapping(path = "/current", method = RequestMethod.GET)
	public Object getCurrentNotificationsSettings(Principal principal) {
		return recipientService.findByAccountName(principal.getName());
	}

	@PostMapping("/current")
	public Object saveCurrentNotificationsSettings(Principal principal, @Valid @RequestBody Recipient recipient) {
		return recipientService.save(principal.getName(), recipient);
	}
}
