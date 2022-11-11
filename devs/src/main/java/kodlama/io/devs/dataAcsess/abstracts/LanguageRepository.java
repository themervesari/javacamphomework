package kodlama.io.devs.dataAcsess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.devs.entities.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer>{
	Language getLanguageById(Integer id);
	boolean existsByName(String name);
	boolean existsById(Integer id);
}
