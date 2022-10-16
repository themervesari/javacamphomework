package YoutubeDemo;

import credits.MilitaryCreditManager;
import credits.TeacherCreditManager;

public class Main {

	public static void main(String[] args) {
		CreditManager creditManager = new CreditManager();
		creditManager.Calculate();
		creditManager.Save();
		
		Customer customer = new Customer(); // Örneğini oluşturmak. instance creation
		customer.setId(1);
		customer.setFirstName("Merve"); 
		customer.setLastName("Sarı");
		customer.setNationalIdentity("123456");
		customer.setCity("Ankara");
		
		CustomerManager customerManager = new CustomerManager(customer, new TeacherCreditManager());
		customerManager.Save();
		customerManager.Delete();
		
		Company company = new Company();
		company.taxNumber = "10000";
		company.companyName = "Arçelik";
		company.id = 100;
		
		Customer c1 = new Customer();
		Customer c2 = new Company();
		
		CustomerManager customerManager2 = new CustomerManager(customer, new MilitaryCreditManager());
		customerManager2.GiveCredit();
		
	}

}
