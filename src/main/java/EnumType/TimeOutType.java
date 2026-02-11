package EnumType;

public enum TimeOutType {


    SHORT(5),
    MEDIUM(10),
    LONG(20);


    private final long seconds;

    TimeOutType(long seconds) {
        this.seconds = seconds;
    }

    public long getSeconds() {
        return seconds;
    }
}
