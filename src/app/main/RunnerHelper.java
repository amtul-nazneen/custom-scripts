package app.main;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import app.jdbc.MySQLConnect;
import app.model.TLCertProfile;
import app.model.TLCertProfileLocation;

public class RunnerHelper {
	public static String TEST_NOADMIN_1 = "select d.tlid from user_tl9000_permissions d, permissions e where d.permission_id = e.id and d.tlid=";
	public static String TEST_NOADMIN_2 = " and permission_id=12";
	public static String TEST_NOCERT = "select tlid from tl9000_cert_profile where tlid=";

	public static ArrayList<String> getActiveTLProfiles(ResultSet rs) throws Exception {
		ArrayList<String> activeTlProfile = new ArrayList<String>();
		while (rs.next()) {
			String tlid = rs.getString("tlid");
			activeTlProfile.add(tlid);
		}
		return activeTlProfile;
	}

	public static ArrayList<TLCertProfileLocation> getTLCertProfileLocations(ResultSet rs) throws Exception {
		ArrayList<TLCertProfileLocation> tcplocations = new ArrayList<TLCertProfileLocation>();
		while (rs.next()) {
			String street = rs.getString("street");
			String city = rs.getString("city");
			String state = rs.getString("state");
			String zip_code = rs.getString("zip_code");
			String country = rs.getString("country");
			TLCertProfileLocation tcpl = new TLCertProfileLocation(street, city, state, zip_code, country);
			tcplocations.add(tcpl);
		}
		return tcplocations;
	}

	public static TLCertProfile getTLCertificationProfiles(ResultSet rs) throws Exception {
		TLCertProfile tcp = new TLCertProfile();
		while (rs.next()) {
			int tl900id = rs.getInt("tl900id");
			// System.out.println(tl900id);
			String certificate_identity_number = rs.getString("certificate_identity_number");
			String certificate_number = rs.getString("certificate_number");
			String certification_status = rs.getString("certification_status");
			String certification_type = rs.getString("certification_type");
			String certification_scope = rs.getString("certification_scope");
			String certification_original_issue_date = rs.getString("certification_original_issue_date");
			String certification_issue_date = rs.getString("certification_issue_date");
			String certification_expiry_date = rs.getString("certification_expiry_date");
			Date certification_end_date = rs.getDate("certification_end_date");
			String suspended = rs.getString("suspended");
			String certified_entity_name = rs.getString("certified_entity_name");
			String certified_entity_trading_name = rs.getString("certified_entity_trading_name");
			String certified_entity_english_name = rs.getString("certified_entity_english_name");
			String certified_entity_email_address = rs.getString("certified_entity_email_address");
			String certified_entity_key_contact = rs.getString("certified_entity_key_contact");
			String certified_entity_phone = rs.getString("certified_entity_phone");
			String certified_entity_unique_id = rs.getString("certified_entity_unique_id");
			String certified_entity_street = rs.getString("certified_entity_street");
			String certified_entity_city = rs.getString("certified_entity_city");
			String certified_entity_state = rs.getString("certified_entity_state");
			String certified_entity_zip_code = rs.getString("certified_entity_zip_code");
			String certified_entity_country = rs.getString("certified_entity_country");
			String cb_company_name = rs.getString("cb_company_name");
			String ab_company_name = rs.getString("ab_company_name");
			String accreditation_status = rs.getString("accreditation_status");

			tcp.setTlid(tl900id);
			tcp.setCertificateIdentityNumber(certificate_identity_number);
			tcp.setCertificateNumber(certificate_number);
			tcp.setCertificationStatus(certification_status);
			tcp.setCertificationType(certification_type);
			tcp.setCertificationScope(certification_scope);
			tcp.setCertificationOriginalIssueDate(certification_original_issue_date);
			tcp.setCertificationIssueDate(certification_issue_date);
			tcp.setCertificationExpiryDate(certification_expiry_date);
			tcp.setCertificationEndDate(certification_end_date);
			tcp.setSuspended(suspended);
			tcp.setDerivedCertificationStatus();
			tcp.setCertifiedEntityName(certified_entity_name);
			tcp.setCertifiedEntityTradingName(certified_entity_trading_name);
			tcp.setCertifiedEntityEnglishName(certified_entity_english_name);
			tcp.setCertifiedEntityEmailAddress(certified_entity_email_address);
			tcp.setCertifiedEntityKeyContact(certified_entity_key_contact);
			tcp.setCertifiedEntityPhone(certified_entity_phone);
			tcp.setCertifiedEntityUniqueID(certified_entity_unique_id);
			tcp.setCertifiedEntityStreet(certified_entity_street);
			tcp.setCertifiedEntityCity(certified_entity_city);
			tcp.setCertifiedEntityState(certified_entity_state);
			tcp.setCertifiedEntityZipCode(certified_entity_zip_code);
			tcp.setCertifiedEntityCountry(certified_entity_country);
			tcp.setCbCompanyName(cb_company_name);
			tcp.setAbCompanyName(ab_company_name);
			tcp.setCbAccreditationStatus(accreditation_status);
		}
		return tcp;
	}

