/**
 * Represents a time in hours, minutes, and seconds (24-hour format).
 * Provides methods for comparing, formatting, and manipulating time objects.
 *
 * @author Or Ashry
 * @version 27/04/25
 */
public class Time1 {
    // Attributes and Constants
    private int _hour;
    private int _minute;
    private int _second;
    private final int MIN_TIME = 0; // Minimum valid time value
    private final int MAX_HOUR = 23; // Maximum valid hour
    private final int MAX_MIN_AND_SEC = 59; // Maximum valid minute and second
    private final int SECONDS_PER_MINUTE = 60;
    private final int SECONDS_PER_HOUR = 3600; // 60 minutes per hour × 60 seconds per minute
    private final int DOUBLE_DIGIT_THRESHOLD = 10;

    // Constructors

    /**
     * Constructs a Time1 object with the specified hour, minute, and seconds.
     * Values out of range are set to 0.
     *
     * @param h the hour (0-23)
     * @param m the minute (0-59)
     * @param s the second (0-59)
     */
    public Time1(int h, int m, int s) {
        _hour = isValid(h, MAX_HOUR) ? h : MIN_TIME;
        _minute = isValid(m, MAX_MIN_AND_SEC) ? m : MIN_TIME;
        _second = isValid(s, MAX_MIN_AND_SEC) ? s : MIN_TIME;
    }

    /**
     * Copy constructor.
     * Initializes a new Time1 object with another Time1's values.
     *
     * @param other the Time1 object to copy
     */
    public Time1(Time1 other) {
        // Copy values from another Time1 object
        _hour = other._hour;
        _minute = other._minute;
        _second = other._second;
    }

    // Private Help Method
    
    /**
    * Checks if the given number is within a valid range [0, maxVal].
    *
    * @param num the number to validate
    * @param maxVal the maximum allowed value
    * @return true if num is between 0 and maxVal (inclusive), false otherwise
    */
    private boolean isValid(int num, int maxVAl) {
        return (num >= MIN_TIME && num <= maxVAl);
    }

    // Getters Methods

    /**
     * Returns the hour component.
     * 
     * @return the hour (0-23)
     */
    public int getHour() {
        return _hour;
    }

    /**
     * Returns the minute component.
     * 
     * @return the minute (0-59)
     */
    public int getMinute() {
        return _minute;
    }

    /**
     * Returns the second component.
     * 
     * @return the second (0-59)
     */
    public int getSecond() {
        return _second;
    }

    // Setters Methods

    /**
     * Sets the hour if within valid range.
     * 
     * @param num the new hour (0-23)
     */
    public void setHour(int num) {
        // Set hour only if within valid range
        if(isValid(num, MAX_HOUR)) {
            _hour = num;
        }
    }

    /**
     * Sets the minute if within valid range.
     * 
     * @param num the new minute (0-59)
     */
    public void setMinute(int num) {
        // Set minute only if within valid range
        if(isValid(num, MAX_MIN_AND_SEC)) {
            _minute = num;
        }
    }

    /**
     * Sets the second if within valid range.
     * 
     * @param num the new second (0-59)
     */
    public void setSecond(int num) {
        // Set second only if within valid range
        if(isValid(num, MAX_MIN_AND_SEC)) {
            _second = num;
        }
    }

    // Other Methods

    /**
     * Converts the hour component to seconds.
     * 
     * @return the hour in seconds
     */
    private int fromHourToSec() {
        return _hour * SECONDS_PER_HOUR;
    }

    /**
     * Converts the minute component to seconds.
     * 
     * @return the minute in seconds
     */
    private int fromMinuteToSec() {
        return _minute * SECONDS_PER_MINUTE;
    }

    /**
     * Adds a leading zero to numbers less than 10 for formatting.
     * 
     * @param num the number to format
     * @return a string with leading zero if needed
     */
    private String addZero(int num) {
        if(num < DOUBLE_DIGIT_THRESHOLD) {
            return "0" + num; 
        }
        return "" + num;
    }

    /**
     * Returns a string representation of the time in HH:MM:SS format.
     * 
     * @return formatted time string
     */
    public String toString() {
        // Format time with leading zeros if needed
        return addZero(_hour) + ":" + addZero(_minute) + ":" + addZero(_second); //need to add zero if the num is only one letter !!!!!!!!!!!!!!!!!!!
    }

    /**
     * Returns the number of seconds since midnight.
     * 
     * @return seconds from midnight
     */
    public int secFromMidnight() {
        // Sum all components converted to seconds
        return fromHourToSec() + fromMinuteToSec() + _second; 
    }

    /**
     * Checks if this time is equal to another time.
     * @param other the other Time1 object
     * @return true if times are equal, false otherwise
     */
    public boolean equals(Time1 other) {
        // Compare each component separately
        if(_hour == other._hour && _minute == other._minute && _second == other._second) {
            return true;
        }
        return false;
    }

    /**
     * Checks if this time is before another time.
     * 
     * @param other the other Time1 object
     * @return true if this time is before the other time, false otherwise
     */
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

    /**
     * Checks if this time is after another time.
     * 
     * @param other the other Time1 object
     * @return true if this time is after the other time, false otherwise
     */
    public boolean after(Time1 other) {
        return other.before(this);
    }

    /**
     * Calculates the difference in seconds between this time and another time.
     * 
     * @param other the other Time1 object
     * @return the difference in seconds
     */
    public int difference(Time1 other) {
        return secFromMidnight() - other.secFromMidnight();
    }
}