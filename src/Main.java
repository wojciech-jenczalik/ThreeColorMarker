import java.util.ArrayList;
import java.util.List;

public class Main {

    static final int HUNDRED = 100;
    static final int THOUSAND = 1000;
    static final int MILLION = 1000000;

    static float cir = 2* HUNDRED * THOUSAND /*bps*/;
    static int cbs = 20* THOUSAND /*bits*/;
    static int ebs = cbs;

    static int packetsAmount = 800;
    static int defaultPacketSize = 17000;

    static List<Packet> inputStream = new ArrayList<>();

    public static void main(String[] args) {
        TokenBuckets buckets = new TokenBuckets();
        Marker marker = new Marker(buckets);
        InputHandler handler = new InputHandler(marker);

        System.out.println("Polecenia: poisson, drukuj, oblicz, zapisz.");

        Thread handlerThread = new Thread(handler);
        Thread bucketsThread = new Thread(buckets);

        handlerThread.start();
        bucketsThread.start();
    }
}
