package app.main;

import java.sql.ResultSet;
import java.util.ArrayList;

import app.jdbc.MySQLConnect;
import app.model.TLCertProfile;
import app.model.TLCertProfileLocation;
import app.utils.Constants;
import app.utils.Queries;
import app.utils.Utils;
import app.xml.XMLBuilder;

public class Runner {
	public static void main(String[] args) {
		try {
			MySQLConnect dbConn = MySQLConnect.getDbCon();
			ArrayList<String> activeTlProfile = null;
			ArrayList<String> activeTlProfileNoAdmin = null;
			ArrayList<TLCertProfile> tlProfiles = new ArrayList<TLCertProfile>();
			ResultSet rs = null;

			rs = dbConn.query(Queries.ACTIVE_TL_PROFILES);
			activeTlProfile = RunnerHelper.getActiveTLProfiles(rs);
			Utils.log("Active TL900 Certification Profile(s): " + activeTlProfile.size());
			activeTlProfileNoAdmin = RunnerHelper.getNoAdminProfile(activeTlProfile);
			Utils.log("No Admin Active TL900 Certification Profile(s): " + activeTlProfileNoAdmin.size());
			activeTlProfile = RunnerHelper.removeNoAdminProfile(activeTlProfile, activeTlProfileNoAdmin);
			Utils.log("After Filter, admin TL900 Certification Profile(s): " + activeTlProfile.size());
			for (String tlid : activeTlProfile) {
				TLCertProfile tcp = null;
				ArrayList<TLCertProfileLocation> tcplocations = null;

				rs = dbConn.query(Queries.CERTIFICATION_PROFILES + tlid);
				tcp = RunnerHelper.getTLCertificationProfiles(rs);

				rs = dbConn.query(Queries.CERTIFICATION_LOCATION + tlid);
				tcplocations = RunnerHelper.getTLCertProfileLocations(rs);
				tcp.setTcpLocations(tcplocations);

				tlProfiles.add(tcp);
			}

			Utils.log("Total Profiles with admin: " + tlProfiles.size());

			for (String tlid : activeTlProfileNoAdmin) {
				TLCertProfile tcp = null;
				ArrayList<TLCertProfileLocation> tcplocations = null;

				rs = dbConn.query(Queries.CERTIFICATION_PROFILE_NOADMIN + tlid);
				tcp = RunnerHelper.getTLCertificationProfilesNoAdmin(rs);

				rs = dbConn.query(Queries.CERTIFICATION_LOCATION + tlid);
				tcplocations = RunnerHelper.getTLCertProfileLocations(rs);
				tcp.setTcpLocations(tcplocations);

				tlProfiles.add(tcp);
			}

			Utils.log("Total Profiles adding without admin: " + tlProfiles.size());
			XMLBuilder.createXML(tlProfiles);
			Utils.log("XML Generated at: " + Constants.XML_FILEPATH);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
