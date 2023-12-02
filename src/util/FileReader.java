package util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {

    private static Path path;

    public static List<String> getFileLines() {
        try {
            return readFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> readFile() throws IOException {
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

    public static void setPath(Path path) {
        FileReader.path = path;
    }
}

