import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        while (true) {

            //check email
            System.out.println("\n---------------------------------");
            System.out.println("Nhập 'q' để thoát chương trình");
            System.out.println("Nhập vào email: ");
            String email = sc.nextLine();
            if (email.equalsIgnoreCase("q")) {
                System.exit(0);
            } else {
                Email.checkEmail(email);
            }

            //check tên
            System.out.println("\n---------------------------------");
            System.out.println("Nhập 'q' để thoát chương trình");
            System.out.println("Nhập vào tên bất kỳ: ");
            String name = sc.nextLine();
           
            if (email.equalsIgnoreCase("q")) {
                System.exit(0);
            } else {
                StringStandard.getStringStandard(name);
            }

            
        }
       
            
    }
}
