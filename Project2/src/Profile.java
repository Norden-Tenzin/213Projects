package Project2.src;

public class Profile {
   private String name;
   private String department;
   private Date dateHired;

   public Profile(String name, String department, Date dateHired) {
      this.name = name;
      this.department = department;
      this.dateHired = dateHired;
   }

   public String getName() {
      return this.name;
   }

   public String getDepartment() {
      return this.department;
   }

   public Date getDateHired() {
      return this.dateHired;
   }

   @Override
   public String toString() { //Doe,Jane::CS::7/1/2020
       return name + "::" + department + "::" + dateHired.toString();
   }


   @Override
   public boolean equals(Object obj) { 
       int dateComp;
       if(obj instanceof Profile){
           Profile prof = (Profile) obj;
           boolean equalName = prof.getName().equals(this.name);
           boolean equalDepartment = prof.getDepartment().equals(this.department);
           dateComp = prof.getDateHired().compareTo(this.dateHired);
           boolean equalDate = (dateComp == 0);
           return (equalName && equalDepartment && equalDate);
       }
       return false;
   }


}
