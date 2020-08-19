package test;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * A class that represents a smart phone. Every smart is a telephone that has a
 * call log. A call log is a list of contacts that have been called using this
 * smart phone. The order of contacts in the call log are from the  
 * The smart phone and its call log form a composition.
 * 
 * @author EECS2030 Fall 2016-17
 * 
 */
public class SmartPhone2 extends Telephone {

    // ADD YOUR FIELDS HERE
	private long number;
	private List<Contact> callLog;
    
    

    /**
     * Initializes this smart phone given its telephone number.
     * The call log for this smart phone is initialized as an empty list.
     * 
     * 
     * @param number
     *            the telephone number of this phone
     * @throws IllegalArgumentException
     *             if number does not have 10 digits
     */
    public SmartPhone2(long number) {
        super(number);
        this.callLog = new ArrayList<Contact>();
        
    }

    /**
     * Initializes this smart phone by copying the telephone number and call log
     * of another smart phone.
     * 
     * @param other
     *            the smart phone to copy
     */
    public SmartPhone2(SmartPhone2 other) {
        this(other.number);
        //this(other.getNumber());
        this.callLog = new ArrayList<Contact>(other.callLog);
    }
    
    
    /**
     * Returns the call log for this phone. The call log for this phone cannot
     * be modified using the call log returned by this method.
     * 
     * @return the call log for this phone
     */
    public List<Contact> getCallLog() {
		return new ArrayList<Contact>(this.callLog);
        
    }
    
    @Override
    public void call(Contact contact) {
    	contact.getNumber();
    	callLog.add(contact);
    }
    
    public Contact lastCalled() {
    	if(callLog.isEmpty()) {
    		throw new NoSuchElementException();
    	}
    	Contact lastContact = callLog.get(this.callLog.size()-1);
    	return lastContact;
    	// return new Contact(this.callLog.get(this.callLog.size() - 1));
    }

	@Override
	public String toString() {
		return super.toString() + ", call log " + this.callLog;
	}

    
}
