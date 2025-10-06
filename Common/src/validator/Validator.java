/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;
/**
 *
 * @author Saki
 */
public class Validator {

    private static final String NAME_REGEX = "^[a-zA-ZčČćĆšŠđĐžŽ ]+$";
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String NUMBER_REGEX = "^\\d+(\\.\\d+)?$";
    private static final String DATE_REGEX = "^(\\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";

    public static boolean isValidDate(String date) {
        return date.matches(DATE_REGEX);
    }

    public static boolean isValidName(String name) {
        return name != null && name.matches(NAME_REGEX);
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= MIN_PASSWORD_LENGTH;
    }

    public static boolean isValidNumber(String number) {
        return number != null && number.matches(NUMBER_REGEX);
    }
    
}