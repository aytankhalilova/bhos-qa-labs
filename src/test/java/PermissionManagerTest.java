import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.lang.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

class PermissionManagerTest {
    PermissionManager permissionManager;

    @BeforeEach
    void setUp() {
        permissionManager = new PermissionManager();
    }

    @Test
    @DisplayName("Test for getPermissionLevel method")
    void testGetPermissionLevel() {
        assertEquals("USER", permissionManager.getPermissionLevel(), "Default role is User");
    }

    @Test
    @DisplayName("Test for get_and_setPermissionLevel method")
    void testGet_And_SetPermissionLevel() {
        var ht = new Hashtable<PermissionLevel, String>();

        ht.put(PermissionLevel.USER, "USER");
        ht.put(PermissionLevel.DEVELOPER, "DEVELOPER");
        ht.put(PermissionLevel.ADMIN, "ADMIN");

        ht.forEach((key, value) -> {
            permissionManager.get_and_setPermissionLevel(key);
            assertEquals(value, permissionManager.getPermissionLevel(), "after setting role to" + key + "case"  + value + "should be returned" );
        });
    }

}