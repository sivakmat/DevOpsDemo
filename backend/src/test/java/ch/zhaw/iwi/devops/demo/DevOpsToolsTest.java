package test.java.ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DevOpsToolsTest {

    private DevOpsTools devOpsTools;

    @BeforeEach
    public void setUp() {
        devOpsTools = new DevOpsTools();
    }

    @Test
    public void testAddTool() {
        devOpsTools.addTool("Docker");
        assertTrue(devOpsTools.containsTool("Docker"));
    }

    @Test
    public void testGetTools() {
        devOpsTools.addTool("Docker");
        devOpsTools.addTool("Kubernetes");
        assertEquals(2, devOpsTools.getTools().size());
        assertTrue(devOpsTools.getTools().contains("Docker"));
        assertTrue(devOpsTools.getTools().contains("Kubernetes"));
    }

    @Test
    public void testContainsTool() {
        devOpsTools.addTool("Jenkins");
        assertTrue(devOpsTools.containsTool("Jenkins"));
        assertFalse(devOpsTools.containsTool("Ansible"));
    }
}
