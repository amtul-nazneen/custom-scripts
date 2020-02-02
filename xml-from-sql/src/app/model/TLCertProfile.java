package app.model;

import java.util.ArrayList;
import java.util.Date;

import app.utils.Utils;

public class TLCertProfile {
	int tlid;
	String certificateIdentityNumber;
	String certificateNumber;
	String certificationStatus;
	String certificationType;
	String certificationScope;
	String certificationOriginalIssueDate;
	String certificationIssueDate;
	String certificationExpiryDate;
	ArrayList<TLCertProfileLocation> tcpLocations;
	String cbAccreditationStatus;
	String certifiedEntityName;
	String certifiedEntityTradingName;
	String certifiedEntityEnglishName;
	String certifiedEntityEmailAddress;
	String certifiedEntityKeyContact;
	String certifiedEntityPhone;
	String certifiedEntityUniqueID;
	String certifiedEntityStreet;
	String certifiedEntityCity;
	String certifiedEntityState;
	String certifiedEntityZipCode;
	String certifiedEntityCountry;
	String cbCompanyName;
	String abCompanyName;
	String cbAcronym;
	String abAcronym;
	String derivedCertificationStatus;
	Date certificationEndDate;
	String suspended;

	public int getTlid() {
		return tlid;
	}

	public void setTlid(int tlid) {
		this.tlid = tlid;
	}

	public String getCertificateIdentityNumber() {
		return certificateIdentityNumber;
	}

