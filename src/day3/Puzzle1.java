package day3;

import util.FileReader;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Puzzle1 {


    private static Set<Character> uniqueSymbols;

    public static void run() {
        System.out.println("Day 3 - Puzzle 1");
        FileReader.setPath(Path.of("resources/input_day3.txt"));
        List<String> lines = FileReader.getFileLines();

        uniqueSymbols = new HashSet<>();
        lines.forEach(line -> {
            for (Character ch : line.toCharArray()) {
                if (!Character.isDigit(ch) && ch != '.') {
                    uniqueSymbols.add(ch);
                }
            }
        });

        System.out.println(uniqueSymbols);

        int sum = 0;
        StringBuilder currentNumber = new StringBuilder();
        for (int i = 0; i < lines.size(); i++) {
            char leftCharacter = 0;
            char topLeftCharacter = 0;
            char topCharacter = 0;
            char topRightCharacter = 0;
            char rightCharacter = 0;
            char bottomRightCharacter = 0;
            char bottomCharacter = 0;
            char bottomLeftCharacter = 0;

            String line = lines.get(i);
            boolean adjacentSymbol = false;
            for (int j = 0; j < line.length(); j++) {
                char currentCharacter = lines.get(i).charAt(j);

                if (currentCharacter == '.' && !Character.isDigit(currentCharacter)) {
                    continue;
                }

                //Top left
                if (i == 0 && j == 0) {
                    rightCharacter = line.charAt(j + 1);
                    bottomRightCharacter = lines.get(i + 1).charAt(j + 1);
                    bottomCharacter = lines.get(i + 1).charAt(j);
                }

                // Top right
                if (i == 0 && j == line.length() - 1) {
                    bottomCharacter = lines.get(i + 1).charAt(j);
                    bottomLeftCharacter = lines.get(i + 1).charAt(j - 1);
                }

                //Top row
                if (i == 0 && j >= 1 && j <= line.length() - 1) {
                    leftCharacter = line.charAt(j - 1);
                    rightCharacter = line.charAt(j + 1);
                    bottomRightCharacter = lines.get(i + 1).charAt(j + 1);
                    bottomCharacter = lines.get(i + 1).charAt(j);
                    bottomLeftCharacter = lines.get(i + 1).charAt(j - 1);
                }

                //Bottom left
                if (i == lines.size() - 1 && j == 0) {
                    topCharacter = lines.get(i - 1).charAt(j);
                    topRightCharacter = lines.get(i - 1).charAt(j + 1);
                    rightCharacter = line.charAt(j + 1);
                }

                //Bottom right
                if (i == lines.size() - 1 && j == line.length() - 1) {
                    topCharacter = lines.get(i - 1).charAt(j);
                    topLeftCharacter = lines.get(i - 1).charAt(j - 1);
                    leftCharacter = line.charAt(j - 1);
                }

                //Bottom row
                if (i == lines.size() - 1 && j > 0 && j < line.length() - 1) {
                    leftCharacter = line.charAt(j - 1);
                    topLeftCharacter = lines.get(i - 1).charAt(j - 1);
                    topCharacter = lines.get(i - 1).charAt(j);
                    topRightCharacter = lines.get(i - 1).charAt(j + 1);
                    rightCharacter = line.charAt(j + 1);
                }

                //Leftmost
                if (i != 0 && i != lines.size() - 1 && j == 0) {
                    topCharacter = lines.get(i - 1).charAt(j);
                    topRightCharacter = lines.get(i - 1).charAt(j + 1);
                    rightCharacter = line.charAt(j + 1);
                    bottomRightCharacter = lines.get(i + 1).charAt(j + 1);
                    bottomCharacter = lines.get(i + 1).charAt(j);
                }
                //Rightmost
                if (i != 0 && i != lines.size() - 1 && j == line.length() - 1) {
                    topCharacter = lines.get(i - 1).charAt(j);
                    bottomCharacter = lines.get(i + 1).charAt(j);
                    bottomLeftCharacter = lines.get(i + 1).charAt(j - 1);
                    leftCharacter = line.charAt(j - 1);
                    topLeftCharacter = lines.get(i - 1).charAt(j - 1);
                }

                if (i > 0 && j > 0 && i < lines.size() - 1 && j <= line.length() - 2) {
                    leftCharacter = line.charAt(j - 1);
                    topLeftCharacter = lines.get(i - 1).charAt(j - 1);
                    topCharacter = lines.get(i - 1).charAt(j);
                    topRightCharacter = lines.get(i - 1).charAt(j + 1);
                    rightCharacter = line.charAt(j + 1);
                    bottomRightCharacter = lines.get(i + 1).charAt(j + 1);
                    bottomCharacter = lines.get(i + 1).charAt(j);
                    bottomLeftCharacter = lines.get(i + 1).charAt(j - 1);
                }

                if (Character.isDigit(currentCharacter)) {

                    currentNumber.append(line.charAt(j));
                    if (uniqueSymbols.contains(leftCharacter)
                            || uniqueSymbols.contains(topLeftCharacter)
                            || uniqueSymbols.contains(topCharacter)
                            || uniqueSymbols.contains(topRightCharacter)
                            || uniqueSymbols.contains(rightCharacter)
                            || uniqueSymbols.contains(bottomRightCharacter)
                            || uniqueSymbols.contains(bottomCharacter)
                            || uniqueSymbols.contains(bottomLeftCharacter)) {
                        adjacentSymbol = true;
                    }
                } else {
                    if (adjacentSymbol) {
                        adjacentSymbol = false;
                        sum += Integer.parseInt(String.valueOf(currentNumber));
                    }
                    currentNumber = new StringBuilder();
                }
                leftCharacter = ' ';
                topLeftCharacter = ' ';
                topCharacter = ' ';
                topRightCharacter = ' ';
                rightCharacter = ' ';
                bottomRightCharacter = ' ';
                bottomCharacter = ' ';
                bottomLeftCharacter = ' ';
            }
            currentNumber = new StringBuilder();
        }
        System.out.println(sum);
    }
}

