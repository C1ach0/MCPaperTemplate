package fr.rosydev.studyminecraft.configurations;

import fr.rosydev.studyminecraft.annotations._Listener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.util.ArrayList;
import java.util.Set;

public class ListenerHandler {
    private ArrayList<String> listenerList = new ArrayList<>();
    private JavaPlugin javaPlugin;
    private String folderPath;
    public ListenerHandler(JavaPlugin javaPlugin, String folderPath) {
        this.javaPlugin = javaPlugin;
        this.folderPath = folderPath;
        this.registerListener();
        new TableConsole("Listener", listenerList);
    }

    private void registerListener() {
        Reflections reflections = new Reflections(this.folderPath, new TypeAnnotationsScanner(), new SubTypesScanner());
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(_Listener.class);
        for (Class<?> listenerClass : classes) {
            if(Listener.class.isAssignableFrom(listenerClass)) {
                Listener listener;
                try {
                    listener = (Listener)  listenerClass.getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
                _Listener annotation = listenerClass.getAnnotation(_Listener.class);
                javaPlugin.getServer().getPluginManager().registerEvents(listener, this.javaPlugin);
                listenerList.add(annotation.name());
            }
        }
    }
}
