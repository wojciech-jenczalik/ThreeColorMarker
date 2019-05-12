import java.io.IOException;

public class PoissonTrafficGenerator implements TrafficGenerator{

    private Marker marker;

    private float rateParameter = 1/40f;

    PoissonTrafficGenerator(Marker marker) {
        this.marker = marker;
    }

    @Override
    public synchronized void generate() throws InterruptedException, IOException {

        System.out.println("Rozpoczynam generację pakietów według procesu Poissona...");
        Packet firstPacket = new Packet();
        Main.inputStream.add(firstPacket);

        for(int i = 0; i <= Main.packetsAmount - 1; i++) {
            double interval = poissonProcess();
            Packet packet = new Packet(interval, Main.defaultPacketSize);
            Thread.sleep((long) interval);
            Main.inputStream.add(packet);
            notifyMarker(packet);
            System.out.write("\r".getBytes());
            System.out.print(i+1 + "/" + Main.packetsAmount);
        }
        System.out.println("\rPakiety zostały wygenerowane");
    }

    private float poissonProcess(){
        return (float) (-Math.log(1.0f - Math.random()) / rateParameter);
    }

    private void notifyMarker(Packet packet){
        marker.color(packet);
    }
}

