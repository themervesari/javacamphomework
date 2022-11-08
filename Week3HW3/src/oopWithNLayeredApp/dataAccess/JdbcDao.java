package oopWithNLayeredApp.dataAccess;

import oopWithNLayeredApp.entities.Category;
import oopWithNLayeredApp.entities.Course;
import oopWithNLayeredApp.entities.Instructor;

public class JdbcDao implements BaseDao{

	@Override
	public void add(Course course) {
		System.out.println(course.getName() + " Jdbc ile veritabanına eklendi." );
	}

	@Override
	public void add(Category category) {
		System.out.println(category.getName() + " Jdbc ile veritabanına eklendi." );
	}

	@Override
	public void add(Instructor instractor) {
		System.out.println(instractor.getFirstName() + " " + instractor.getLasName() + " Jdbc ile veritabanına eklendi." );
	}

}
