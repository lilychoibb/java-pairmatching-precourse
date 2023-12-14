package pairmatching;

import pairmatching.domain.Controller;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(), new OutputView());
        controller.pairMatchingLogic();
    }
}
