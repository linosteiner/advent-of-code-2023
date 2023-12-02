package day1;

import util.FileReader;

import java.nio.file.Path;
import java.util.List;

public class Puzzle1 {

    public static void run() {
        FileReader.setPath(Path.of("resources/input_day1.txt"));
        List<String> fileLines = FileReader.getFileLines();
        extractDigits(fileLines);
    }

    public static void extractDigits(List<String> file) {
        int sum = 0;

        for (String line : file) {
            String justDigits = extractOnlyDigits(line);
            int extractedNumber = processDigits(justDigits);
            if (extractedNumber != -1) {
                sum += extractedNumber;
            }
        }

        System.out.println("Sum of the numbers: " + sum);
    }

    private static String extractOnlyDigits(String line) {
        return line.replaceAll("\\D+", "");
    }

    private static int processDigits(String justDigits) {
        int justDigitsSize = justDigits.length();

        if (justDigitsSize < 1) {
            return -1;
        }

        char firstDigit = justDigits.charAt(0);
        StringBuilder digitsStringBuilder = new StringBuilder().append(firstDigit);

        if (justDigitsSize > 1) {
            char lastDigit = justDigits.charAt(justDigitsSize - 1);
            digitsStringBuilder.append(lastDigit);
        } else {
            digitsStringBuilder.append(firstDigit);
        }

        return Integer.parseInt(digitsStringBuilder.toString());
    }

}
