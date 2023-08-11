package cor.lan;

public class Main {
    public static void main(String[] args) {
        Countdown countdown = new Countdown();
        CountdownThread t1 = new CountdownThread(countdown);
        t1.setName("Thread");
        CountdownThread t2 = new CountdownThread(countdown);
        t1.setName("Thread2");

        t1.start();
        t2.start();
    }
}

class Countdown {

    private int i;
    public void doCountdown() {
        String color;

        switch(Thread.currentThread().getName()) {
            case "Thread":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        System.out.println(Thread.currentThread().getName());
        for (i = 10; i > 0; i--) {
            System.out.println(color + Thread.currentThread().getName() + ": i =" + i);
        }
    }
}

class CountdownThread extends Thread {
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    public void run() {
        threadCountdown.doCountdown();
    }
}