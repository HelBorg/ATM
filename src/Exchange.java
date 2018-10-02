public class Exchange {
    public static void exchange(int sum, int[][] notes, int curIndex) {
        if (sum > 0 && curIndex >= 0) {
            int num = sum / notes[0][curIndex];
            if (curIndex == 0){
                notes[1][curIndex] = num;
                exchange(sum - num*notes[0][curIndex], notes, curIndex - 1);
            }else{
                for (int i = 0; i <= num; i++) {
                    notes[1][curIndex] = i;
                    exchange(sum - i*notes[0][curIndex], notes, curIndex - 1);
                    for (int j = curIndex - 1; j >= 0; j--){
                        notes[1][j] = 0;
                    }
                }
            }
        }else if (sum == 0){
            for (int i = 0; i < notes[0].length; i++)
                System.out.print("\"" + notes[0][i] + "\" x " + notes[1][i] + "; ");
            System.out.println();
        }
    }
}
