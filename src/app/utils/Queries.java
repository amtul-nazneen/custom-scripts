package app.utils;

public class Queries {
	public static final String DATE_QUERY = "and year(tcp.cert_end_date) > 2021 ";
	public static final String ACTIVE_TL_PROFILES = "select  tp.tlid as tlid from tl9000_profile tp, tl9000_cert_profile tcp where tcp.tlid=tp.tlid and tp.profile_status='active'";
//	public static final String ACTIVE_TL_PROFILES = "select distinct tp.tlid as tlid from tl9000_profile tp, tl9000_cert_profile tcp where tcp.tlid=tp.tlid and tp.profile_status='active' and year(tcp.cert_end_date)>2019 and month(tcp.cert_end_date)=8 and tcp.tlid=7062";
	public static final String CERTIFICATION_LOCATION = "select distinct tcpl.tlid as tlid, tcpl.address as street, \r\n"
			+ "tcpl.city as city, \r\n" + "tcpl.state as state, \r\n" + "tcpl.zip as zip_code, \r\n"
			+ "tcpl.country as country\r\n" + "from tl9000_cert_profile_locations tcpl \r\n" + "where tcpl.tlid=";
	public static final String CERTIFICATION_PROFILES = " SELECT distinct tcp.tlid                                        AS tl900id,\r\n"
			+ "       tcp.certificate_label                           AS certificate_identity_number,\r\n"
			+ "       tcp.certificate_label                           AS certificate_number,\r\n"
			+ "       tcp.certification_status                        AS certification_status,\r\n"
			+ "       tcp.cert_end_date                               AS certification_end_date,\r\n"
			+ "       tcp.suspended                                   AS suspended,\r\n"
			+ "       \"Management System\"                             AS certification_type,\r\n"
			+ "       tcp.iso_scope                                   AS certification_scope,\r\n"
			+ "       Date_format(tcp.first_cert_date,'%Y%m%d')       AS certification_original_issue_date,\r\n"
			+ "       Date_format(tcp.current_cert_date,'%Y%m%d')     AS certification_issue_date,\r\n"
			+ "       Date_format(tcp.cert_end_date,'%Y%m%d')         AS certification_expiry_date,\r\n"
			+ "       tcp.registration_name                           AS certified_entity_name,\r\n"
			+ "       cmp.NAME                                        AS certified_entity_trading_name,\r\n"
			+ "       \"\"                                              AS certified_entity_english_name,\r\n"
			+ "       c.email                                         AS certified_entity_email_address,\r\n"
			+ "              Concat( c.first_name , ' ', c.last_name) AS certified_entity_key_contact,\r\n"
			+ "       cmp.phone                                       AS certified_entity_phone,\r\n"
			+ "       tcp.tlid                                        AS certified_entity_unique_id,\r\n"
			+ "       cmp.address                                     AS certified_entity_street,\r\n"
			+ "       cmp.city                                        AS certified_entity_city,\r\n"
			+ "       cmp.state                                       AS certified_entity_state,\r\n"
			+ "       cmp.zip                                         AS certified_entity_zip_code,\r\n"
			+ "       cmp.country                                     AS certified_entity_country,\r\n"
			+ "       a.cb_company_id                                 AS cb_company_id,\r\n"
			+ "       a.ab_company_id                                 AS ab_company_id,\r\n" + "       (\r\n"
			+ "              SELECT NAME\r\n" + "              FROM   company\r\n"
			+ "              WHERE  company_id=a.cb_company_id) AS cb_company_name,\r\n" + "       (\r\n"
			+ "              SELECT NAME\r\n" + "              FROM   company\r\n"
			+ "              WHERE  company_id=a.ab_company_id) AS ab_company_name,\r\n"
			+ "       e.NAME                                    AS role,\r\n"
			+ "       cba.status                                AS accreditation_status\r\n"
			+ "FROM   tl9000_cert_profile tcp,\r\n" + "       tl9000_profile a,\r\n" + "       users c,\r\n"
			+ "       user_tl9000_permissions d,\r\n" + "       permissions e,\r\n" + "       company cmp,\r\n"
			+ "       cb_accreditation cba\r\n" + "WHERE  a.tlid = tcp.tlid\r\n"
			+ "AND    a.company_id = c.company_id\r\n" + "AND    c.company_id=cmp.company_id\r\n"
			+ "AND    c.user_id =d.user_id\r\n" + "AND    d.tlid = a.tlid\r\n"
			+ "AND    cba.cb_company_id=tcp.cb_company_id\r\n" + "AND    a.profile_status = 'Active'\r\n"
			+ "AND    d.permission_id = e.id\r\n" + "AND    e.NAME IN ( 'TL_PRIMARY_ADMIN')\r\n" + "AND    tcp.tlid= ";

