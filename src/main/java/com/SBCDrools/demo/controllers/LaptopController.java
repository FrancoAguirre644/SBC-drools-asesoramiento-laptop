package com.SBCDrools.demo.controllers;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SBCDrools.demo.models.Laptop;

@RestController
public class LaptopController {
	
	private final KieContainer kieContainer;
	
	@Autowired
	public LaptopController(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
	
	@PostMapping("/laptops")
	public Laptop index(@RequestBody Laptop laptop) {

		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(laptop);
		kieSession.fireAllRules();
		kieSession.dispose();
		
		return laptop;
	}

}
