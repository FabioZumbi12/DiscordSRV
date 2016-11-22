package github.scarsz.discordsrv.DiscordSRV.objects;

import github.scarsz.discordsrv.DiscordSRV.util.ResourceUtil;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Made by Scarsz
 *
 * @in /dev/hell
 * @at 11/7/2016
 */
@SuppressWarnings("unused")
public class Config {

    public Config() {
        // load default config values
        ((Map<String, Object>) new Yaml().load(ResourceUtil.getResourceAsString("defaultconfig.yml"))).entrySet().forEach(entry -> {
            defaultConfig.put(entry.getKey(), entry.getValue());
        });
    }

    private Map<String, Object> config = new HashMap<>();
    private Map<String, Object> defaultConfig = new HashMap<>();

    public File configFile = null;

    public void save() {
        if (configFile == null) throw new NullPointerException("Config file is null. Can't save.");

    }

    public void put(String key, Object value) {
        config.put(key, value);
    }

    public boolean getBoolean(String key) {
        return (boolean) config.getOrDefault(key, defaultConfig.get(key));
    }
    public String getString(String key) {
        return (String) config.getOrDefault(key, defaultConfig.get(key));
    }
    public List<String> getStringList(String key) {
        return (List<String>) config.getOrDefault(key, defaultConfig.get(key));
    }

}