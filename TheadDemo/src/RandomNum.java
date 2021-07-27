import java.util.Random;

public class RandomNum extends Thread {
    private int count = 0;
    private boolean isStop = false;
    @Override
    public void run() {
        Random random = new Random();
        while(!isStop) {
            int num = random.nextInt(100);
            System.out.println(num);
            count++;
            try{
                Thread.sleep(1500);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("Số lần hiển thị số: " + count);
    }
    public void end(){
        isStop = true;
    }
}
