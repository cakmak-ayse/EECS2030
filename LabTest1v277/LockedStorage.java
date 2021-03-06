package labTest1;
/** The class implements an object that allows protecting the stored content via a password
 * @author Andriy
 * TODO complete the implementation of the class (constructors, methods...)
 */
public class LockedStorage {

	private String password;
	private String content;
	private boolean lock;

	
	/** Creates an object with a specified password
	 * and an empty content (an  empty string)
	 * The object should be in an "unlocked" state
	 * @param password
	 */
	public LockedStorage(String password) {
		this.password = password;
		content = "";
		
	}

	/** Creates  an object with a specified password
	 * and the specified  content
	 * The object should be in an "unlocked" state
	 * @param password
	 * @param content
	 */
	public LockedStorage(String password, String content) {
		this.password = password;
		this.content = content;
	}
	
	/**Set the contents of the object to a new value
	 * @param content new content
	 * @return true if the operations is successful, else false
	 * or throw a LockedStorageException if the object is locked 
	 */
	public boolean setContent(String content){
		
		
		if(!lock) {
			this.content = content;
			return true;	
		} else throw new LockedStorageException();

	}
	
	/**Get the contents of the object
	 * @return the contents of the object
	 * or throw a LockedStorageException if the object is locked
	 */
	public String getContent(){
		if(!lock) {
			return this.content;
		}
		else throw new LockedStorageException();

	}
	
	/**Changes the  password of the object
	 * @param password new password
	 * or throw a LockedStorageException if the object is locked
	 */
	public void setPassword(String password){
		if(!lock) {
			this.password = password;
		} 
		else throw new LockedStorageException(); 
		
	}
	
	/** Locks the object
	 *  No effect if the object is already locked 
	 */
	public void lock(){
		lock = true;
	}
	
	/**Unlocks the object, to enable accessing and updating the content
	 * @param password the password to unlock
	 * @return true if  the password was correct, false otherwise
	 */
	public boolean unlock(String password){
		if(password.equals(this.password)) {
			lock = false;
			return true;
		}
		return false;
	}
	
	/**Return the state of the object
	 * true - locked
	 * false - unlocked
	 * @return the object state
	 */
	public boolean isLocked(){
//		if(lock) {
//			return true;
//		}
//		return false;
		return this.lock;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * returns a string representation of the object
	 * "LOCKED" if the object is locked
	 * "Content:" followed by a new line character 
	 * and the actual content otherwise
	 */
	@Override
	public String toString(){
		if (!lock) {
			return "Content:\n" + this.content;
		} 
		else return "LOCKED";
	}
	
}
