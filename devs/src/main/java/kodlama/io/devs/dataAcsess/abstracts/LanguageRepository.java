package kodlama.io.devs.dataAcsess.abstracts;

import java.util.List;

import kodlama.io.devs.entities.concretes.Language;

public interface LanguageRepository {
	
	List<Language> getAll();
	Language getById(int id) throws Exception;
	void add(Language language) throws Exception;
	void delete(int id) throws Exception;
	void update(Language language, int id) throws Exception;
}
