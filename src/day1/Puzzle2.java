package day1;

import util.FileReader;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public class Puzzle2 {

    private static final List<String> NUMBER_STRINGS = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
    private static final Map<String, String> DIGIT_MAP = Map.of(
            "one", "on1e",
            "two", "tw2o",
            "three", "thre3e",
            "four", "fou4r",
            "five", "fiv5e",
            "six", "si6x",
            "seven", "seve7n",
            "eight", "eigh8t",
            "nine", "9nine"
    );

    public static void run() {
        FileReader.setPath(Path.of("resources/input_day1.txt"));
        List<String> lines = FileReader.getFileLines();

        Stream<String> replacedLines = lines.stream()
                .map(line -> {
                    for (String word : NUMBER_STRINGS) {
                        line = line.replace(word, String.valueOf(DIGIT_MAP.get(word)));
                    }
                    return line;
                });

        Puzzle1.extractDigits(replacedLines.toList());

    }

}
