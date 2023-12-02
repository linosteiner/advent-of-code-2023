package util;

import day2.Game;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameHelper {

    public static Game convertGameString(String line) {
        Pattern gameId = Pattern.compile("[0-9]+");
        Matcher matcher = gameId.matcher(line);
        if (!matcher.find()) {
           return null;
        }
        return new Game(Integer.parseInt(matcher.group().strip()), line.replaceAll("[A-Za-z]+\\s[0-9]+:", "").split(";"));
    }
}
