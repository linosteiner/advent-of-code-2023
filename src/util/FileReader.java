package util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {

    private static final Path filePath = Path.of("resources/input.txt");

    public static List<String> getFileLines() {
        try {
            return readFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> readFile() throws IOException {
        return Files.readAllLines(filePath, StandardCharsets.UTF_8);
    }
}

