package kodlama.io.devs.dataAcsess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.devs.dataAcsess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository{

	List<Language> languages;
	
	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(1, "C#"));
		languages.add(new Language(2, "Java"));
		languages.add(new Language(3, "Python"));
	}

	@Override
	public List<Language> getAll() {
		return languages;
	}

	@Override
	public Language getById(int id) throws Exception {
		for (Language language : languages) {
			if(language.getId() == id) {
				return language;
			}
		}throw new Exception("Yeni Kayıt Bulunamadı");
	}

	@Override
	public void add(Language language) throws Exception{
		languages.add(language);
	}

	@Override
	public void delete(int id) throws Exception {
		for (Language language : languages) {
			if(language.getId() == id) {
				languages.remove(id);
			}
		}throw new Exception("Kayıt Bulunamadı");
	}

	@Override
	public void update(Language language, int id) throws Exception{
		languages.set(language.getId(), language);
	}

}
