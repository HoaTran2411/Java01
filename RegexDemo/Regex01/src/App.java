import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Nhập số dt: ");
        // String mobile = Validate.validateMobile(sc.nextLine());
        // System.out.println(mobile);

        System.out.println("Nhập email: ");
        String email = Validate.validateEmail(sc.nextLine());
        System.out.println(email);
    }
}
