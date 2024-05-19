package test.java.ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DevOpsToolsTest {

    private DevOpsTools devOpsTools;

    @BeforeEach
    void setUp() {
        devOpsTools = new DevOpsTools();
    }

    @Test
    void testAddTool() {
        devOpsTools.addTool("Docker");
        assertTrue(devOpsTools.containsTool("Docker"));
    }

    @Test
    void testGetTools() {
        devOpsTools.addTool("Docker");
        devOpsTools.addTool("Kubernetes");
        assertEquals(2, devOpsTools.getTools().size());
        assertTrue(devOpsTools.getTools().contains("Docker"));
        assertTrue(devOpsTools.getTools().contains("Kubernetes"));
    }

    @Test
    void testContainsTool() {
        devOpsTools.addTool("Jenkins");
        assertTrue(devOpsTools.containsTool("Jenkins"));
        assertFalse(devOpsTools.containsTool("Ansible"));
    }
}
