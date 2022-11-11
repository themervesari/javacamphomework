package kodlama.io.devs.dataAcsess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.devs.entities.concretes.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer>{
	Technology getTecnologyById(Integer id);
	boolean existsByName(String name);
}
