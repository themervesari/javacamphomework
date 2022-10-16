package credits;

abstract class BaseCreditManager implements CreditManager{
	public abstract void Calculate();
	
	public void Save() {
		System.out.println("Kaydedildi");
	}
}
