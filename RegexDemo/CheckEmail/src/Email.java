import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            ("[_a-zA-Z1-9]+(\\.[A-Za-z0-9]*)*@[A-Za-z0-9]+\\.[A-Za-z0-9]+(\\.[A-Za-z0-9]*)*"),
            Pattern.CASE_INSENSITIVE);

    public static void checkEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        if (matcher.matches()) {
            System.out.println(email + ": Email hợp lệ");
        } else {
            System.out.println(email + ": Email không hợp lệ");
        }
    }
}
