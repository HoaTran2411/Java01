import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    //bước 1: tạo hằng số, kiểu Pattern(mẫu, khuôn)
    // hằng số = Partern.compile(truyền vào regex, tham số 2) --> tham số 2 truyền Patern.Case-insensitive là k phân biệt chữ hoa chữ thường
    public static final Pattern MOBILE_PATTERN = Pattern.compile(("\\d{10}"), Pattern.CASE_INSENSITIVE);

    //tạo 1 method check sdt để lát gọi ra trong hàm main
    public static String validateMobile(String mobile) {
        //tạo đối tượng Matcher = tên hằng.matcher(cái cần check ví dụ email, sdt);
        Matcher matcher = MOBILE_PATTERN.matcher(mobile);
        //nếu mà matcher.find() Kiểm tra một chuỗi se có chứa một chuỗi con nào đó hay không
        //nếu chuỗi con tồn tại, trả về dữ liệu nhập vào, còn không thì ném ra ngoại lệ
        if (matcher.find()) {
            return mobile;
        } else {
            throw new RuntimeException("Số điện thoại không hợp lệ");
        }
    }
    //từ java 7 mới dùng dc regex
    //kiểm tra email
    public static final Pattern EMAIL_PATTERN = Pattern.compile(("^(.+)@(.+)$"), Pattern.CASE_INSENSITIVE);
    public static String validateEmail(String email){
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        if(matcher.find()){
            return email;
        } else {
            throw new RuntimeException("Email không hợp lệ");
        }
    }
}
