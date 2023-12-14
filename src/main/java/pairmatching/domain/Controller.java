package pairmatching.domain;

import java.util.List;
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
        PairMatching pairMatching = inputCourseAndLevelAndMission();
        List<List<String>> matchPairs = pairMatching.matchPairs();
        System.out.println();
        outputView.pairMatchingResult(matchPairs);
    public boolean checkMatchDuplicate(List<PairMatching> matchFinished) {
        Set<PairMatching> uniqueMatches = new HashSet<>();

        for (PairMatching match : matchFinished) {
            if (!uniqueMatches.add(match)) {
                return true;
            }
        }

        // 중복이 없음
        return false;
    }

    private String inputReMatch() {
        try {
            String reMatch = inputView.inputReMatching();
            validateReMatch(reMatch);
            return reMatch;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.INVALID_INPUT.getErrorMessage());
            return inputReMatch();
        }
    }

    private void validateReMatch(String reMatch) {
        if (!Objects.equals(reMatch, "네") && !Objects.equals(reMatch, "아니오")) {
            throw new IllegalArgumentException();
        }
    }


    private String inputFuction() {
        try {
            String function = inputView.inputFunction();
            validateInputFuction(function);
            return function;
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.INVALID_INPUT.getErrorMessage());
            return inputFuction();
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
            System.out.println(ErrorMessage.INVALID_INPUT.getErrorMessage());
            return inputCourseAndLevelAndMission();
        }
    }

    private String removeBlank(String inputData) {
        return inputData.replaceAll(" ", "");
    }
}