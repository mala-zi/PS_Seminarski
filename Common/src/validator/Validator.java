/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

import domain.Cvecar;

/**
 *
 * @author Saki
 */
public class Validator {

    // Regex za validaciju imena (samo slova, bez brojeva ili specijalnih karaktera)
    private static final String NAME_REGEX= "^[a-zA-Z ]+$";
    private static final String USERNAME_REGEX="^[a-zA-Z0-9]+$";

    // Regex za validaciju lozinke (dužina najmanje 8 karaktera)
    private static final int MIN_PASSWORD_LENGTH = 8;

    // Regex za validaciju brojeva (samo cifre)
    private static final String NUMBER_REGEX = "^\\d+(\\.\\d+)?$";
  
    private static final String DATE_REGEX = "^(\\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";

    public static boolean isValidDate(String date) {

        return date.matches(DATE_REGEX);

    }

    public static boolean isValidUsername(String username){
        return username!=null && username.matches(USERNAME_REGEX);
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

    public static void validateCvecarAdd(Cvecar cvecar) throws IllegalArgumentException {
        if (!isValidName(cvecar.getIme())) {
            throw new IllegalArgumentException("Ime nije validno. Dozvoljena su samo slova.");
        }
        if (!isValidName(cvecar.getPrezime())) {
            throw new IllegalArgumentException("Prezime nije validno. Dozvoljena su samo slova.");
        }
        if (!isValidPassword(cvecar.getLozinka())) {
            throw new IllegalArgumentException("Lozinka mora imati najmanje " + MIN_PASSWORD_LENGTH + " karaktera.");
        }
        if (!isValidUsername(String.valueOf(cvecar.getKorisnickoIme()))) {
            throw new IllegalArgumentException("Los format korisnickog imena.");
        }
    }
    public static void validateCvecarChange(Cvecar cvecar) throws IllegalArgumentException {
        if (!isValidName(cvecar.getIme())) {
            throw new IllegalArgumentException("Ime nije validno. Dozvoljena su samo slova.");
        }
        if (!isValidName(cvecar.getPrezime())) {
            throw new IllegalArgumentException("Prezime nije validno. Dozvoljena su samo slova.");
        }
        if (!isValidUsername(String.valueOf(cvecar.getKorisnickoIme()))) {
            throw new IllegalArgumentException("Los format korisnickog imena.");
        }
    }
    
    public static void validateCvecarSign(Cvecar cvecar) throws IllegalArgumentException {
        
        if (!isValidPassword(cvecar.getLozinka())) {
            throw new IllegalArgumentException("Lozinka mora imati najmanje " + MIN_PASSWORD_LENGTH + " karaktera.");
        }
        if (!isValidUsername(String.valueOf(cvecar.getKorisnickoIme()))) {
            throw new IllegalArgumentException("Los format korisnickog imena.");
        }
    }
}
