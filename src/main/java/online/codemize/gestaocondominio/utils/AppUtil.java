package online.codemize.gestaocondominio.utils;

public class AppUtil {

    public static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean isEmailValid(String email){
        return email.matches(AppUtil.EMAIL_REGEX);
    }

    public static boolean isEmailInvalid(String email){
        return !isEmailValid(email);
    }

}
