package oopWithNLayeredApp.dataAccess;

import oopWithNLayeredApp.entities.Category;
import oopWithNLayeredApp.entities.Course;
import oopWithNLayeredApp.entities.Instructor;

public interface BaseDao {
	void add(Course course);
	void add(Category category);
	void add(Instructor instractor);
}
