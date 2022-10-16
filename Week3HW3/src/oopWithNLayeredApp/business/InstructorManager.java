package oopWithNLayeredApp.business;

import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.dataAccess.BaseDao;
import oopWithNLayeredApp.entities.Instructor;

public class InstructorManager {
	private BaseDao baseDao;
	private Logger[] loggers;
	
	public InstructorManager(BaseDao baseDao, Logger[] loggers) {
		this.baseDao = baseDao;
		this.loggers = loggers;
	}
	
	public void add(Instructor instructor) throws Exception{
		baseDao.add(instructor);
		
		for (Logger logger : loggers) {
            logger.log(instructor.getFirstName() + " " + instructor.getLasName());
        }
	}
}
