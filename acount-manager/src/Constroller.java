import java.util.List;
import java.util.Scanner;

public class Constroller {
    Scanner sc = new Scanner(System.in);
    Repository repository = new Repository();
    List<User> usersList = repository.getData();

    // chọn mainMenu:
    public void chooseMainMenu() {
        while (true) {
            Menu.mainMenu();
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    login();
                    break;
                case 2:
                    createNewAccount();
                    break;
                case 0:
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    // đăng nhập:
    public void login() {
        Boolean isCheckUserName = false;
        long id;
        while (!isCheckUserName) {
            System.out.println("Vui lòng nhập username của bạn: ");
            String username = sc.nextLine();
            System.out.println("Vui lòng nhập password của bạn: ");
            String password = sc.nextLine();
            for (int i = 0; i < usersList.size(); i++) {
                if (usersList.get(i).getUsername().equals(username)) {
                    isCheckUserName = true;
                    id = usersList.get(i).getId();
                    if (usersList.get(i).getPassword().equals(password)) {
                        System.out.println("Chào mừng " + username + ", bạn có thể thực hiện các công việc sau:");
                        chooseloginSucessMenu(id);
                    } else {
                        System.out.println("Mật khẩu không đúng!!!!");
                        chooseloginFailMenu(id);
                    }
                    break;
                }
            }

            if (!isCheckUserName) {
                System.out.println("Kiểm tra lại username!!!!");
            }
        }
    }

    // login thành công:
    public void chooseloginSucessMenu(long id) {
        Menu.loginSucessMenu();
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1: // thay đổi username
                changeUsername(id);
                break;
            case 2: // thay đổi email:
                changeEmail(id);
                break;
            case 3: // thay đổi mật khẩu
                changePassword(id);
                break;
            case 4: // Đăng xuất (Sau khi đăng xuất quay về mục yêu cầu đăng nhập hoặc đăng xuất)
                chooseMainMenu();
                break;
            case 0: // thoát chương trình
                System.exit(0);
            default:
                break;
        }
    }

    // nhập sai password:
    public void chooseloginFailMenu(long id) {
        Menu.loginFailMenu();
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1: // đăng nhập lại
                login();
                break;
            case 2: // quên mật khẩu
                forgotPassword(id);
                break;
            default:
                break;
        }

    }

    public void changePassword(long id) {
        // Thay đổi mật khẩu
        System.out.println("Nhập mật khẩu mới: ");
        String password = Validate.validatePassword(sc.nextLine());
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getId() == id) {
                usersList.get(i).setPassword(password);
                System.out.println("Thông tin của bạn sau khi đã update: ");
                System.out.println(usersList.get(i));
            }
        }
    }

    public void changeUsername(long id) {
        // Thay đổi username
        Boolean isCheck = false;
        while (!isCheck) {
            System.out.println("Nhập tên đăng nhập mới: ");
            String username = sc.nextLine();
            for (int i = 0; i < usersList.size(); i++) {
                if (usersList.get(i).getId() == id) {
                    for (int j = 0; j < usersList.size(); j++) {
                        if (usersList.get(j).getUsername().equals(username)) {
                            System.out.println("Tên đăng nhập đã tồn tại trong hệ thống, vui lòng chọn tên khác!!!");
                            isCheck = false;
                            break;
                        } else {
                            isCheck = true;
                        }
                    }
                    if (isCheck) {
                        usersList.get(i).setUsername(username);
                        System.out.println("Thông tin của bạn sau khi đã update: ");
                        System.out.println(usersList.get(i));
                    }
                }
            }
        }

    }

    public void changeEmail(long id) {
        // Thay đổi email
        Boolean isCheck = false;
        while (!isCheck) {
            System.out.println("Nhập email mới: ");
            String email = Validate.validateEmail(sc.nextLine());
            for (int i = 0; i < usersList.size(); i++) {
                if (usersList.get(i).getId() == id) {
                    for (int j = 0; j < usersList.size(); j++) {
                        if (usersList.get(j).getEmail().equalsIgnoreCase(email)) {
                            System.out.println("Email đã tồn tại trong hệ thống, vui lòng chọn email khác!!!");
                            isCheck = false;
                            break;
                        } else {
                            isCheck = true;
                        }
                    }
                    if (isCheck) {
                        usersList.get(i).setEmail(email);
                        System.out.println("Thông tin của bạn sau khi đã update: ");
                        System.out.println(usersList.get(i));
                    }
                }
            }
        }
    }

    public void forgotPassword(long id) {
        // Quên mật khẩu
        System.out.println("Nhập email của bạn: ");
        String email = sc.nextLine();
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getId() == id) {
                if (usersList.get(i).getEmail().equalsIgnoreCase(email)) {
                    System.out.println("Nhập mật khẩu mới của bạn: ");
                    String password = Validate.validatePassword(sc.nextLine());
                    usersList.get(i).setPassword(password);
                    System.out.println("Thông tin của bạn sau khi đã update: ");
                    System.out.println(usersList.get(i));
                } else {
                    System.out.println("Tài khoản không tồn tại!!!");

                }
            }
        }

    }

    public void createNewAccount() {
        String name, email, password;
        // Tạo tài khoản mới
        Boolean isCheck = false;
        while (!isCheck) {
            System.out.println("Nhập tên người dùng: ");
            name = sc.nextLine();
            System.out.println("Nhập email: ");
            email = Validate.validateEmail(sc.nextLine());
            System.out.println("Nhập password: ");
            password = Validate.validatePassword(sc.nextLine());

            // check xem email tồn tại trong list hay chưa:
            for (int i = 0; i < usersList.size(); i++) {
                if (usersList.get(i).getUsername().equalsIgnoreCase(name)) {
                    System.out.println("Tên người dùng đã tồn tại, vui lòng nhập tên khác!!");
                    isCheck = false;
                    break;
                } else if (usersList.get(i).getEmail().equalsIgnoreCase(email)) {
                    System.out.println("Email đã tồn tại, vui lòng nhập email khác!!");
                    isCheck = false;
                    break;
                } else {
                    isCheck = true;
                }
            }

            if (isCheck) {
                System.out.println("Tạo tài khoản thành công: ");
                long id = IdGenerate.getId(usersList);
                User newUser = new User(id, name, email, password);
                usersList.add(newUser);
                System.out.println("Thông tin tài khoản: ");
                System.out.println(newUser.toString());
            }
        }

    }

}
