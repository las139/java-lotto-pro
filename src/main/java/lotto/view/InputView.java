package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String MESSAGE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_INPUT_WIN_NUMBER = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMoneyView() {
        System.out.println(MESSAGE_INPUT_MONEY);
        return scanner.nextLine();
    }

    public static String inputWinningNumbersView() {
        System.out.println(MESSAGE_INPUT_WIN_NUMBER);
        return scanner.nextLine();
    }
}
