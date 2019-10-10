package com.piy.springBootWebApp.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piy.springBootWebApp.model.Shipwreck;
import com.piy.springBootWebApp.repository.ShipwreckRepo;

@RestController
@RequestMapping("/api/v1")
public class ShipwreckController {
	
	@Autowired
	private ShipwreckRepo shipwreckRepo;
	
	@RequestMapping(value="shipwrecks", method=RequestMethod.GET)
	public List<Shipwreck> list(){
		
		//return ShipwreckStub.list();
		return shipwreckRepo.findAll();
	}
	
	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.GET)
	public Shipwreck get(@PathVariable long id) {
		
		//return ShipwreckStub.get(id);
		System.out.println(shipwreckRepo.getOne(id));
		return shipwreckRepo.getOne(id);
	}
	
	@RequestMapping(value="shipwrecks", method=RequestMethod.POST)
	public Shipwreck create(@RequestBody Shipwreck wreck) {
		
		//return ShipwreckStub.create(wreck);
		return shipwreckRepo.saveAndFlush(wreck);

	}
	
	@RequestMapping(value="shipwrecks/{id}", method=RequestMethod.PUT)
	public Shipwreck update(@RequestBody Shipwreck wreck, @PathVariable long id) {
		
		//return ShipwreckStub.update(id, wreck);
		Shipwreck shipwreck = shipwreckRepo.getOne(id);
		BeanUtils.copyProperties(wreck, shipwreck);
		return shipwreckRepo.saveAndFlush(shipwreck);
	}
	
	@RequestMapping(value="shipwrecks/{id}",method=RequestMethod.DELETE)
	public Shipwreck delete(@PathVariable long id) {
		
		//return shipwreck
		Shipwreck shipwreck = shipwreckRepo.getOne(id);
		shipwreckRepo.deleteById(id);
		return shipwreck;
	}
	
	//To test request parameters. E.g. http://localhost:8080/api/v1/add?a=1&b=1
	@RequestMapping(value="add",method=RequestMethod.GET)
	public int addNumbers(@RequestParam int a, @RequestParam int b) {
		
		return a+b;
	}
	
}
