package oopWithNLayeredApp.business;

import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.dataAccess.BaseDao;
import oopWithNLayeredApp.entities.Course;

public class CourseManager {
	private BaseDao baseDao;
	private Logger[] loggers;
	
	public CourseManager(BaseDao baseDao, Logger[] loggers) {
		this.baseDao = baseDao;
		this.loggers = loggers;
	}
	
	public void add(Course course) throws Exception{
		Course[] courses = {new Course(1, "Java", 10), new Course(2, "Javascript", 25)};
        for (Course c : courses) {
            if (course.getName() == c.getName()) {
                throw new Exception("Kurs ismi tekrar edemez.");
            } else if (course.getUnitPrice() < 0) {
                throw new Exception("Bir kursun fiyatı 0 dan küçük olamaz.");
            }
        }
        
        baseDao.add(course);
        
        for (Logger logger : loggers) {
			logger.log(course.getName());
		}      
	}
}
