

public class BusArrival {
    // Attributes and Constants
    private int _lineNumber;
    private Time1 _arrivalTime;
    private int _noOfPassengers;
    private final int MIN_PASSENGERS = 0;
    private final int MAX_PASSENGERS = 70;
    private final int MIN_LINE_NUMBER = 1;
    private final int MAX_LINE_NUMBER = 99;
    private final int SECONDS_PER_MINUTE = 60;

    // Constructors

    public BusArrival(int lineNum, int pass, int h, int m, int s) {
        _lineNumber = lineNum;
        _noOfPassengers = pass;
        _arrivalTime = new Time1(h, m, s);

        if(_lineNumber < MIN_LINE_NUMBER || _lineNumber > MAX_LINE_NUMBER) {
            _lineNumber = MIN_LINE_NUMBER;
        }

        
        if(_noOfPassengers < MIN_PASSENGERS || _noOfPassengers > MAX_PASSENGERS) {
            _noOfPassengers = MIN_PASSENGERS;
        }
        
    }

    public BusArrival(int lineNum, int pass, Time1 t) {
        _lineNumber = lineNum;
        _noOfPassengers = pass;
        _arrivalTime = new Time1(t);

        if(_lineNumber < MIN_LINE_NUMBER || _lineNumber > MAX_LINE_NUMBER) {
            _lineNumber = MIN_LINE_NUMBER;
        }

        if(_noOfPassengers < MIN_PASSENGERS || _noOfPassengers > MAX_PASSENGERS) {
            _noOfPassengers = MIN_PASSENGERS;
        }
    }

    // Copy Constractor
    public BusArrival (BusArrival other) {
        _lineNumber = other._lineNumber;
        _noOfPassengers = other._noOfPassengers;
        _arrivalTime = new Time1(other._arrivalTime);
    }

    // Getters Methods

    public Time1 getArrivalTime() {
        return new Time1(_arrivalTime);
    }

    public int getLineNum() {
        return _lineNumber;
    }

    public int getNoOfPass() {
        return _noOfPassengers;
    }

    // Setters Methods

    public void setArrivalTime(Time1 t) {
        _arrivalTime = new Time1(t);
    }

    public void setLineNum(int num) {
        if(num >= MIN_LINE_NUMBER && num <= MAX_LINE_NUMBER) {
            _lineNumber = num;
        }
    }

    public void setNoOfPass (int num) {
        if(num >= MIN_PASSENGERS && num <= MAX_PASSENGERS) {
            _noOfPassengers = num;
        }
    }

    public boolean equals(BusArrival other) {
        if(_arrivalTime.equals(other._arrivalTime) && _lineNumber == other._lineNumber && _noOfPassengers == other._noOfPassengers) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Bus no. " + _lineNumber + " arrived at " + _arrivalTime + " with " + _noOfPassengers + " passengers";
    }

    public boolean fuller(BusArrival other) {
        return _noOfPassengers > other._noOfPassengers;
    }

    public boolean before(BusArrival other) {
        return _arrivalTime.before(other._arrivalTime);
    }

    public boolean isFull() {
        return _noOfPassengers == MAX_PASSENGERS;
    }

    public int elapsedTime(BusArrival other) {
        if(_arrivalTime.equals(other._arrivalTime)) {
            return _arrivalTime.difference(other._arrivalTime) / SECONDS_PER_MINUTE;
        }
        return other._arrivalTime.difference(_arrivalTime) / SECONDS_PER_MINUTE;
        
    }
}
