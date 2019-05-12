import java.util.ArrayList;
import java.util.List;

class Marker {

    private TokenBuckets buckets;

    private List<Packet> greenOutputStream = new ArrayList<>();
    private List<Packet> yellowOutputStream = new ArrayList<>();
    private List<Packet> redOutputStream = new ArrayList<>();

    Marker(TokenBuckets buckets){
        this.buckets = buckets;
    }

    void color(Packet packet){

        int bucketC = buckets.getTokenBucketC();
        int bucketE = buckets.getTokenBucketE();

        if(bucketC - packet.getSize() >= 0){
            greenOutputStream.add(packet);
            buckets.setTokenBucketC(bucketC - packet.getSize());
        }else if(bucketE - packet.getSize() >= 0){
            yellowOutputStream.add(packet);
            buckets.setTokenBucketE(bucketE - packet.getSize());
        }else{
            redOutputStream.add(packet);
        }
    }

    @Override
    public String toString() {
        return "greenOutputStream=" + greenOutputStream +
                ", \nyellowOutputStream=" + yellowOutputStream +
                ", \nredOutputStream=" + redOutputStream +
                '}';
    }

    List<Packet> getGreenOutputStream() {
        return greenOutputStream;
    }

    List<Packet> getYellowOutputStream() {
        return yellowOutputStream;
    }

    List<Packet> getRedOutputStream() {
        return redOutputStream;
    }
}
