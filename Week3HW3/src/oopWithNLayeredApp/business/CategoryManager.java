package oopWithNLayeredApp.business;

import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.dataAccess.BaseDao;
import oopWithNLayeredApp.entities.Category;

public class CategoryManager {
	private BaseDao baseDao;
	private Logger[] loggers;
	
	public CategoryManager(BaseDao baseDao, Logger[] loggers) {
		this.baseDao = baseDao;
		this.loggers = loggers;
	}
	
	public void add(Category category) throws Exception{
		Category[] categories = {new Category(1, "Backend"), new Category(2, "Frontend"), new Category(3, "Mobile")};
        for (Category c : categories) {
            if (category.getName() == c.getName()) {
                throw new Exception("Kategori ismi tekrar edemez.");
            }
        }
        
        baseDao.add(category);
        
        for (Logger logger : loggers) {
            logger.log(category.getName());
        }
	}	
}
