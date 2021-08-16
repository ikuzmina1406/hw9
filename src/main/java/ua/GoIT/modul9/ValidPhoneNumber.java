package ua.GoIT.modul9;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPhoneNumber {


    private static Pattern VALID_PHONE_NUMBER =
          //  Pattern.compile("^'('{1}[0-9]{3}')'{1}\\s[0-9]{3}-{1}[0-9]{2}-{1}[0-9]{2}$");
    Pattern.compile("^\\(\\d{3}\\)\\s{1}\\d{3}-\\d{4}$");
    private static Pattern VALID_PHONE_NUMBER2 =
            Pattern.compile("^\\d{3}-\\d{3}-\\d{4}$");
    public static boolean isValidPhoneNumber(String s) {

        Matcher m = VALID_PHONE_NUMBER.matcher(s);
        boolean result = m.matches();
        if (result) {
            return result;
        }
        else {
            m = VALID_PHONE_NUMBER2.matcher(s);
            return m.matches();
        }
    }
        public static void main (String[]args) throws IOException {
            File file = new File("file.txt");
           // System.out.println(file.createNewFile());
            InputStream inputStream = new FileInputStream(file);
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNext()) {
                String phoneNumber = scanner.nextLine();

                if(ValidPhoneNumber.isValidPhoneNumber(phoneNumber)){
                    System.out.println(phoneNumber);
                }
            }
            scanner.close();
            inputStream.close();
        }
        }
