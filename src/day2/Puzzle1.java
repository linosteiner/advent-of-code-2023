package day2;

import util.FileReader;
import util.GameHelper;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Puzzle1 {
    public static final int RED_CUBES = 12;
    public static final int GREEN_CUBES = 13;
    public static final int BLUE_CUBES = 14;
    private static final ArrayList<Game> games = new ArrayList<>();
    private static int validGames;

    public static void run() {
        FileReader.setPath(Path.of("resources/input_day2.txt"));
        List<String> lines = FileReader.getFileLines();
        lines.forEach(line -> games.add(GameHelper.convertGameString(line)));
        games.forEach(Puzzle1::findValidPulls);
        System.out.printf("There are %s valid games\n", validGames);
    }

    private static void findValidPulls(Game game) {
        int maxPulls = game.pulls().length;
        int validPulls = 0;
        int red = 0;
        int green = 0;
        int blue = 0;
        for (String pulls : game.pulls()) {
            List<String> splitPulls = List.of(pulls.strip().split(","));
            for (String pull : splitPulls) {
                int value = Integer.parseInt(pull.replaceAll("[^0-9]", ""));
                String color = pull.replaceAll("[0-9]", "").strip();
                switch (color) {
                    case "red" -> red = value;
                    case "green" -> green = value;
                    case "blue" -> blue = value;
                }
            }
            if (red <= RED_CUBES && green <= GREEN_CUBES && blue <= BLUE_CUBES) {
                validPulls++;
            }
        }
        if (validPulls == maxPulls) {
            validGames += game.nr();
        }
    }
}
