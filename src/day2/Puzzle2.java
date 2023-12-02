package day2;

import util.FileReader;
import util.GameHelper;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Puzzle2 {

    private static final ArrayList<Game> games = new ArrayList<>();

    private static int sumOfPowerOfAllSets;

    public static void run() {
        FileReader.setPath(Path.of("resources/input_day2.txt"));
        List<String> lines = FileReader.getFileLines();
        lines.forEach(line -> games.add(GameHelper.convertGameString(line)));
        games.forEach(Puzzle2::findLargestColourQuantity);
        System.out.printf("The power of all the sets is %s", sumOfPowerOfAllSets);

    }

    private static void findLargestColourQuantity(Game game) {
        int red = 0;
        int green = 0;
        int blue = 0;
        for (String pulls : game.pulls()) {
            List<String> splitPulls = List.of(pulls.strip().split(","));
            for (String pull : splitPulls) {
                int value = Integer.parseInt(pull.replaceAll("[^0-9]", ""));
                String color = pull.replaceAll("[0-9]", "").strip();
                switch (color) {
                    case "red" -> red = Math.max(red, value);
                    case "green" -> green = Math.max(green, value);
                    case "blue" -> blue = Math.max(blue, value);
                }
            }
        }
        powerOfSets(red, green, blue);
    }

    private static void powerOfSets(int red, int green, int blue) {
        sumOfPowerOfAllSets = sumOfPowerOfAllSets + (red * green * blue);
    }

}
