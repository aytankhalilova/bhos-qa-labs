package com.example.springproj1;

import org.json.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
class Springproj1ApplicationTests {

    public boolean isResponseJSONValid(String resp) {
        try {
            new JSONObject(resp);
        } catch (JSONException e) {
            try {
                new JSONArray(resp);
            } catch (JSONException ex) {
                return false;
            }
        }
        return true;
    }

    public void integrationTest(String url) {
        RestTemplate restTemp = new RestTemplate();
        ResponseEntity<String> res = restTemp.getForEntity(url, String.class);

        assertNotNull(res);
        assertSame(res.getStatusCode(), HttpStatus.OK);
        assertEquals(MediaType.APPLICATION_JSON, res.getHeaders().getContentType());
        assertTrue(isResponseJSONValid(res.getBody()));
    }

    @DisplayName("Integration Test for the Repos")
    @Test
    public void testSuccessfulResponseRepos() {
        integrationTest("https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos");
    }

    @DisplayName("Integration Test for the Branches")
    @Test
    public void testSuccessfulResponseBranches() {
        integrationTest("https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos/1/branches");
    }

    @DisplayName("Integration Test for the Commits")
    @Test
    public void testSuccessfulResponseCommits() {
        integrationTest("https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos/1/branches/1/commits");
    }
}