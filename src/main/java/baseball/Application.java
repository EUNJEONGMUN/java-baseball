package baseball;

import camp.nextstep.edu.missionutils.Console;

import static constant.Constant.*;
import static constant.ErrorMessage.INVALID_INPUT_VALUE;

public class Application {
    public static void main(String[] args) {
        boolean isContinue = true;
        PrintComment.printStartComment();
        Game game = new Game();
        do {
            game.start();
            String userInput; // refactoring 중 임시 변수
            if (!game.isAnswer()) {
                continue;
            }
            PrintComment.printRestartComment();
            userInput = Console.readLine();

            validUserInputRestart(userInput);
            PrintComment.printUserInput(userInput);
            if (userInput.equals(END)){
                isContinue = false;
                continue;
            }
            game = new Game();
        } while(isContinue);
    }

    public static void validUserInputRestart(String num) {
        if (!num.equals(RESTART) && !num.equals(END)) {
            throw new IllegalArgumentException(INVALID_INPUT_VALUE);
        }
    }
}
