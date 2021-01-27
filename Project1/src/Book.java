package Project1.src;

public class Book {
  private String number; //a 5-digit serial number unique to the book
  private String name;
  private boolean checkedOut;
  private Date datePublished;

  public Book(String number, String name, Date datePublished){
    this.number = number;
    this.name = name;
    this.checkedOut = false;
    this.datePublished = datePublished;
  }
  @Override
  public boolean equals(Object obj){
     
  }

  @Override
  public String toString() {}
}
