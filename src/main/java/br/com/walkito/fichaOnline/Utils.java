package br.com.walkito.fichaOnline;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static boolean emailValidator(String email){
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
