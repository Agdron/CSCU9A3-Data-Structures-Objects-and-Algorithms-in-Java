public class Seller extends Staff {

    protected int salesTarget; //this is the value of the target for sales
    protected Staff supervisor; //this calls the Staff class to set a supervisor for the seller

    public Seller(String fn, int rn, String em, String c, String ws, int st, Staff s) {
        /**
         * Constructor
         * @param fn Full Name
         * @param rn id Number
         * @param em Email
         * @param c Contract date
         * @param ws Work shift
         * @param st Sales Target
         * @param s Supervisor
         */
        super(fn, rn, em, c, ws); //Calls to the Staff class which then calls the Individual class in order to reduce code replication

        this.salesTarget = st;
        this.supervisor = s;
    }

    //Gets and Sets

    public double getSalesTarget() {
        return salesTarget;
    }
    public void setSalesTarget(int st) {
        this.salesTarget = st;
    }
    public Staff getSupervisor() {
        return supervisor;
    }
    public void setSupervisor(Staff s) {
        this.supervisor = s;
    }


    /**
     * Get a description of this class as a String
     */
    public String toString(double salesTarget, Staff supervisor){
        return "Seller - Name: " + fullName + "- Sales Target: " + salesTarget + "- Supervisor: " + supervisor;
    }
}
