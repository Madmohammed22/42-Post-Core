package JavaModule00.ex03;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        /**
         * @catch // condition of range result
         */
        Scanner scanner = new Scanner(System.in);

        long progressData = 0;
        int totalWeeksCount = 0;
        int expectedNextWeek = 1;

        while(expectedNextWeek <= 10)
        {
            System.out.print("-> ");
            String weekHeader = scanner.next();
            if (weekHeader.equals("42"))
                break;
            if (!weekHeader.equals("Week")){
                System.err.println("IllegalArgument");
                System.exit(-1);
            }

            System.out.print("-> ");
            int inputWeekNumber = scanner.nextInt();
            if (inputWeekNumber != expectedNextWeek){
                System.err.println("IllegalArgument");
                System.exit(-1);
            }

            int minGrade = 9;
            for (int i = 0; i < 5; i++){
                int currentGrade = scanner.nextInt();
                if (currentGrade < minGrade){
                    minGrade = currentGrade;
                }
            }
            
            progressData = (progressData * 10) + minGrade;
            totalWeeksCount++;
            expectedNextWeek++;

        }

        long reverseData = 0;
        long temporaryDara = progressData;
        for (int i = 0; i < totalWeeksCount; i++){
            reverseData = (reverseData * 10) + (temporaryDara % 10);
            temporaryDara /= 10;
        }
        for (int currentWeek = 1; currentWeek <= totalWeeksCount; currentWeek++) {
            System.out.print("Week ");
            System.out.print(currentWeek);
            System.out.print(" ");
            int currentWeekMinGrade = (int) (reverseData % 10);
            reverseData /= 10;
            for (int i = 0; i < currentWeekMinGrade; i++){
                System.out.print("=");
            }
            System.out.println(">");
        }
        scanner.close();
    }
}