	public static TLCertProfile getTLCertificationProfilesNoAdmin(ResultSet rs) throws Exception {
		TLCertProfile tcp = new TLCertProfile();
		while (rs.next()) {
			int tl900id = rs.getInt("tl900id");
			String certificate_identity_number = rs.getString("certificate_identity_number");
			String certificate_number = rs.getString("certificate_number");
			String certification_status = rs.getString("certification_status");
			String certification_type = rs.getString("certification_type");
			String certification_scope = rs.getString("certification_scope");
			String certification_original_issue_date = rs.getString("certification_original_issue_date");
			String certification_issue_date = rs.getString("certification_issue_date");
			String certification_expiry_date = rs.getString("certification_expiry_date");
			Date certification_end_date = rs.getDate("certification_end_date");
			String suspended = rs.getString("suspended");
			String certified_entity_name = rs.getString("certified_entity_name");
			String certified_entity_trading_name = rs.getString("certified_entity_trading_name");
			String certified_entity_english_name = rs.getString("certified_entity_english_name");
			String certified_entity_phone = rs.getString("certified_entity_phone");
			String certified_entity_unique_id = rs.getString("certified_entity_unique_id");
			String certified_entity_street = rs.getString("certified_entity_street");
			String certified_entity_city = rs.getString("certified_entity_city");
			String certified_entity_state = rs.getString("certified_entity_state");
			String certified_entity_zip_code = rs.getString("certified_entity_zip_code");
			String certified_entity_country = rs.getString("certified_entity_country");
			String cb_company_name = rs.getString("cb_company_name");
			String ab_company_name = rs.getString("ab_company_name");
			String accreditation_status = rs.getString("accreditation_status");

			tcp.setTlid(tl900id);
			tcp.setCertificateIdentityNumber(certificate_identity_number);
			tcp.setCertificateNumber(certificate_number);
			tcp.setCertificationStatus(certification_status);
			tcp.setCertificationType(certification_type);
			tcp.setCertificationScope(certification_scope);
			tcp.setCertificationOriginalIssueDate(certification_original_issue_date);
			tcp.setCertificationIssueDate(certification_issue_date);
			tcp.setCertificationExpiryDate(certification_expiry_date);
			tcp.setCertificationEndDate(certification_end_date);
			tcp.setSuspended(suspended);
			tcp.setDerivedCertificationStatus();
			tcp.setCertifiedEntityName(certified_entity_name);
			tcp.setCertifiedEntityTradingName(certified_entity_trading_name);
			tcp.setCertifiedEntityEnglishName(certified_entity_english_name);
			tcp.setCertifiedEntityPhone(certified_entity_phone);
			tcp.setCertifiedEntityUniqueID(certified_entity_unique_id);
			tcp.setCertifiedEntityStreet(certified_entity_street);
			tcp.setCertifiedEntityCity(certified_entity_city);
			tcp.setCertifiedEntityState(certified_entity_state);
			tcp.setCertifiedEntityZipCode(certified_entity_zip_code);
			tcp.setCertifiedEntityCountry(certified_entity_country);
			tcp.setCbCompanyName(cb_company_name);
			tcp.setAbCompanyName(ab_company_name);
			tcp.setCbAccreditationStatus(accreditation_status);
		}
		return tcp;
	}

	public static ArrayList<String> getNoAdminProfile(ArrayList<String> activeTlProfile) throws Exception {
		MySQLConnect dbConn = MySQLConnect.getDbCon();
		ArrayList<String> noAdminProfiles = new ArrayList<String>();
		ResultSet rs = null;
		for (String tlid : activeTlProfile) {
			rs = dbConn.query(getNoAdminQuery(tlid));
			if (!rs.next()) {
				noAdminProfiles.add(tlid);
			}
		}
		return noAdminProfiles;
	}

	public static ArrayList<String> removeNoAdminProfile(ArrayList<String> activeTlProfile,
			ArrayList<String> noAdminProfile) throws Exception {
		ArrayList<String> activeTlProfileNew = new ArrayList<String>();
		activeTlProfileNew = (ArrayList<String>) activeTlProfile.clone();
		for (String tlid : noAdminProfile) {
			activeTlProfileNew.remove(tlid);

		}
		return activeTlProfileNew;
	}

	public static String getNoAdminQuery(String tlid) {
		return TEST_NOADMIN_1 + tlid + TEST_NOADMIN_2;
	}

	public static String getCertProfileQuery(String tlid) {
		return TEST_NOCERT + tlid;
	}
}
