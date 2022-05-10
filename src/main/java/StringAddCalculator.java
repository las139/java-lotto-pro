import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String NUMBER_REGEX = "^[1-9]*$";

    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return 0;
        }
        List<String> numbers = splitToNumbers(input);
        return 1;
    }

    private static List<String> splitToNumbers(String input) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return Arrays.asList(m.group(2).split(customDelimiter));
        }
        return Arrays.asList(input.split(DEFAULT_DELIMITER));
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static void validateNumberCheck(String number) {
        if (!Pattern.matches(NUMBER_REGEX, number)) {
            throw new RuntimeException("0 이상의 양수만 입력 가능합니다.");
        }
    }
}
