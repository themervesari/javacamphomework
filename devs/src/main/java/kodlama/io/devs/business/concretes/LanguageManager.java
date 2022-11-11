package kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.business.requests.language.CreateLanguageRequest;
import kodlama.io.devs.business.requests.language.DeleteLanguageRequest;
import kodlama.io.devs.business.requests.language.UpdateLanguageRequest;
import kodlama.io.devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.devs.dataAcsess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{

	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> languagesResponse = new ArrayList<GetAllLanguagesResponse>();
		for (Language language : languages) {
			GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			languagesResponse.add(responseItem);
		}
		return languagesResponse;
	}

	@Override
	public Language getById(int id) throws Exception {
		if(languageRepository.existsById(id)) {
			return languageRepository.getLanguageById(id);
		}
		throw new Exception("Language id not found") ;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
		Language language = new Language();
		if(languageRepository.existsByName(createLanguageRequest.getName())) {
			throw new Exception("Language has already exist");
		}else if(createLanguageRequest.getName() == null) {
			throw new Exception("Language can not be empty.");
		}
		language.setName(createLanguageRequest.getName());
		this.languageRepository.save(language);
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) throws Exception {
		Language language = languageRepository.getLanguageById(deleteLanguageRequest.getId());
		if(languageRepository.existsById(deleteLanguageRequest.getId()) && languageRepository.existsByName(deleteLanguageRequest.getName())) {
			this.languageRepository.delete(language);
		}
		else {
			throw new Exception("Language has been not found.");
		}
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest, Integer id) throws Exception {
		if(languageRepository.existsById(id)) {
			Language updateLanguage = languageRepository.getLanguageById(id);
			updateLanguage.setName(updateLanguageRequest.getName());
			this.languageRepository.save(updateLanguage);
		}
		else {
			throw new Exception("Language has been not found.");
		}
	}



}
