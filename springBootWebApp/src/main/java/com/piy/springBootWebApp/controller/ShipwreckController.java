package com.piy.springBootWebApp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.piy.springBootWebApp.model.Shipwreck;

@RestController
@RequestMapping("/api/v1")
public class ShipwreckController {

	@RequestMapping(value="shipwrecks", method=RequestMethod.GET)
	List<Shipwreck> list(){
		return ShipwreckStub.list();
	}
}
