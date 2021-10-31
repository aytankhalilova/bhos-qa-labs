package com.example.springproj3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.ExecutionException;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
public class FirebaseTest {

    @Test
    public void testingSave() throws ExecutionException, InterruptedException {
        Architecture postedArchitecture = new Architecture("Basílica de la Sagrada Família", "Antoni Gaudí");
        ArchitectureService.saveArchitecture(postedArchitecture);

        Architecture theArchitecture = ArchitectureService.getArchitectureInfo("Basílica de la Sagrada Família");

        assertEquals(postedArchitecture.name, theArchitecture.name);
        assertEquals(postedArchitecture.architect, theArchitecture.architect);
    }

}
