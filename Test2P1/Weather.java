package test1;

public class Weather {
	private int temp;
	private String description;
	Weather(int temperature, String description){
		this.description = description;
		this.temp = temperature;
	}
	
	Weather(Weather other) {
		other = new Weather(temp, description);
	}
	
	
	public int getTemperature() {
		return temp;
	}

	public String getDescription() {
		return description;
	}
	
	
	public void setTemperature(int temperature) {
		this.temp = temperature;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + temp;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weather other = (Weather) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (temp != other.temp)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return temp + " degrees Celcius, " + description;
	}
	
	

}
