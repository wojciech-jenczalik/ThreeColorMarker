class Packet {

    private double interval;
    private int size;
    private int index;
    private static int counter = 0;

    Packet(){
        this.interval = 0;
        this.size = Main.defaultPacketSize;
        this.index = counter++;
    }

    Packet(double interval, int size) {
        this.interval = interval;
        this.size = size;
        this.index = counter++;
    }

    @Override
    public String toString() {
        return "Packet{" +
                "interval=" + interval + " ms" +
                ", size=" + size + " bytes" +
                '}';
    }

    int getSize(){
        return size;
    }

    double getInterval(){
        return interval;
    }

    int getIndex(){
        return index;
    }
}
