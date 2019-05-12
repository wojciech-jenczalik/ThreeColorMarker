import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

class FileGenerator {

    static void writeResults(Marker marker) throws FileNotFoundException {
        List<Packet> greenStream = marker.getGreenOutputStream();
        List<Packet> yellowStream = marker.getYellowOutputStream();
        List<Packet> redStream = marker.getRedOutputStream();

        writeResult(greenStream, "green");
        writeResult(yellowStream, "yellow");
        writeResult(redStream, "red");

        System.out.println("Wyniki zostały zapisane");
    }

    static void writeResult(List<Packet> stream, String filename) throws FileNotFoundException {
        PrintWriter pwInterval = new PrintWriter(new FileOutputStream(filename+".txt"));
        for (Packet packet : stream)
            pwInterval.println(packet.getInterval());
        pwInterval.close();

        PrintWriter pwIndex = new PrintWriter(new FileOutputStream(filename+"Indexes.txt"));
        for (Packet packet : stream)
            pwIndex.println(packet.getIndex());
        pwIndex.close();
    }
}
