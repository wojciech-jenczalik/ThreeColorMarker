import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class InputHandler implements Runnable{

    private Scanner scanner;
    private String input;

    private TrafficGenerator poisson;
    private Marker marker;

    InputHandler(Marker marker) {
        this.scanner = new Scanner(System.in);
        this.marker = marker;
        this.poisson = new PoissonTrafficGenerator(marker);
    }

    @Override
    public void run() {
        while (true) {
            input = scanner.nextLine();

            switch (input){
                case "poisson":
                    try {
                        poisson.generate();
                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case "drukuj":
                    System.out.println(marker);
                    break;

                case "zapisz":
                    try {
                        FileGenerator.writeResults(marker);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;

                case "oblicz":
                    double inputMean = Calculator.calculateExpectedValue(Main.inputStream);
                    double inputVariation = Calculator.calculateVariation(Main.inputStream);

                    double greenMean = Calculator.calculateExpectedValue(marker.getGreenOutputStream());
                    double greenVariation = Calculator.calculateVariation(marker.getGreenOutputStream());

                    double yellowMean = Calculator.calculateExpectedValue(marker.getYellowOutputStream());
                    double yellowVariation = Calculator.calculateVariation(marker.getYellowOutputStream());

                    double redMean = Calculator.calculateExpectedValue(marker.getRedOutputStream());
                    double redVariation = Calculator.calculateVariation(marker.getRedOutputStream());

                    System.out.println("Średnia wejściowych pakietów: " + inputMean);
                    System.out.println("Średnia zielonych pakietów: " + greenMean);
                    System.out.println("Średnia żółtych pakietów: " + yellowMean);
                    System.out.println("Średnia czerwonych pakietów: " + redMean);
                    System.out.println("\nWariancja wejściowych pakietów: " + inputVariation);
                    System.out.println("Wariancja zielonych pakietów: " + greenVariation);
                    System.out.println("Wariancja żółtych pakietów: " + yellowVariation);
                    System.out.println("Wariancja czerwonych pakietów: " + redVariation);
                    break;

                default:
                    System.out.println("Zły input.");
            }
        }
    }
}
