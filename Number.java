public class Number {

    private String idNumber;
    private boolean valid;
    private boolean coOrdinationNumber;
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
    public void verifyCoOrdinationNumber() {
        coOrdinationNumber = true;
    }
    public void verifyOrganizationNumber() {
        organizationNumber = true;
    }
    public void verifyPersonalIdentityNumber() {
        personalIdentityNumber = true;
    }

    public String whatKindOfNumber() {
        if(coOrdinationNumber) {
            return " co-ordinationnumber.";
        }
         else if(personalIdentityNumber) {
            return " personal identitynumber.";
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