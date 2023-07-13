package fr.rosydev.studyminecraft.configurations;

import fr.rosydev.studyminecraft.annotations._Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.util.*;

public class CommandHandler {
    private Map<String, CommandExecutor> commandMap = new HashMap<>();
    private ArrayList<String> commandList = new ArrayList<>();
    private JavaPlugin javaPlugin;
    private String folderPath;
    public CommandHandler(JavaPlugin javaPlugin, String folderPath) {
        this.javaPlugin = javaPlugin;
        this.folderPath = folderPath;
        this.registerCommands();
        new TableConsole("Commands", commandList);
    }

    private void registerCommands() {
        Reflections reflections = new Reflections(this.folderPath, new TypeAnnotationsScanner(), new SubTypesScanner());
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(_Command.class);
        for (Class<?> commandClass : classes) {
            if(CommandExecutor.class.isAssignableFrom(commandClass)) {
                CommandExecutor commandExecutor;
                try {
                    commandExecutor = (CommandExecutor) commandClass.getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
                _Command annotation = commandClass.getAnnotation(_Command.class);
                if(annotation != null) {
                    javaPlugin.getServer().getPluginCommand(annotation.name()).setExecutor(commandExecutor);
                    commandMap.put(annotation.name(), commandExecutor);
                    commandList.add(annotation.name());
                }
            }
        }
    }
}
