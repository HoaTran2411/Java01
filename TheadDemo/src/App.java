import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // cách tạo luồng trong java, kế thừa class thread hoặc implement interface
        // thread
        // tạo đối tượng Thread extends
        // TheadDemo demo = new TheadDemo();
        // demo.start(); // luồng phụ được chạy
        // demo.run(); //gọi run() thì sẽ là gọi phương thức bình thường, nó sẽ vẫn chạy
        // trên luồng chính
        // demo.start(); nếu luồng đã dc gọi 1 lần, sẽ k thể gọi lần 2, sẽ tạo exception

        // tạo đối tượng với thread runnable
        // RunnableDemo demo2 = new RunnableDemo();
        // Thread thread = new Thread(demo2); // k thể gọi trước tiếp demo2.start(),
        // phải thông qua Thread truyền tham số
        // // demo2
        // thread.start();

        // sleep: để tạm ngừng 1 thread trong 1 thời gian nhất định, phải dùng try catch

        // TheadDemo demo1 = new TheadDemo();
        // System.out.println(demo1.getId() + " - " + demo1.getName());
        // demo1.start();
        // //demo1.join(); //join dùng để đợi demo1 hoàn thành mới nhảy sang demo2 và 3

        // TheadDemo demo2 = new TheadDemo();
        // System.out.println(demo2.getId() + " - " + demo2.getName());
        // demo2.start();

        // TheadDemo demo3 = new TheadDemo();
        // System.out.println(demo3.getId() + " - " + demo3.getName());
        // demo3.start();

        // RunnableDemo demo1 = new RunnableDemo();
        // Thread thread1 = new Thread(demo1);
        // thread1.start();
        // thread1.interrupt();
        // thread1.join();
        // //join k truyền tham số thì sẽ chạy hết thread1
        // //nếu truyền tham số, thì sau 1000 mls nó sẽ chạy sang demo 2 và demo3 sẽ
        // chạy luôn

        // RunnableDemo demo2 = new RunnableDemo();
        // Thread thread2 = new Thread(demo2);
        // thread2.start();

        // RunnableDemo demo3 = new RunnableDemo();
        // Thread thread3 = new Thread(demo3);
        // thread3.start();

        RandomNum demo = new RandomNum();
        demo.start();
        System.out.println("Ấn phím bất kỳ để dừng chương trình");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        demo.end();
    }

}
