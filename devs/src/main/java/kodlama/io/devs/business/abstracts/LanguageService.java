package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.entities.concretes.Language;

public interface LanguageService {
	List<Language> getAll();
	Language getById(int id) throws Exception;
	void add(Language language) throws Exception;
	void delete(int id) throws Exception;
	void update(Language language, int id) throws Exception;
}
