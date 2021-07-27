public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 5; i >= 0; i--) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
