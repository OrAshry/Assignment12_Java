/**
 * Represents a bus arrival event with a bus line number, arrival time, and number of passengers.
 * Provides methods to access, modify, and compare bus arrivals.
 * 
 * Time is managed through a Time1 object.
 *
 * @author Or Ashry
 * @version 27/04/25
 */
public class BusArrival {
    // Attributes and Constants
    private int _lineNumber;
    private Time1 _arrivalTime;
    private int _noOfPassengers;
    private final int MIN_PASSENGERS = 0; // Minimum passengers allowed
    private final int MAX_PASSENGERS = 70; // Maximum passengers allowed
    private final int MIN_LINE_NUMBER = 1; // Minimum bus line number
    private final int MAX_LINE_NUMBER = 99; // Maximum bus line number
    private final int SECONDS_PER_MINUTE = 60; // 60 seconds in a minute

    // Constructors

    /**
     * Constructs a BusArrival with specified line number, number of passengers, and arrival time components.
     * Invalid line numbers and passenger counts are corrected to minimum values.
     *
     * @param lineNum the bus line number (1-99)
     * @param pass the number of passengers (0-70)
     * @param h hour of arrival (0-23)
     * @param m minute of arrival (0-59)
     * @param s second of arrival (0-59)
     */
    public BusArrival(int lineNum, int pass, int h, int m, int s) {
        _lineNumber = lineNum;
        _noOfPassengers = pass;
        _arrivalTime = new Time1(h, m, s);

        // Validate and correct values
        if(_lineNumber < MIN_LINE_NUMBER || _lineNumber > MAX_LINE_NUMBER) {
            _lineNumber = MIN_LINE_NUMBER;
        }
        if(_noOfPassengers < MIN_PASSENGERS || _noOfPassengers > MAX_PASSENGERS) {
            _noOfPassengers = MIN_PASSENGERS;
        }
        
    }

    /**
     * Constructs a BusArrival with specified line number, number of passengers, and a Time1 object.
     * Invalid line numbers and passenger counts are corrected to minimum values.
     *
     * @param lineNum the bus line number (1-99)
     * @param pass the number of passengers (0-70)
     * @param t the arrival time (Time1 object)
     */
    public BusArrival(int lineNum, int pass, Time1 t) {
        _lineNumber = lineNum;
        _noOfPassengers = pass;
        _arrivalTime = new Time1(t);

        // Validate and correct values
        if(_lineNumber < MIN_LINE_NUMBER || _lineNumber > MAX_LINE_NUMBER) {
            _lineNumber = MIN_LINE_NUMBER;
        }
        if(_noOfPassengers < MIN_PASSENGERS || _noOfPassengers > MAX_PASSENGERS) {
            _noOfPassengers = MIN_PASSENGERS;
        }
    }

    /**
     * Copy constructor. Initializes a new BusArrival object by copying another BusArrival.
     *
     * @param other the BusArrival object to copy
     */
    public BusArrival (BusArrival other) {
        _lineNumber = other._lineNumber;
        _noOfPassengers = other._noOfPassengers;
        _arrivalTime = new Time1(other._arrivalTime);
    }

    // Getters Methods

    /**
     * Returns a copy of the arrival time.
     * 
     * @return arrival time (Time1 object)
     */
    public Time1 getArrivalTime() {
        return new Time1(_arrivalTime);
    }

    /**
     * Returns the bus line number.
     * 
     * @return line number (1-99)
     */
    public int getLineNum() {
        return _lineNumber;
    }

    /**
     * Returns the number of passengers.
     * 
     * @return number of passengers (0-70)
     */
    public int getNoOfPass() {
        return _noOfPassengers;
    }

    // Setters Methods

    /**
     * Sets the arrival time using a Time1 object.
     * 
     * @param t the new arrival time
     */
    public void setArrivalTime(Time1 t) {
        _arrivalTime = new Time1(t);
    }

    /**
     * Sets the bus line number if within valid range.
     * 
     * @param num the new bus line number (1-99)
     */
    public void setLineNum(int num) {
        if(num >= MIN_LINE_NUMBER && num <= MAX_LINE_NUMBER) {
            _lineNumber = num;
        }
    }
    
    /**
     * Sets the number of passengers if within valid range.
     * 
     * @param num the new number of passengers (0-70)
     */
    public void setNoOfPass (int num) {
        if(num >= MIN_PASSENGERS && num <= MAX_PASSENGERS) {
            _noOfPassengers = num;
        }
    }

    /**
     * Checks if this BusArrival is equal to another.
     * 
     * @param other the other BusArrival object
     * @return true if line number, passengers, and arrival time are equal
     */
    public boolean equals(BusArrival other) {
        if(_arrivalTime.equals(other._arrivalTime) && _lineNumber == other._lineNumber && _noOfPassengers == other._noOfPassengers) {
            return true;
        }
        return false;
    }

    /**
     * Returns a string describing the bus arrival.
     * 
     * @return formatted description string
     */
    public String toString() {
        return "Bus no. " + _lineNumber + " arrived at " + _arrivalTime + " with " + _noOfPassengers + " passengers";
    }

    /**
     * Checks if this bus is fuller (more passengers) than another bus.
     * 
     * @param other the other BusArrival object
     * @return true if this bus has more passengers
     */
    public boolean fuller(BusArrival other) {
        return _noOfPassengers > other._noOfPassengers;
    }

    /**
     * Checks if this bus arrived before another bus.
     * 
     * @param other the other BusArrival object
     * @return true if this bus arrived earlier
     */
    public boolean before(BusArrival other) {
        return _arrivalTime.before(other._arrivalTime);
    }

    /**
     * Checks if the bus is full.
     * 
     * @return true if the number of passengers equals the maximum
     */
    public boolean isFull() {
        return _noOfPassengers == MAX_PASSENGERS;
    }

    /**
     * Calculates the elapsed time in minutes between this bus and another bus.
     * 
     * @param other the other BusArrival object
     * @return elapsed time in minutes
     */   
    public int elapsedTime(BusArrival other) {
        if(_arrivalTime.equals(other._arrivalTime)) {
            return _arrivalTime.difference(other._arrivalTime) / SECONDS_PER_MINUTE;
        }
        return other._arrivalTime.difference(_arrivalTime) / SECONDS_PER_MINUTE;
        
    }
}
