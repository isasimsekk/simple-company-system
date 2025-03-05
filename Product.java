//İsa ŞİMŞEK 150122038
import java.util.Calendar;
public class Product {
	private String productName;
	private Calendar saleDate;
	private double price;
	
	public Product(String sName, Calendar sDate, double price) {
		setProductName(sName);
		this.saleDate = sDate;
		setPrice(price);
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		try {
			if(productName.length() < 3) {
				throw new Exception();
			}
				this.productName = productName;
		}
		catch(Exception e) {
			System.out.println("the product name is too short!!!!!");
			System.exit(1);
		}
	}

	public Calendar getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Calendar saleDate) {
		this.saleDate = saleDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		try {
			if (price < 1)
				throw new Exception();
				this.price = price;
		} 
		catch (Exception e) {
			System.out.println("price must be a positive value!!!!");
			System.exit(1);
		}
	}
	
	public String toString () {
		return "Product [productName="+productName+", transactionDate="+Test.clndrToString(saleDate)+", price="+price+"]";
	}
	
}
