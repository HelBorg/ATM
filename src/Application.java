import java.util.*;

public class Application {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String line;
            System.out.println(" Write down the sum you want to change: ");
            line = in.nextLine();
            int sum = Integer.parseInt(line);
            if (sum < 0){
                throw new NumberFormatException(" Sum is less than zero ");
            } else if (sum == 0){
                System.out.println(" Sum is equal 0");
                System.exit(0);
            }
            System.out.println(" Write down notes for exchange in one line: ");
            line = in.nextLine();

            String[] notesStrings = line.split(" ");
            int[] notes0 = Arrays.stream(notesStrings)
                    .distinct()
                    .sorted()
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[][] notes = new int[2][notes0.length];
            notes[0] = notes0;
            if (notes[0][0] > 0) {
                Exchange.exchange(sum, notes, notes[0].length - 1);
            } else {
                throw new NumberFormatException(" Note is less or equal to zero ");
            }
        } catch (NumberFormatException exc) {
            System.err.println("Caught NumberFormatException: " + exc.getMessage());
        }
    }
}
