package com.springproj2.springproj2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import javax.net.ssl.HttpsURLConnection;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Springproj2ApplicationTests {

	public String u = "https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos";

	@Test
	void test1() throws CertificateException, IOException {
		URL ul = new URL(this.u);
		URLConnection conn = ul.openConnection();
		HttpsURLConnection sec_conn = (HttpsURLConnection) conn;
		sec_conn.connect();

		Certificate[] certifies;
		certifies = sec_conn.getServerCertificates();
		FileInputStream fis = new FileInputStream("mockapicert.cer");
		CertificateFactory cert_f = CertificateFactory.getInstance("X509");
		X509Certificate cert = (X509Certificate) cert_f.generateCertificate(fis);
		assertEquals(cert, certifies[0]);
	}

	@Test
	void test2() throws JSONException {
		TestRestTemplate restTemplate = new TestRestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<String> res = restTemplate.exchange(this.u, HttpMethod.GET, entity, String.class);

		JSONArray rep_ls = new JSONArray(res.getBody());
		Set<String> ids = new HashSet<>();
		Set<String> names = new HashSet<>();

		for (int i = 0; i < rep_ls.length(); i++) {
			JSONObject obj = (JSONObject) rep_ls.get(i);
			ids.add(obj.getString("id"));
			names.add(obj.getString("name"));
		}

		boolean isUnique = ids.size() == rep_ls.length() && names.size() == rep_ls.length();

		assertTrue(isUnique);
	}


}
