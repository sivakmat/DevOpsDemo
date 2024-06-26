package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.List;

public class DevOpsTools {

    private List<String> tools;

    public DevOpsTools() {
        tools = new ArrayList<>();
    }

    public void addTool(String tool) {
        tools.add(tool);
    }

    public List<String> getTools() {
        return tools;
    }

    public boolean containsTool(String tool) {
        return tools.contains(tool);
    }

    public void removeTool(String tool) {
        tools.remove(tool);
    }

    public int getToolCount() {
        return tools.size();
    }
}
