package test;

import java.util.ArrayList;
import java.util.List;

/**
 * A combination lock is a special kind of lock.  Each combination lock
 * has a combination.  The combination lock and its combination
 * form a composition.
 *
 */
public class CombinationLock extends Lock {
	private List<Integer> combination;
	private Lock open;
    /**
     * Initializes this combination lock to be open and have the given combination.
     * 
     * @param combination the combination of this combination lock.
     * @pre. combination != null
     */
    public CombinationLock(List<Integer> combinatiaon) {
    	super();
//    	if(combination != null) {
//    		this.combination = combination;
//    		open.isOpen();
//    	}
    	this.setCombination(combinatiaon);
//    	 OR
//		this.combination = combination;
    }

    /**
     * Returns the combination of this combination lock.
     * 
     * @return the combination  of this combination lock.
     */
    public List<Integer> getCombination() {
//		return this.combination;
    	return new ArrayList<Integer>(combination);
    }

    /**
     * Sets the combination of this combination lock to the 
     * given combination.
     * 
     * @param combination the new combination of this
     * combination lock.
     * @pre. combination != null
     */
    public void setCombination(List<Integer> combination) {
//    	this.combination = combination;
    	this.combination = new ArrayList<Integer>(combination);
    }

    /**
     * Tests whether this combination lock is the same as the given object.
     * Two combination locks are the same if they are either both open or
     * both closed and have the same combination.
     * 
     * @param object an object.
     * @return true if this lock is the same as the given object,
     * false otherwise.
     */
    public boolean equals(Object object) {
    	boolean result = false;
    	
    	if(object.equals(open)) {
    		result = true;
    	}
    	return result;
    	
    }

    /**
     * Returns the hash code of this lock.
     * 
     * @return the sum of the digits of the combination of this combination lock
     * if this combination lock is open, the sum of the digits of the combination 
     * of this combination lock plus 1 if this lock is closed.
     */
    public int hashCode() {
    	final int prime = 31;
    	int result = super.hashCode();
    	result = prime * result + ((combination == null) ? 0 : combination.hashCode());
    	result = prime * result + ((open == null) ? 0 : open.hashCode());
    	return result;

    }
}