	public void setCertificateIdentityNumber(String certificateIdentityNumber) {
		this.certificateIdentityNumber = certificateIdentityNumber;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getCertificationStatus() {
		return certificationStatus;
	}

	public void setCertificationStatus(String certificationStatus) {
		this.certificationStatus = certificationStatus;
	}

	public String getCertificationType() {
		return certificationType;
	}

	public void setCertificationType(String certificationType) {
		this.certificationType = certificationType;
	}

	public String getCertificationScope() {
		if (certificationScope != null)
			return certificationScope.trim();
		else
			return certificationScope;
	}

	public void setCertificationScope(String certificationScope) {
		this.certificationScope = certificationScope;
	}

	public String getCertificationOriginalIssueDate() {
		return certificationOriginalIssueDate;
	}

	public void setCertificationOriginalIssueDate(String certificationOriginalIssueDate) {
		this.certificationOriginalIssueDate = certificationOriginalIssueDate;
	}

	public String getCertificationIssueDate() {
		return certificationIssueDate;
	}

	public void setCertificationIssueDate(String certificationIssueDate) {
		this.certificationIssueDate = certificationIssueDate;
	}

	public String getCertificationExpiryDate() {
		return certificationExpiryDate;
	}

	public void setCertificationExpiryDate(String certificationExpiryDate) {
		this.certificationExpiryDate = certificationExpiryDate;
	}

	public ArrayList<TLCertProfileLocation> getTcpLocations() {
		return tcpLocations;
	}

	public void setTcpLocations(ArrayList<TLCertProfileLocation> tcpLocations) {
		this.tcpLocations = tcpLocations;
	}

	public String getDerivedCertificationStatus() {
		return derivedCertificationStatus;
	}

	public Date getCertificationEndDate() {
		return certificationEndDate;
	}

	public void setCertificationEndDate(Date certificationEndDate) {
		this.certificationEndDate = certificationEndDate;
	}

	public String getSuspended() {
		return suspended;
	}

	public void setSuspended(String suspended) {
		this.suspended = suspended;
	}

	public void setDerivedCertificationStatus() {
		String formattedCertificationStatus = this.getCertificationStatus().substring(0, 1).toUpperCase()
				+ this.getCertificationStatus().substring(1);
		if (this.certificationEndDate != null && this.certificationEndDate.before(new Date())) {
			this.derivedCertificationStatus = formattedCertificationStatus + " - " + "Expired";
			if ("true".equalsIgnoreCase(suspended)) {
				this.derivedCertificationStatus = this.derivedCertificationStatus + " - " + "Suspended";
			}
		} else if ("true".equalsIgnoreCase(suspended)) {
			this.derivedCertificationStatus = formattedCertificationStatus + " - " + "Suspended";
		} else {
			this.derivedCertificationStatus = formattedCertificationStatus;
		}
	}

	public String getCertifiedEntityName() {
		return certifiedEntityName;
	}

	public void setCertifiedEntityName(String certifiedEntityName) {
		this.certifiedEntityName = certifiedEntityName;
	}

	public String getCertifiedEntityTradingName() {
		return certifiedEntityTradingName;
	}

	public void setCertifiedEntityTradingName(String certifiedEntityTradingNAme) {
		this.certifiedEntityTradingName = certifiedEntityTradingNAme;
	}

	public String getCertifiedEntityEnglishName() {
		return certifiedEntityEnglishName;
	}

	public void setCertifiedEntityEnglishName(String certifiedEntityEnglishName) {
		this.certifiedEntityEnglishName = certifiedEntityEnglishName;
	}

	public String getCertifiedEntityEmailAddress() {
		return certifiedEntityEmailAddress;
	}

	public void setCertifiedEntityEmailAddress(String certifiedEntityEmailAddress) {
		this.certifiedEntityEmailAddress = certifiedEntityEmailAddress;
	}

	public String getCertifiedEntityKeyContact() {
		return certifiedEntityKeyContact;
	}

	public void setCertifiedEntityKeyContact(String certifiedEntityKeyContact) {
		this.certifiedEntityKeyContact = certifiedEntityKeyContact;
	}

	public String getCertifiedEntityPhone() {
		if (certifiedEntityPhone == null)
			return "";
		else
			return certifiedEntityPhone;
	}

	public void setCertifiedEntityPhone(String certifiedEntityPhone) {
		this.certifiedEntityPhone = certifiedEntityPhone;
	}

	public String getCertifiedEntityUniqueID() {
		return certifiedEntityUniqueID;
	}

	public void setCertifiedEntityUniqueID(String certifiedEntityUniqueID) {
		this.certifiedEntityUniqueID = certifiedEntityUniqueID;
	}

	public String getCertifiedEntityStreet() {
		return certifiedEntityStreet;
	}

	public void setCertifiedEntityStreet(String certifiedEntityStreet) {
		this.certifiedEntityStreet = certifiedEntityStreet;
	}

	public String getCertifiedEntityCity() {
		return certifiedEntityCity;
	}

	public void setCertifiedEntityCity(String certifiedEntityCity) {
		this.certifiedEntityCity = certifiedEntityCity;
	}

	public String getCertifiedEntityState() {
		return certifiedEntityState;
	}

	public void setCertifiedEntityState(String certifiedEntityState) {
		this.certifiedEntityState = certifiedEntityState;
	}

	public String getCertifiedEntityZipCode() {
		return certifiedEntityZipCode;
	}

	public void setCertifiedEntityZipCode(String certifiedEntityZipCode) {
		this.certifiedEntityZipCode = certifiedEntityZipCode;
	}

	public String getCertifiedEntityCountry() {
		return certifiedEntityCountry;
	}

	public void setCertifiedEntityCountry(String certifiedEntityCountry) {
		this.certifiedEntityCountry = certifiedEntityCountry;
	}

	public String getCbCompanyName() {
		return cbCompanyName;
	}

	public void setCbCompanyName(String cbCompanyName) {
		this.cbCompanyName = cbCompanyName;
	}

	public String getAbCompanyName() {
		return abCompanyName;
	}

	public void setAbCompanyName(String abCompanyName) {
		this.abCompanyName = abCompanyName;
	}

	public String getCbAccreditationStatus() {
		return cbAccreditationStatus;
	}

	public void setCbAccreditationStatus(String cbAccreditationStatus) {
		this.cbAccreditationStatus = cbAccreditationStatus;
	}

	public String getCbAcronym(String cbName) {
		return Utils.getCbAcronym(cbName);
	}

	public String getAbAcronym(String abName) {
		return Utils.getAbAcronym(abName);
	}

	@Override
	public String toString() {
		return "TLCertProfile [tlid=" + tlid + ", certificateIdentityNumber=" + certificateIdentityNumber
				+ ", certificateNumber=" + certificateNumber + ", certificationStatus=" + certificationStatus
				+ ", certificationType=" + certificationType + ", certificationScope=" + certificationScope
				+ ", certificationOriginalIssueDate=" + certificationOriginalIssueDate + ", certificationIssueDate="
				+ certificationIssueDate + ", certificationExpiryDate=" + certificationExpiryDate + ", tcpLocations="
				+ tcpLocations + ", cbAccreditationStatus=" + cbAccreditationStatus + ", certifiedEntityName="
				+ certifiedEntityName + ", certifiedEntityTradingName=" + certifiedEntityTradingName
				+ ", certifiedEntityEnglishName=" + certifiedEntityEnglishName + ", certifiedEntityEmailAddress="
				+ certifiedEntityEmailAddress + ", certifiedEntityKeyContact=" + certifiedEntityKeyContact
				+ ", certifiedEntityPhone=" + certifiedEntityPhone + ", certifiedEntityUniqueID="
				+ certifiedEntityUniqueID + ", certifiedEntityStreet=" + certifiedEntityStreet
				+ ", certifiedEntityCity=" + certifiedEntityCity + ", certifiedEntityState=" + certifiedEntityState
				+ ", certifiedEntityZipCode=" + certifiedEntityZipCode + ", certifiedEntityCountry="
				+ certifiedEntityCountry + ", cbCompanyName=" + cbCompanyName + ", abCompanyName=" + abCompanyName
				+ ", cbAcronym=" + cbAcronym + ", abAcronym=" + abAcronym + ", derivedCertificationStatus="
				+ derivedCertificationStatus + ", certificationEndDate=" + certificationEndDate + ", suspended="
				+ suspended + "]";
	}

}
