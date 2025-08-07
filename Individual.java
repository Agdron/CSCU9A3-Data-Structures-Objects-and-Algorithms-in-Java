public class Individual {
    //Individual is a class which both Customer.java and Staff.java inherit attributes from
    protected String fullName;
    protected int idNumber;
    protected String email;

    public Individual(String fn, int rn, String em){
        /**
         * Constructor
         * @param fn Full Name
         * @param rn id Number
         * @param em Email
         */
        this.fullName = fn;
        this.idNumber = rn;
        this.email = em;
    }


    // gets and sets, this sets the attributed which will be inherited
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fn) {
        this.fullName = fn;
    }
    public int getIdNumber(){
        return idNumber;
    }
    public void setIdNumber(int rn) {
        this.idNumber = rn;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String em) {
        this.email = em;
    }
}
