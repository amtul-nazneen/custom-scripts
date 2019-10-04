package app.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Utils {
	public static HashMap<String, String> abAcronym = new HashMap<String, String>();
	public static HashMap<String, String> cbAcronym = new HashMap<String, String>();

	public static void log(String message) {
		System.out.println(getTimestampForLog() + " " + message);
	}

	private static String getTimestampForLog() {
		LocalDateTime date = LocalDateTime.now(ZoneId.of(Constants.ZONE));
		return "[" + date.format(DateTimeFormatter.ofPattern(Constants.FORMAT)) + "]";
	}

	static {
		abAcronym.put("ANSI - ASQ National Accreditation Board (ANAB)", "ANAB");
		abAcronym.put("China National Accreditation Service for Conformity Assessment(CNAS)", "CNAS");
		abAcronym.put("Korea Accreditation Board", "KAB");
		abAcronym.put("Japan Accreditation Board (JAB)", "JAB");
		abAcronym.put("Akkreditierung Austria", "AA");
	}

	static {
		cbAcronym.put("Lloyds Register Quality Assurance Inc.", "LRQA");
		cbAcronym.put("DQS Inc.", "DQS");
		cbAcronym.put("DNV GL", "DNV GL");
		cbAcronym.put("NQA (National Quality Assurance)", "NQA USA");
		cbAcronym.put("Quality Systems Registrars, Inc.", "QSR");
		cbAcronym.put("Bureau Veritas Certification North America, Inc.", "BVC");
		cbAcronym.put("DEKRA Certification, Inc", "DEKRA");
		cbAcronym.put("Korean Foundation for Quality", "KFQ");
		cbAcronym.put("TUV SUD America, Inc.", "TUVAM");
		cbAcronym.put("QMI-SAI Canada Limited", "SAI");
		cbAcronym.put("Korea Quality Leader (KQL)", "KQL");
		cbAcronym.put("Japan Quality Assurance Organization - JQA", "JQA");
		cbAcronym.put("QA - Quality Austria", "QA");
		cbAcronym.put("Hong Kong Quality Assurance Agency (HKQAA)", "HKQAA");
		cbAcronym.put("CreBizQM Co., Ltd. (Korea)", "CreBiz QM");
		cbAcronym.put("International Standard Certification Co. Ltd", "KIC");
		cbAcronym.put("Small and Medium Business Corporation Registrar(SBCR)", "SBCR");
		cbAcronym.put("Orion Registrar, Inc.", "ORI");
		cbAcronym.put("Korea Quality Assurance (KQA)", "KQA");
		cbAcronym.put("Korea Productivity Center Quality Assurance - KPC-QA", "KPC-QA");
		// TODO
		cbAcronym.put("BSI Group", "TODO");
		cbAcronym.put("CEPREI Certification Body", "TODO");
		cbAcronym.put("Korea Management Registrar Inc.", "TODO");
		cbAcronym.put("Korean Standards Association", "TODO");
		cbAcronym.put("National Standards Authority of Ireland", "TODO");
		cbAcronym.put("Perry Johnson Registrars Inc.", "TODO");
		cbAcronym.put("SGS-CSTC Standards Technical Services Co., Ltd.", "TODO");
		cbAcronym.put("Universal Certifcation Centre Co., LTD. (UCC)", "TODO");
		cbAcronym.put("WIT Assessment Co., Ltd.", "TODO");
		cbAcronym.put("TÜV Rheinland (China) Ltd.", "TODO");

	}

	public static String getAbAcronym(String abName) {
		if (abAcronym.get(abName) == null || abAcronym.get(abName).isEmpty()) {
			return "";
		} else {
			return abAcronym.get(abName.trim());
		}
	}

	public static String getCbAcronym(String cbName) {
		if (cbAcronym.get(cbName) == null || cbAcronym.get(cbName).isEmpty() || "None".equalsIgnoreCase(cbName)) {
			return "";
		} else {
			return cbAcronym.get(cbName.trim());
		}
	}
}
