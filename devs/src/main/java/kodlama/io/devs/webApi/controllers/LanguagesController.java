package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.requests.language.CreateLanguageRequest;
import kodlama.io.devs.business.requests.language.DeleteLanguageRequest;
import kodlama.io.devs.business.requests.language.UpdateLanguageRequest;
import kodlama.io.devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<GetAllLanguagesResponse> getAll(){
		return languageService.getAll();
	}
	
	@GetMapping("/getById")
	public Language getById(Integer id) throws Exception{
		return languageService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception{
		languageService.add(createLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception{
		languageService.delete(deleteLanguageRequest);
	}
	
	@PutMapping("/update")
	public void update(UpdateLanguageRequest updateLanguageRequest, Integer id) throws Exception{
		languageService.update(updateLanguageRequest, id);
	}
}
