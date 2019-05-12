import java.util.List;

class Calculator {

    static double calculateExpectedValue(List<Packet> packets){
        double intervalsSum;
        int amount = packets.size();

        intervalsSum = packets.stream().mapToDouble(Packet::getInterval).sum();

        return intervalsSum/amount;
    }

    static double calculateVariation(List<Packet> packets){
        double expectedValue = calculateExpectedValue(packets);
        int amount = packets.size();

        double summedDifferences = 0;

        for (Packet packet : packets) {
            summedDifferences += Math.pow(packet.getInterval() - expectedValue, 2);
        }

        return summedDifferences / amount;
    }
}

