package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.devs.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.devs.entities.concretes.Technology;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
	private TechnologyService technologyService;
	
	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}
	
	@GetMapping("/getall")
	public List<Technology> getAll(){
		return technologyService.getAll();
	}
	
	@PostMapping("/add")
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception{
		technologyService.add(createTechnologyRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception{
		technologyService.delete(deleteTechnologyRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateTechnologyRequest updateTechnologyRequest, Integer id) throws Exception{
		technologyService.update(updateTechnologyRequest, id);
	}
}
