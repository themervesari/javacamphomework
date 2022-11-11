package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.language.CreateLanguageRequest;
import kodlama.io.devs.business.requests.language.DeleteLanguageRequest;
import kodlama.io.devs.business.requests.language.UpdateLanguageRequest;
import kodlama.io.devs.business.responses.GetAllLanguagesResponse;
import kodlama.io.devs.entities.concretes.Language;

public interface LanguageService {
	List<GetAllLanguagesResponse> getAll();
	Language getById(int id) throws Exception;
	void add(CreateLanguageRequest createLanguageRequest) throws Exception;
	void delete(DeleteLanguageRequest deleteLanguageRequest ) throws Exception;
	void update(UpdateLanguageRequest updateLanguageRequest, Integer id) throws Exception;
}
