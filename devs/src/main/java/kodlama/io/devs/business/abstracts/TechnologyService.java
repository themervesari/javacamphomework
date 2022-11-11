package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.devs.business.requests.technology.UpdateTechnologyRequest;
import kodlama.io.devs.entities.concretes.Technology;

public interface TechnologyService {
	List<Technology> getAll();
	void add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
	void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception;
	void update(UpdateTechnologyRequest updateTechnologyRequest, Integer id) throws Exception;
}
