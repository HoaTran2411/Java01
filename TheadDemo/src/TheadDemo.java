public class TheadDemo extends Thread {
    // Thead kế thừa runable, duy nhất 1 phương thức
    // @Override
    // public void run() {
    // try {
    // // for (int i = 0; i < 5; i++) {
    // // System.out.println("Create thread by extend Thread class");
    // // Thread.sleep(1500);
    // for (int i = 10; i >= 0; i--) {
    // System.out.println(i);
    // // if (i == 0) {
    // // System.out.println("Chúc mừng năm mới!");
    // // } //có thể dùng ở đây
    // Thread.sleep(1500);
    // }
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }

    // //sau khi phần nội dung trong try catch chạy xong thì câu lệnh dưới đây mới
    // dc thực hiện
    // //vì vậy k cần câu điều kiện if i==0 trong vòng lặp
    // System.out.println("Chúc mừng năm mới!!!");
    // }
    @Override
    public void run() {
        System.out.println("Create thread by extend Thread class");
    }
}
