package pairmatching.domain;

import java.util.Objects;
import pairmatching.model.PairMatching;
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
        String function = inputFuction();
        System.out.println();
        outputView.courseAndMission();
    }

    private String inputFuction() {
        try {
            String function = inputView.inputFunction();
            validateInputFuction(function);
            return function;
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

    private PairMatching inputCourseAndLevelAndMission() {
        try {
            String courseAndLevelAndMission = inputView.inputCourseAndLevelAndMission();
            String cleanData = removeBlank(courseAndLevelAndMission);
            String[] data = cleanData.split(",");
            return new PairMatching(data[0], data[1], data[2]);
        } catch (IllegalArgumentException e) {
            System.out.println();
        }
    }

    private String removeBlank(String inputData) {
        return inputData.replaceAll(" ", "");
    }
}