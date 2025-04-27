/**
 * Represents a time using the number of seconds since midnight.
 * Provides methods for accessing and modifying hours, minutes, and seconds,
 * as well as comparing and formatting time.
 * 
 * This implementation is optimized by storing time internally in seconds only.
 *
 * @author Or Ashry
 * @version 27/04/25
 */
public class Time2 {
    // Attributes and Constants
    private int _secFromMid;
    private final int MIN_TIME = 0; // Minimum valid time value
    private final int MAX_HOUR = 23; // Maximum valid hour
    private final int MAX_MIN_AND_SEC = 59; // Maximum valid minute and second
    private final int SECONDS_PER_MINUTE = 60;
    private final int SECONDS_PER_HOUR = 3600; // 60 minutes per hour × 60 seconds per minute
    private final int DOUBLE_DIGIT_THRESHOLD = 10;

    /**
     * Constructs a Time2 object with the specified hour, minute, and second.
     * Values out of range are set to 0.
     *
     * @param h the hour (0-23)
     * @param m the minute (0-59)
     * @param s the second (0-59)
     */
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

    /**
     * Copy constructor.
     * Initializes a new Time2 object with another Time2's values.
     *
     * @param other the Time2 object to copy
     */
    public Time2(Time2 other) {
        _secFromMid = other._secFromMid;
    }

    // Private Help Methods

    /**
     * Converts hours to seconds.
     * 
     * @param number number of hours
     * @return equivalent seconds
     */
    private int fromHourToSec(int number) {
        return number * SECONDS_PER_HOUR;
    }

    /**
     * Converts minutes to seconds.
     * 
     * @param number number of minutes
     * @return equivalent seconds
     */
    private int fromMinuteToSec(int number) {
        return number * SECONDS_PER_MINUTE;
    }

    /**
     * Converts hours to minutes.
     * 
     * @param number number of hours
     * @return equivalent minutes
     */
    private int fromHourToMin(int number) {
        return number * SECONDS_PER_MINUTE; 
    }

    /**
     * Extracts the hour component from seconds.
     * 
     * @return hour (0-23)
     */
    private int extractHour() {
        return _secFromMid / SECONDS_PER_HOUR;
    }

    /**
     * Extracts the minute component from seconds.
     * 
     * @return minute (0-59)
     */
    private int extractMinute() {
        return (_secFromMid / SECONDS_PER_MINUTE) - fromHourToMin(extractHour());
    }

    /**
     * Extracts the second component from seconds.
     * 
     * @return second (0-59)
     */
    private int extractSecond() {
        return _secFromMid - (fromHourToSec(extractHour()) + fromMinuteToSec(extractMinute()));
    }

    /**
     * Adds a leading zero to numbers less than 10 for formatting.
     * 
     * @param num the number to format
     * @return formatted string with leading zero if needed
     */
    private String addZero(int num) {
        if(num < DOUBLE_DIGIT_THRESHOLD) {
            return "0" + num; 
        }
        return "" + num;
    }

    // Get Methods

    /**
     * Returns the hour component.
     * 
     * @return hour (0-23)
     */
    public int getHour() {
        return extractHour();
    }

    /**
     * Returns the minute component.
     * 
     * @return minute (0-59)
     */
    public int getMinute() {
        return extractMinute();
    }

    /**
     * Returns the second component.
     * 
     * @return second (0-59)
     */
    public int getSecond() {
        return extractSecond();
    }

    // Setters Methods
    
    /**
     * Sets the hour if within valid range.
     * 
     * @param num the new hour (0-23)
     */
    public void setHour (int num) {
        if(num >= MIN_TIME && num <= MAX_HOUR) {
            _secFromMid = _secFromMid - fromHourToSec(extractHour()) + fromHourToSec(num);
        }
    }

    /**
     * Sets the minute if within valid range.
     * 
     * @param num the new minute (0-59)
     */
    public void setMinute(int num) {
        if(num >= MIN_TIME && num <= MAX_MIN_AND_SEC) {
            _secFromMid = _secFromMid - fromMinuteToSec(extractMinute()) + fromMinuteToSec(num);
        }
    }

    /**
     * Sets the second if within valid range.
     * 
     * @param num the new second (0-59)
     */
    public void setSecond(int num) {
        if(num >= MIN_TIME && num <= MAX_MIN_AND_SEC) {
            _secFromMid = _secFromMid - extractSecond() + num;
        }
    }

    /**
     * Returns the number of seconds since midnight.
     * 
     * @return seconds from midnight
     */
    public int secFromMidnight () {
        return _secFromMid;
    }

    /**
     * Checks if this time is equal to another time.
     * 
     * @param other the other Time2 object
     * @return true if times are equal, false otherwise
     */
    public boolean equals(Time2 other) {
        return _secFromMid == other._secFromMid;
    }

    /**
     * Checks if this time is before another time.
     * 
     * @param other the other Time2 object
     * @return true if this time is before the other time, false otherwise
     */
    public boolean before(Time2 other) {
        return _secFromMid < other._secFromMid;
    }

    /**
     * Checks if this time is after another time.
     * 
     * @param other the other Time2 object
     * @return true if this time is after the other time, false otherwise
     */
    public boolean after(Time2 other) {
        return other.before(this);
    }

    /**
     * Calculates the difference in seconds between this time and another time.
     * 
     * @param other the other Time2 object
     * @return the difference in seconds
     */
    public int difference(Time2 other) {
        return _secFromMid - other._secFromMid;
    }

    /**
     * Returns a string representation of the time in HH:MM:SS format.
     * 
     * @return formatted time string
     */
    public String toString() {
        return addZero(extractHour()) + ":" + addZero(extractMinute()) + ":" + addZero(extractSecond());
    }
}
