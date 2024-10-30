import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private static final String invalidOfLength = "this document number is less than 15 characters";
    private static final String invalidOfStart = "this document does not start with: docnum or kontract.";
    private static final String invalidOfSpace = "this document must not contain spaces";
    private static final String validNumber = "this number of document is valid";
    private static final Pattern patternStartWith = Pattern.compile("^(docnum|kontract)");
    private static final Pattern patternContainSpaces = Pattern.compile("\\s");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> listOfDocuments = new HashMap<>();

        while (true) {
            String numberOfDocuments = scanner.nextLine();
            if (numberOfDocuments.equals("0")) {
                break;

            }

            if (numberOfDocuments.length() != 15) {
                listOfDocuments.put(numberOfDocuments, invalidOfLength);

            } else if (!patternStartWith.matcher(numberOfDocuments).find()) {
                listOfDocuments.put(numberOfDocuments, invalidOfStart);

            } else if (patternContainSpaces.matcher(numberOfDocuments).find()) {
                listOfDocuments.put(numberOfDocuments, invalidOfSpace);
            } else {
                listOfDocuments.put(numberOfDocuments, validNumber);
            }
        }

        scanner.close();

        for (var pair : listOfDocuments.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " " + value);
        }

    }
}
