package kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.LanguageService;
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
	public List<Language> getAll() {
		return languageRepository.getAll();
	}

	@Override
	public Language getById(int id) throws Exception {
		return languageRepository.getById(id);
	}

	@Override
	public void add(Language language) throws Exception {
		if(language.getName().isEmpty()) {
			throw new Exception("Programlama dili ismi boş bırakılamaz.");
		}
		for (Language language1 : getAll()) {
			if(language1.getId() == language.getId()){
				throw new Exception("Programlama dili isimleri tekrar edemez.");
			}
		}
		
		languageRepository.add(language);
	}

	@Override
	public void delete(int id) throws Exception {
		if(languageRepository.getById(id) == null) {
			throw new Exception("Bu programlama dili sistrmde kayıtlı değil.");
		}
		languageRepository.delete(id);
	}

	@Override
	public void update(Language language, int id) throws Exception {
		if(languageRepository.getById(id) == null) {
			throw new Exception("Bu programlama dili sistrmde kayıtlı değil.");
		}
		languageRepository.update(language, id);
	}

}
