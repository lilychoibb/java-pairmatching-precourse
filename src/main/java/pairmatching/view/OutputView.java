package pairmatching.view;

import java.util.List;
import java.util.function.DoubleToIntFunction;

public class OutputView {
    public void courseAndMission() {
        System.out.println("#############################################");
        System.out.println("과정: 백엔드 | 프론트엔드");
        System.out.println("미션:");
        System.out.println("  - 레벨1: 자동차경주 | 로또 | 숫자야구게임");
        System.out.println("  - 레벨2: 장바구니 | 결제 | 지하철노선도");
        System.out.println("  - 레벨3:");
        System.out.println("  - 레벨4: 성능개선 | 배포");
        System.out.println("  - 레벨5:");
        System.out.println("############################################");
    }

    public void pairMatchingResult(List<List<String>> matchPairs) {
        System.out.println("페어 매칭 결과입니다.");
        for (List<String> crews : matchPairs) {
            System.out.println(String.join(" : ", crews));
        }
    }
}
