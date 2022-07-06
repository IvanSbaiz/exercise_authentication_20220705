package utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
  A - almeno 8 caratteri
  B - almeno un carattere maiuscolo
  C - almeno un carattere speciale [#?!@$%^&*-]

  A && B && C

  !(A || B || C)

   ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[#?!@$%^&*-]).{8,20}$
   ^(?=(.{0,7}|[^0-9]*|[^A-Z]*|[^a-z]*|[a-zA-Z0-9]*))$
 */
public class PasswordValidator {

  private final String passwordRegex = "(\\w|[#?!@$%^&*-])";

  public boolean validate(String password) {

    Pattern pattern = Pattern.compile(passwordRegex);
    Matcher matcher = pattern.matcher(password);
    return matcher.matches();
  }

}
