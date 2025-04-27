public class Time2 {
    // Attributes
    private int _secFromMid;
    private final int MIN_TIME = 0; // Minimum valid time value
    private final int MAX_HOUR = 23; // Maximum valid hour
    private final int MAX_MIN_AND_SEC = 59; // Maximum valid minute and second
    private final int SECONDS_PER_MINUTE = 60;
    private final int SECONDS_PER_HOUR = 3600; // 60 minutes per hour × 60 seconds per minute
    private final int DOUBLE_DIGIT_THRESHOLD = 10;

    // Constractors
    public Time2(int h, int m, int s) {
        if(h < MIN_TIME || h > MAX_HOUR) {
            h = MIN_TIME;
        }

        if(m < MIN_TIME || m > MAX_MIN_AND_SEC) {
            m = MIN_TIME;
        }

        if(s < MIN_TIME || s > MAX_MIN_AND_SEC) {
            s = MIN_TIME;
        }

        _secFromMid = (h * SECONDS_PER_HOUR) + (m * SECONDS_PER_MINUTE) + s;
    }

    public Time2(Time2 other) {
        _secFromMid = other._secFromMid;
    }

    // Private Help Methods
    private int extractHour() {
        return _secFromMid / SECONDS_PER_HOUR;
    }

    private int extractMinute() {
        return (_secFromMid / SECONDS_PER_MINUTE) - extractHour();
    }

    private int extractSecond() {
        return _secFromMid - (extractHour() + extractMinute());
    }

    private int fromHourToSec(int number) {
        return number * SECONDS_PER_HOUR;
    }

    private int fromMinuteToSec(int number) {
        return number * SECONDS_PER_MINUTE;
    }

    private String addZero(int num) {
        if(num < DOUBLE_DIGIT_THRESHOLD) {
            return "0" + num; 
        }
        return "" + num;
    }

    // Get Methods
    public int getHour() {
        return extractHour();
    }

    public int getMinute() {
        return extractMinute();
    }

    public int getSecond() {
        return extractSecond();
    }

    // Seters Methods 
    public void setHour (int num) {
        if(num >= MIN_TIME && num <= MAX_HOUR) {
            _secFromMid = _secFromMid - fromHourToSec(extractHour()) + fromHourToSec(num);
        }
    }

    public void setMinute(int num) {
        if(num >= MIN_TIME && num <= MAX_MIN_AND_SEC) {
            _secFromMid = _secFromMid - fromMinuteToSec(extractMinute()) + fromMinuteToSec(num);
        }
    }

    public void setSecond(int num) {
        if(num >= MIN_TIME && num <= MAX_MIN_AND_SEC) {
            _secFromMid = _secFromMid - extractSecond() + num;
        }
    }

    public int secFromMidnight () {
        return _secFromMid;
    }

    public boolean equals(Time2 other) {
        return _secFromMid == other._secFromMid;
    }

    public boolean before(Time2 other) {
        return _secFromMid < other._secFromMid;
    }

    public boolean after(Time2 other) {
        return other.before(this);
    }

    public int difference(Time2 other) {
        return _secFromMid - other._secFromMid;
    }

    public String toString() {
        return addZero(extractHour()) + ":" + addZero(extractMinute()) + ":" + addZero(extractSecond());
    }

}
