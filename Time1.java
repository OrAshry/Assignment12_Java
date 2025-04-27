public class Time1 {
    
    //Atributes and Constants
    private int _hour; // 0-23
    private int _minute; // 0-59
    private int _second; // 0-59
    private final int MIN_TIME = 0;
    private final int MAX_HOUR = 23;
    private final int MAX_MIN_AND_SEC = 59;

    //Consturctors

    public Time1(int h, int m, int s) {
        
        _hour = h;
        _minute = m;
        _second = s;
        
        if(_hour < MIN_TIME || _hour > MAX_HOUR) {
            _hour = MIN_TIME;
        }

        if(_minute < MIN_TIME || _minute > MAX_MIN_AND_SEC) {
            _minute = MIN_TIME;
        }

        if(_second < MIN_TIME || _second > MAX_MIN_AND_SEC) {
            _second = MIN_TIME;
        }
    }

    //Copy Constructor
    public Time1(Time1 other) {
        _hour = other._hour;
        _minute = other._minute;
        _second = other._second;
    }

    //Get Methods

    public int getHour() {
        return _hour;
    }

    public int getMinute() {
        return _minute;
    }

    public int getSecond() {
        return _second;
    }

    //Seters Methods
    public void setHour(int num) {
        if(num >= MIN_TIME && num <= MAX_HOUR) {
            _hour = num;
        }
    }

    public void setMinute(int num) {
        if(num >= MIN_TIME && num <= MAX_MIN_AND_SEC) {
            _minute = num;
        }
    }

    public void setSecond(int num) {
        if(num >= MIN_TIME && num <= MAX_MIN_AND_SEC) {
            _second = num;
        }
    }

    //private method to convert to seconds
    private int fromHourToSec() {
        return _hour * 60 * 60;
    }

    private int fromMinuteToSec() {
        return _minute * 60;
    }

    private String addZero(int num) {
        if(num < 10) {
            return "0" + num; 
        }
        return "" + num;
    }
    
    //Public Methods

    public String toString() {
        return addZero(_hour) + ":" + addZero(_minute) + ":" + _second; //need to add zero if the num is only one letter !!!!!!!!!!!!!!!!!!!
    }

    public int secFromMidnight() {
        return fromHourToSec() + fromMinuteToSec() + _second; 
    }

    public boolean equals(Time1 other) {
        if(_hour == other._hour && _minute == other._minute && _second == other._second) {
            return true;
        }
        return false;
    }

    public boolean before(Time1 other) {
        if(_hour < other._hour) {
            return true;
        }
        else if(_hour == other._hour) {
            if(_minute < other._minute) {
                return true;
            }
            else if(_minute == other._minute && _second < other._second) {
                return true;
            }
        }
        return false;
    }

    public boolean after(Time1 other) {
        return other.before(this);
    }

    public int difference(Time1 other) {
        return secFromMidnight() - other.secFromMidnight();
    }
}