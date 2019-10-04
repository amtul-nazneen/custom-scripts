package app.xml;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import app.model.TLCertProfile;
import app.model.TLCertProfileLocation;
import app.utils.Constants;

public class XMLBuilder {

	public static void createXML(ArrayList<TLCertProfile> tcpList) {
		try {

			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();

			// root element
			Element root = document.createElement("cb_certs");
			document.appendChild(root);
			for (TLCertProfile tcp : tcpList) {
				Element tcpMain = document.createElement("certification");
				root.appendChild(tcpMain);

				Element certificate_identity_number = document.createElement("certificate_identity_number");
				certificate_identity_number
						.appendChild(document.createTextNode(String.valueOf(tcp.getCertificateIdentityNumber())));
				tcpMain.appendChild(certificate_identity_number);

				Element certificate_number = document.createElement("certificate_number");
				certificate_number.appendChild(document.createTextNode(String.valueOf(tcp.getCertificateNumber())));
				tcpMain.appendChild(certificate_number);

				Element certification_status = document.createElement("certification_status");
				certification_status
						.appendChild(document.createTextNode(String.valueOf(tcp.getDerivedCertificationStatus())));
				tcpMain.appendChild(certification_status);

				Element accreditation_status = document.createElement("accreditation_status");
				accreditation_status
						.appendChild(document.createTextNode(String.valueOf(tcp.getCbAccreditationStatus())));
				tcpMain.appendChild(accreditation_status);

				Element certification_type = document.createElement("certification_type");
				certification_type.appendChild(document.createTextNode(String.valueOf(tcp.getCertificationType())));
				tcpMain.appendChild(certification_type);

				Element certification_scope = document.createElement("certification_scope");
				certification_scope.appendChild(document.createTextNode(String.valueOf(tcp.getCertificationScope())));
				tcpMain.appendChild(certification_scope);

				Element certification_original_issue_date = document.createElement("certification_original_issue_date");
				certification_original_issue_date
						.appendChild(document.createTextNode(String.valueOf(tcp.getCertificationOriginalIssueDate())));
				tcpMain.appendChild(certification_original_issue_date);

				Element certification_issue_date = document.createElement("certification_issue_date");
				certification_issue_date
						.appendChild(document.createTextNode(String.valueOf(tcp.getCertificationIssueDate())));
				tcpMain.appendChild(certification_issue_date);

				Element certification_expiry_date = document.createElement("certification_expiry_date");
				certification_expiry_date
						.appendChild(document.createTextNode(String.valueOf(tcp.getCertificationExpiryDate())));
				tcpMain.appendChild(certification_expiry_date);

				Element certified_entity_name = document.createElement("certified_entity_name");
				certified_entity_name
						.appendChild(document.createTextNode(String.valueOf(tcp.getCertifiedEntityName())));
				tcpMain.appendChild(certified_entity_name);

				Element certified_entity_trading_name = document.createElement("certified_entity_trading_name");
				certified_entity_trading_name
						.appendChild(document.createTextNode(String.valueOf(tcp.getCertifiedEntityTradingName())));
				tcpMain.appendChild(certified_entity_trading_name);

				Element certified_entity_english_name = document.createElement("certified_entity_english_name");
				certified_entity_english_name
						.appendChild(document.createTextNode(String.valueOf(tcp.getCertifiedEntityEnglishName())));
				tcpMain.appendChild(certified_entity_english_name);

				Element certified_entity_email_address = document.createElement("certified_entity_email_address");
				/*
				 * certified_entity_email_address
				 * .appendChild(document.createTextNode(String.valueOf(tcp.
				 * getCertifiedEntityEmailAddress())));
				 */
				certified_entity_email_address.appendChild(document.createTextNode(""));
				tcpMain.appendChild(certified_entity_email_address);

				Element certified_entity_key_contact = document.createElement("certified_entity_key_contact");
				/*
				 * certified_entity_key_contact
				 * .appendChild(document.createTextNode(String.valueOf(tcp.
				 * getCertifiedEntityKeyContact())));
				 */
				certified_entity_key_contact.appendChild(document.createTextNode(""));
				tcpMain.appendChild(certified_entity_key_contact);

				Element certified_entity_phone = document.createElement("certified_entity_phone");
				certified_entity_phone
						.appendChild(document.createTextNode(String.valueOf(tcp.getCertifiedEntityPhone())));
				tcpMain.appendChild(certified_entity_phone);

				Element certified_entity_unique_id = document.createElement("certified_entity_unique_id");
				certified_entity_unique_id
						.appendChild(document.createTextNode(String.valueOf(tcp.getCertifiedEntityUniqueID())));
				tcpMain.appendChild(certified_entity_unique_id);

				Element certified_entity_street = document.createElement("certified_entity_street");
				certified_entity_street
						.appendChild(document.createTextNode(String.valueOf(tcp.getCertifiedEntityStreet())));
				tcpMain.appendChild(certified_entity_street);

				Element certified_entity_city = document.createElement("certified_entity_city");
				certified_entity_city
						.appendChild(document.createTextNode(String.valueOf(tcp.getCertifiedEntityCity())));
				tcpMain.appendChild(certified_entity_city);

				Element certified_entity_state = document.createElement("certified_entity_state");
				certified_entity_state
						.appendChild(document.createTextNode(String.valueOf(tcp.getCertifiedEntityState())));
				tcpMain.appendChild(certified_entity_state);

				Element certified_entity_zip_code = document.createElement("certified_entity_zip_code");
				certified_entity_zip_code
						.appendChild(document.createTextNode(String.valueOf(tcp.getCertifiedEntityZipCode())));
				tcpMain.appendChild(certified_entity_zip_code);

				Element certified_entity_country = document.createElement("certified_entity_country");
				certified_entity_country
						.appendChild(document.createTextNode(String.valueOf(tcp.getCertifiedEntityCountry())));
				tcpMain.appendChild(certified_entity_country);

				Element certification_body_name = document.createElement("certification_body_name");
				certification_body_name.appendChild(document.createTextNode(String.valueOf(tcp.getCbCompanyName())));
				tcpMain.appendChild(certification_body_name);

				Element certification_body_acronym = document.createElement("certification_body_acronym");
				certification_body_acronym
						.appendChild(document.createTextNode(String.valueOf(tcp.getCbAcronym(tcp.getCbCompanyName()))));
				tcpMain.appendChild(certification_body_acronym);

				Element accreditation_body_name = document.createElement("accreditation_body_name");
				accreditation_body_name.appendChild(document.createTextNode(String.valueOf(tcp.getAbCompanyName())));
				tcpMain.appendChild(accreditation_body_name);

				Element accreditation_body_acronym = document.createElement("accreditation_body_acronym");
				accreditation_body_acronym
						.appendChild(document.createTextNode(String.valueOf(tcp.getAbAcronym(tcp.getAbCompanyName()))));
				tcpMain.appendChild(accreditation_body_acronym);

				/* Additional Sites */
				Element certification_additional_sites = document.createElement("certification_additional_sites");
				tcpMain.appendChild(certification_additional_sites);

				for (TLCertProfileLocation tcploc : tcp.getTcpLocations()) {
					Element additional_site = document.createElement("additional_site");
					certification_additional_sites.appendChild(additional_site);

					Element street = document.createElement("street");
					street.appendChild(document.createTextNode(String.valueOf(tcploc.getStreet())));
					additional_site.appendChild(street);

					Element city = document.createElement("city");
					city.appendChild(document.createTextNode(tcploc.getCity()));
					additional_site.appendChild(city);

					Element zip_code = document.createElement("zip_code");
					zip_code.appendChild(document.createTextNode(tcploc.getZipCode()));
					additional_site.appendChild(zip_code);

					Element country = document.createElement("country");
					country.appendChild(document.createTextNode(tcploc.getCountry()));
					additional_site.appendChild(country);

					Element scope = document.createElement("scope");
					scope.appendChild(document.createTextNode(""));
					additional_site.appendChild(scope);
				}
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(Constants.XML_FILEPATH));
			transformer.transform(domSource, streamResult);

			/* To output to the console */
			/// StreamResult consoleResult = new StreamResult(System.out);
			// transformer.transform(domSource, consoleResult);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}

}
