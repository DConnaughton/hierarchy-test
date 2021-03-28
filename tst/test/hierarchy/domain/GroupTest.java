package test.hierarchy.domain;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    final Integer TEST_ID = 1;
    final String TEST_NAME = "TEST";
    final Integer TEST_PARENTID = 2;

    @org.junit.jupiter.api.Test
    void testGettersSetters() {
        Group testGroup = new Group();

        assertEquals(null, testGroup.getId());
        assertEquals(null, testGroup.getName());
        assertEquals(null, testGroup.getParentId());

        testGroup.setId(TEST_ID);
        testGroup.setName(TEST_NAME);
        testGroup.setParentId(TEST_PARENTID);

        assertEquals(TEST_ID, testGroup.getId());
        assertEquals(TEST_NAME, testGroup.getName());
        assertEquals(TEST_PARENTID, testGroup.getParentId());
    }
}