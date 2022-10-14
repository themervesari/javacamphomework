package interfaces;

public class CustomerManager {
	
	//ICustomerDal customerDal = new OracleCustomerDal(); ->1.yöntem
	
	private ICustomerDal customerDal;
	
	public CustomerManager(ICustomerDal customerDal) {
		this.customerDal = customerDal;
	}
	
	public void add() {
		//iş kodları yazılır.
		customerDal.add();
	}
}
