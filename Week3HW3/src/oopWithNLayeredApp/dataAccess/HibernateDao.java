package oopWithNLayeredApp.dataAccess;

import oopWithNLayeredApp.entities.Category;
import oopWithNLayeredApp.entities.Course;
import oopWithNLayeredApp.entities.Instructor;

public class HibernateDao implements BaseDao{

	@Override
	public void add(Course course) {
		System.out.println(course.getName() + " Hibernate ile veritabanına eklendi." );
	}

	@Override
	public void add(Category category) {
		System.out.println(category.getName() + " Hibernate ile veritabanına eklendi." );
	}

	@Override
	public void add(Instructor instractor) {
		System.out.println(instractor.getFirstName() + " " + instractor.getLasName() + " Hibernate ile veritabanına eklendi." );
	}

}
