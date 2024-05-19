package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class DevOpsController {

    private Map<Integer, DevOps> devopss = new HashMap<>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        this.devopss.put(1,new DevOps(1, "Jenkins", "Eine Open-Source-Automatisierungstools mit einer grossen Plugin-Bibliothek, das für das Management von CI/CD-Prozessen verwendet wird."));
        this.devopss.put(2,new DevOps(2, "Docker", "Ein Standard-Tool zur Containerisierung, das es ermöglicht, Anwendungen in Containern zu verpacken."));
        this.devopss.put(3,new DevOps(3, "SonarQube", "Bietet kontinuierliche Inspektion des Codequalität und kann in CI-Pipelines integriert werden."));
        System.out.println("Init Data");
    }

    @GetMapping("/testdevops")
    public String test() {
        return "DevOps app is up and running!";
    }

    @GetMapping("/services/devops/ping")
    public String ping() {
        String languageCode = "de";
        return "{ \"status\": \"ok\", \"userId\": \"admin"+ "\", \"languageCode\": \"" + languageCode + "\",\"version\": \"0.0.1" + "\"}";
    }

    @GetMapping("/countdevops")
    public int count() {
        return this.devopss.size();
    }

    @GetMapping("/services/devops")
    public List<PathListEntry<Integer>> devops() {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var devops : this.devopss.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(devops.getId(), "devopsKey");
            entry.setName(devops.getTitle());
            entry.getDetails().add(devops.getDescription());
            entry.setTooltip(devops.getDescription());
            result.add(entry);
        }
        return result;
    }

    @GetMapping("/services/devops/{key}")
    public DevOps getDevops(@PathVariable Integer key) {
        return this.devopss.get(key);
    }

    @PostMapping("/services/devops")
    public void createDevops(@RequestBody DevOps devops) {
        var newId = this.devopss.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        devops.setId(newId);
        this.devopss.put(newId, devops);
    }

    @PutMapping("/services/devops/{id}")
    public void updateDevops(@PathVariable Integer id, @RequestBody DevOps devops) {
        devops.setId(id);
        this.devopss.put(id, devops);
    }

    @DeleteMapping("/services/devops/{key}")
    public DevOps deleteDevops(@PathVariable Integer key) {
        return this.devopss.remove(key);
    }


}
