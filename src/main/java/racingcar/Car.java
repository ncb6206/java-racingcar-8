package racingcar;

class Car {
    private final String name;
    private int position = 0;

    Car(String name) {
        validateName(name);
        this.name = name; // 원본 저장, 검증은 trim 기준
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
}