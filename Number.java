public class Number {

    private String idNumber;
    private boolean valid;
    private boolean coordinationNumber;
    private boolean organizationNumber;
    private boolean personalIdentityNumber;

    public Number(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdNumber(){
        return idNumber;
    }
    public String isValidNumber() {
        if(valid) {
            return "valid";
        } else {
            return "not valid";
        }
    }
    public void verifyNumber() {
        valid = true;
    }
    public void verifyCoordinationNumber() {
        coordinationNumber = true;
    }
    public void verifyOrganizationNumber() {
        organizationNumber = true;
    }
    public void verifyPersonalIdentityNumber() {
        personalIdentityNumber = true;
    }

    public String whatKindOfNumber() {
        if(coordinationNumber) {
            return " coordination number.";
        }
         else if(personalIdentityNumber) {
            return " personal identity number.";
        }
        else if(organizationNumber) {
            return " organizationnumber.";
        } else {
            return " not valid identification number.";
        }
    }

    @Override
    public String toString() {
        return "Number " + getIdNumber() + " is a " + isValidNumber() + whatKindOfNumber();
    }
}
