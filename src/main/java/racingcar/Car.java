package racingcar;

class Car {
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position = 0;

    Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String raw) {
        if (raw == null) {
            throw new IllegalArgumentException("이름은 null일 수 없습니다.");
        }
        String trimmed = raw.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }
        if (trimmed.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    // 상위에서 전달받은 난수로 전진 여부 결정(난수 생성은 Cars에서)
    void tryMove(int randomNumberInclusive) {
        if (randomNumberInclusive >= MOVE_THRESHOLD) {
            position++;
        }
    }

    String statusLine() {
        return name + " : " + "-".repeat(position);
    }

    int getPosition() {
        return position;
    }

    String getName() {
        return name;
    }
}