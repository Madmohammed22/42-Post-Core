package JavaModule00.ex05;

import java.util.Scanner;

public class Program {
    public static final int MAX_USERS = 10;
    public static final int MAXRANG = 50;
    public static final String ERROR = "IllegalArgument";

    public static void main(String[] args) {
        Scanner scanner
                = new Scanner(System.in);
        String[] students = new String[MAX_USERS];
        int []classHours = new int[MAX_USERS];
        String[] classDays = new String[MAX_USERS];
        String[] weekdaysSequence = {"TU", "WE", "TH", "FR", "SA", "SU", "MO"};

        int studentCount = 0;
        int weeklyClassCount = 0;

        while (scanner.hasNextLine()){
            String input = scanner.nextLine();
            if (input.equals("."))
                break;
            if (!isAlphabetic(input)){
                System.err.println(ERROR);
                System.exit(-1);
            }
            students[studentCount] = input;
            studentCount++;
        }

        while (scanner.hasNextLine()){
            String input = scanner.nextLine();
            if (input.equals("."))
                break;
            if (!getClassHoursAndClassDays(input, classHours, classDays, weeklyClassCount, weekdaysSequence )){
                System.err.println(ERROR);
                System.exit(-1);
            }
            weeklyClassCount++;
        }

        int[] activeDates = new int[MAXRANG];
        int[] activeHours = new int[MAXRANG];
        String[] activeDays = new String[MAXRANG];
        int totalActiveClasses = 0;

        for (int date = 1; date <= 30; date++) {

            int weekdayIndex = (date - 1) % 7;
            String currentDayName = weekdaysSequence[weekdayIndex];

            // 3. Cross-reference that weekday against your user-defined weekly rules
            // weeklyClassCount is the number of rows entered in Phase 2
            for (int i = 0; i < weeklyClassCount; i++) {

                // If a class rule matches today's weekday name
                if (classDays[i].equals(currentDayName)) {

                    // Record this specific date instance into the active timeline arrays
                    activeDates[totalActiveClasses] = date;
                    activeHours[totalActiveClasses] = classHours[i];
                    activeDays[totalActiveClasses] = classDays[i];
                    totalActiveClasses++;
                }
            }
        }

        int[][] attendanceMatrix = new int[MAX_USERS][31];
        while (scanner.hasNextLine()){
            String input = scanner.nextLine();
            if (input.equals("."))
                break;

            char[] chars = input.toCharArray();
            // 1. Parse Student Name (up to first space)
            int idx = 0;
            String currentStudent = "";
            while (idx < chars.length && chars[idx] != ' ') {
                currentStudent += chars[idx];
                idx++;
            }
            idx++; // skip space
            if (!(isAlphabetic(currentStudent)))
            {
                System.err.println(ERROR);
                System.exit(-1);
            }

            // 2. Parse Class Hour
            int currentHour = 0;
            while (idx < chars.length && chars[idx] >= '0' && chars[idx] <= '9') {
                currentHour = currentHour * 10 + (chars[idx] - '0');
                idx++;
            }
            idx++; // skip space

            // 3. Parse Calendar Date
            int currentDate = 0;
            while (idx < chars.length && chars[idx] >= '0' && chars[idx] <= '9') {
                currentDate = currentDate * 10 + (chars[idx] - '0');
                idx++;
            }
            idx++; // skip space

            // 4. Parse Status (HERE or NOT_HERE)
            String status = "";
            while (idx < chars.length) {
                status += chars[idx];
                idx++;
            }
            if (!(status.equals("HERE") || status.equals("NOT_HERE"))){
                System.err.println(ERROR);
                System.exit(-1);
            }

            // Find matching student index
            int matchedStudentIdx = -1;
            for (int i = 0; i < studentCount; i++) {
                if (students[i].equals(currentStudent)) {
                    matchedStudentIdx = i;
                    break;
                }
            }

            // If valid student found, mark attendance status value
            if (matchedStudentIdx != -1) {
                if (status.equals("HERE")) {
                    attendanceMatrix[matchedStudentIdx][currentDate] = 1;
                } else if (status.equals("NOT_HERE")) {
                    attendanceMatrix[matchedStudentIdx][currentDate] = -1;
                }
            }
        }


        System.out.print("          ");

        for (int i = 0; i < totalActiveClasses; i++) {
            String timeStr = activeHours[i] + ":00 " + activeDays[i] + " ";
            if (activeDates[i] < 10) {
                timeStr += " " + activeDates[i];
            } else {
                timeStr += activeDates[i];
            }
            timeStr += "|";
            System.out.print(timeStr);
        }
        System.out.println();


        for (int s = 0; s < studentCount; s++) {
            String name = students[s];
            int spacesNeeded = 10 - name.length();
            for (int space = 0; space < spacesNeeded; space++) {
                System.out.print(" ");
            }
            System.out.print(name + "|");

            for (int c = 0; c < totalActiveClasses; c++) {
                int date = activeDates[c];
                int status = attendanceMatrix[s][date];

                if (status == 1) {
                    System.out.print("        "+ status + "|");
                } else if (status == -1) {
                    System.out.print("       "+ status + "|");
                } else {
                    System.out.print("         |");
                }
            }
            System.out.println();
        }

    }


    public static boolean isAlphabetic(String s) {

        if (s == null || s.isEmpty() || s.length() > 10) {
            return false;
        }

        for (char c : s.toCharArray()) {
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isExcludedBySequence(String day, String[] weekdaysSequence) {

        boolean result = false;
        for (String input : weekdaysSequence){
            if (input.equals(day)) {
                result = true;
                break;
            }
        }
      return result;
    }

    public static boolean getClassHoursAndClassDays(String input, int []classHours, String[] classDays, int weeklyClassCount, String[] weekdaysSequence) {
        char[] chars = input.toCharArray();

        int i = 0;
        int number = 0;
        boolean negative = false;

        if (chars[0] == '-') {
            negative = true;
            i++;
        }

        while (i < input.length() && chars[i] >= '0' && chars[i] <= '9') {
            number = number * 10 + (chars[i] - '0');
            i++;
        }

        if (negative) {
            number = -number;
        }
        if (!(number >= 1 && number <= 6))
            return  false;
        classHours[weeklyClassCount] = number;

        String text = "";
        i = i + 1;
        while (i < input.length()) {
            text += chars[i];
            i++;
        }
        if (!isExcludedBySequence(text, weekdaysSequence))
            return false;
        classDays[weeklyClassCount] = text;
        return true;
    }
}
