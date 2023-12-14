package pairmatching.domain;

import java.util.Objects;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void pairMatchingLogic() {
        inputFuction();
        System.out.println();
        outputView.courseAndMission();
        String courseAndLevelAndMission = inputView.inputCourseAndLevelAndMission();
    }

    private void inputFuction() {
        try {
            String function = inputView.inputFunction();
            validateInputFuction(function);
        } catch (IllegalArgumentException e) {
            System.out.println();
        }
    }

    private void validateInputFuction(String function) {
        if (!Objects.equals(function, "1") && !Objects.equals(function, "2") && !Objects.equals(function, "3")
                && !Objects.equals(function, "Q")) {
            throw new IllegalArgumentException();
        }
    }
}