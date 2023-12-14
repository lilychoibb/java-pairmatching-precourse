package pairmatching.domain;

public enum ErrorMessage {
    MATCHING_HISTORY_NOT_FOUND("[ERROR] 매칭 이력이 없습니다."),
    INVALID_INPUT("[ERROR] 잘못된 값이 입력되었습니다.");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
