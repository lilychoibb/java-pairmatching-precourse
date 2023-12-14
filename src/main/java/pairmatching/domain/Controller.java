package pairmatching.domain;

import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void pairmatchingLogic() {
        String function = inputView.inputFunction();
        System.out.println();
        outputView.courseAndMission();

    }
}
