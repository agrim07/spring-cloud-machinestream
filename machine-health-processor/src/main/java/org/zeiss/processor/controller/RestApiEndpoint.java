package org.zeiss.processor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zeiss.processor.domain.MachineHealth;
import org.zeiss.processor.service.MachineHealthService;

import java.util.List;
import java.util.Optional;

@RestController
public class RestApiEndpoint {
	private static final Logger log = LoggerFactory.getLogger(RestApiEndpoint.class);

	private MachineHealthService machineHealthService;

	public RestApiEndpoint(MachineHealthService machineHealthService) {
		this.machineHealthService = machineHealthService;
	}

	@GetMapping("/machine-health-status")
	public List<MachineHealth> reportMachineHealth() {
		List<MachineHealth> machineHealths = machineHealthService.fetchAllMachineHealthEvent();
		return machineHealths;
	}

	@GetMapping("/machine-health-status/{machineId}")
	public Optional<MachineHealth> reportMachineHealth(@PathVariable String machineId) {
		Optional<MachineHealth> machineHealth = machineHealthService.fetchMachineHealthEventById(machineId);
		return machineHealth;
	}

	@PostMapping("/machine-health-status")
	public ResponseEntity<String> placeMachineHealthEvent(@RequestBody MachineHealth machineHealth) {
		machineHealthService.storeMachineHealthEvent(machineHealth);
		return ResponseEntity.ok("Success");
	}
}
