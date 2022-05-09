package com.omnia.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.omnia.app.service.CommandeService;

@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	// private final AsyncService service;

	@Autowired
	private CommandeService commandeService;

	/*
	 * public ScheduledTasks(AsyncService service) { this.service = service; }
	 */

	@Scheduled(fixedRate = 180_000)
	public void reportCurrentTime() {
		// this.service.updateCommandsWaitingTime();

		commandeService.updateCommandesWaitingTime();

	}

}
