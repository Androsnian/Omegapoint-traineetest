import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final ArrayList<Number> identificationNumbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner idScanner = new Scanner(System.in);
        Scanner amountOfValidationsScanner = new Scanner(System.in);
        System.out.println("Enter the amount of numbers to be validated: ");
        int amountOfValidations = amountOfValidationsScanner.nextInt();
        for(int i = 0; i < amountOfValidations; i++) {
            System.out.println("Enter an identification number: ");
            String idNumber = idScanner.nextLine();
            Number number = new Number(idNumber);
            validityCheckPreparation(number, idNumber);
        }
        numberValidityFeedback();
    }

    private static void validityCheckPreparation (Number number, String id) {
        // If number has - or + remove them
        id = id.trim().replace("-", "").replace("+", "");
        // Remove century and check number
        if (id.length() == 12) {
            id = id.substring(2, 12);
        } else if (id.length() == 10) {
            id = id.substring(0, 10);
        }
        validityCheck(number, id);
    }
    private static void validityCheck(Number number, String id){
        int result = 0;
        // Retrieve/remove check number
        int checkNumber = Integer.parseInt(id.substring(9, 10));
        String idWithoutCheckNumber = id.substring(0, 9);
        // Calculate check number
        for (int i = 0, len = idWithoutCheckNumber.length(); i < len; i++) {
            int tmp = Integer.parseInt(idWithoutCheckNumber.substring(i, i + 1));

            if ((i % 2) == 0) {
                tmp = (tmp * 2);
            }
            if (tmp > 9) {
                result += (1 + (tmp % 10));
            } else {
                result += tmp;
            }

        }
        if(((checkNumber + result) % 10) == 0 ) {
            number.verifyNumber();
        }
        if(Integer.parseInt(id.substring(2, 4), 10) < 13 && Integer.parseInt(id.substring(4, 6), 10) < 32) {
            number.verifyPersonalIdentityNumber();
        } else if(Integer.parseInt(id.substring(4, 6), 10) > 60) {
            number.verifyCoOrdinationNumber();
        } else {
            number.verifyOrganizationNumber();
        }
        identificationNumbers.add(number);
    }

    private static void numberValidityFeedback() {
        for(int i = 0; i < identificationNumbers.size(); i++) {
            System.out.println(identificationNumbers.get(i).toString());
        }
    }
}