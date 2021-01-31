package Project1.src;

public class Book {

	private String number; //a 5-digit serial number unique to the book
  	private String name;
	private boolean checkedOut;
	private Date datePublished;

	public Book(String number, String name, Date datePublished) {
		// this.number = number;
		this.name = name;
		this.checkedOut = false;
		this.datePublished = datePublished;
	}

	public String isAvailable(){
		if(this.checkedOut){
			return "is not available";
		} else return "is available";
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return this.number;
	}

	public void setCheckout(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.number.equals(((Book)obj).number)){
			return true;
		} else return false;
	}

	@Override
	public String toString() {
		return ("Book#"+number+"::"+name+"::"+datePublished.toString()+"::"+isAvailable());
	}
}
