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
        String name = raw.trim();
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름은 비어 있을 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

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
