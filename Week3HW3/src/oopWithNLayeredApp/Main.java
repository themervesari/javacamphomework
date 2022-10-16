package oopWithNLayeredApp;

import oopWithNLayeredApp.business.CategoryManager;
import oopWithNLayeredApp.business.CourseManager;
import oopWithNLayeredApp.business.InstructorManager;
import oopWithNLayeredApp.core.logging.DatabaseLogger;
import oopWithNLayeredApp.core.logging.FileLogger;
import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.core.logging.MailLogger;
import oopWithNLayeredApp.dataAccess.HibernateDao;
import oopWithNLayeredApp.dataAccess.JdbcDao;
import oopWithNLayeredApp.entities.Category;
import oopWithNLayeredApp.entities.Course;
import oopWithNLayeredApp.entities.Instructor;

public class Main {

	public static void main(String[] args) throws Exception{
		Logger[] loggers = {new DatabaseLogger(), new FileLogger(), new MailLogger()};
		
		Category category1 = new Category(4, "Cloud");
        CategoryManager categoryManager = new CategoryManager(new HibernateDao(), loggers);
        categoryManager.add(category1);
        
        System.out.println("-----------------------------------------");
        
        Course course1 = new Course(3, "HTML", 0);
        CourseManager courseManager = new CourseManager(new JdbcDao(), loggers);
        courseManager.add(course1);
        
        System.out.println("-----------------------------------------");
        
        Instructor instructor = new Instructor(1, "Engin", "Demiroğ");
        InstructorManager instructorManager = new InstructorManager(new HibernateDao(), loggers);
        instructorManager.add(instructor);
	}

}
