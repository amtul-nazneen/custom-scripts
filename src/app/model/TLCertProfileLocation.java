package app.model;

public class TLCertProfileLocation {
	int tlid;
	String street;
	String city;
	String state;
	String zipCode;
	String country;

	public TLCertProfileLocation(String street, String city, String state, String zipCode, String country) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
	}

	public int getTlid() {
		return tlid;
	}

	public void setTlid(int tlid) {
		this.tlid = tlid;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "TLCertProfileLocation [tlid=" + tlid + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + ", country=" + country + "]";
	}

}
