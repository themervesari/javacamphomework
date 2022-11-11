package kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.TechnologyService;
import kodlama.io.devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.devs.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.devs.dataAcsess.abstracts.LanguageRepository;
import kodlama.io.devs.dataAcsess.abstracts.TechnologyRepository;
import kodlama.io.devs.entities.concretes.Language;
import kodlama.io.devs.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{
	private TechnologyRepository technologyRepository;
	private LanguageRepository languageRepository;
	
	@Autowired
	public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository) {
		this.technologyRepository = technologyRepository;
		this.languageRepository = languageRepository;
	}

	@Override
	public List<Technology> getAll() {
		return technologyRepository.findAll();
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
		Technology technology = new Technology();
		Language language = languageRepository.getLanguageById(createTechnologyRequest.getLanguge_id());
		
		if(technologyRepository.existsByName(createTechnologyRequest.getName())) {
			throw new Exception("Language technology has already exist");
		}
		else if(languageRepository.existsById(createTechnologyRequest.getLanguge_id())) {
			technology.setName(createTechnologyRequest.getName());
			technology.setLanguage(language);
			this.technologyRepository.save(technology);
		}
		else{
			throw new Exception("Programming Language id not found.");		
		}
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
		Technology technology = technologyRepository.getTecnologyById(deleteTechnologyRequest.getId());
		if(technologyRepository.existsById(deleteTechnologyRequest.getId()) && technologyRepository.existsByName(deleteTechnologyRequest.getName())) {
			this.technologyRepository.delete(technology);
		}
		else {
			throw new Exception("Language technology not found.");
		}
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest, Integer id) throws Exception {
		if(technologyRepository.existsById(id)) {
			Technology updateTechnology = technologyRepository.getTecnologyById(id);
			updateTechnology.setName(updateTechnology.getName());
			this.technologyRepository.save(updateTechnology);
		}
		else {
			throw new Exception("Language technology has been not found.");
		}
	}
}