	public static final String CERTIFICATION_PROFILE_NOADMIN = " SELECT distinct tcp.tlid  AS tl900id,\r\n"
			+ "       tcp.certificate_label                           AS certificate_identity_number,\r\n"
			+ "       tcp.certificate_label                           AS certificate_number,\r\n"
			+ "       tcp.certification_status                        AS certification_status,\r\n"
			+ "       tcp.cert_end_date                               AS certification_end_date,\r\n"
			+ "       tcp.suspended                                   AS suspended,\r\n"
			+ "       \"Management System\"                             AS certification_type,\r\n"
			+ "       tcp.iso_scope                                   AS certification_scope,\r\n"
			+ "       Date_format(tcp.first_cert_date,'%Y%m%d')       AS certification_original_issue_date,\r\n"
			+ "       Date_format(tcp.current_cert_date,'%Y%m%d')     AS certification_issue_date,\r\n"
			+ "       Date_format(tcp.cert_end_date,'%Y%m%d')         AS certification_expiry_date,\r\n"
			+ "       tcp.registration_name                           AS certified_entity_name,\r\n"
			+ "       cmp.NAME                                        AS certified_entity_trading_name,\r\n"
			+ "       \"\"                                              AS certified_entity_english_name,\r\n"
			+ "       cmp.phone                                       AS certified_entity_phone,\r\n"
			+ "       tcp.tlid                                        AS certified_entity_unique_id,\r\n"
			+ "       cmp.address                                     AS certified_entity_street,\r\n"
			+ "       cmp.city                                        AS certified_entity_city,\r\n"
			+ "       cmp.state                                       AS certified_entity_state,\r\n"
			+ "       cmp.zip                                         AS certified_entity_zip_code,\r\n"
			+ "       cmp.country                                     AS certified_entity_country,\r\n"
			+ "       a.cb_company_id                                 AS cb_company_id,\r\n"
			+ "       a.ab_company_id                                 AS ab_company_id,\r\n" + "       (\r\n"
			+ "              SELECT NAME\r\n" + "              FROM   company\r\n"
			+ "              WHERE  company_id=a.cb_company_id) AS cb_company_name,\r\n" + "       (\r\n"
			+ "              SELECT NAME\r\n" + "              FROM   company\r\n"
			+ "              WHERE  company_id=a.ab_company_id) AS ab_company_name,\r\n"
			+ "       cba.status                                AS accreditation_status\r\n"
			+ "FROM   tl9000_cert_profile tcp,\r\n" + "       tl9000_profile a,\r\n" + "       company cmp,\r\n"
			+ "       cb_accreditation cba\r\n" + "WHERE  a.tlid = tcp.tlid\r\n"
			+ "AND    a.company_id = cmp.company_id\r\n" + "AND    cba.cb_company_id=tcp.cb_company_id\r\n"
			+ "AND    a.profile_status = 'Active'\r\n" + "AND    tcp.tlid=";

	public static void main(String[] args) {
		System.out.println(CERTIFICATION_PROFILE_NOADMIN);
	}

}
