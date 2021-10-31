package com.springproj4.springproj4;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Springproj4ApplicationTests {

	@Test
	void test() throws JSONException {

		String url = "https://api.nytimes.com/svc/books/v3/lists.json?list=Combined%20Print%20and%20E-Book%20Nonfiction&api-key=5v9CdwmY19krcRHV1Af1DjUevAfZpAjG";

		TestRestTemplate restTemp = new TestRestTemplate();
		HttpHeaders httpHdrs = new HttpHeaders();
		HttpEntity<String> units;
		units = new HttpEntity<String>(null, httpHdrs);
		var response = restTemp.exchange(url, HttpMethod.GET, units, String.class);

		JSONObject jsonObj;
		jsonObj = new JSONObject(response.getBody());
		JSONArray books;
		books = jsonObj.getJSONArray("results");

		int c = 1; boolean result;
		result = true;
		for ( int i = 0; i < books.length(); i++ ) {
			JSONObject book = (JSONObject) books.get(i);
			JSONArray bookDetailsArr = book.getJSONArray("book_details");
			JSONObject bookDetails = (JSONObject) bookDetailsArr.get(0);
			int bookRank = (int) book.get("rank");
			String bookTitle = bookDetails.getString("title");

			if ( bookTitle.isEmpty() || bookRank != c ) {
				result = false;
				break;
			}
		}

		assertTrue(result);
	}

}
