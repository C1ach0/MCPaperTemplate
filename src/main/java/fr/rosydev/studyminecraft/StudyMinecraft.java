package fr.rosydev.studyminecraft;

import fr.rosydev.studyminecraft.commands.TPToCommand;
import fr.rosydev.studyminecraft.commands.TestCommand;
import fr.rosydev.studyminecraft.configurations.CommandHandler;
import fr.rosydev.studyminecraft.configurations.ListenerHandler;
import fr.rosydev.studyminecraft.events.JoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class StudyMinecraft extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Plugin lancer !");
        new CommandHandler(this, "fr.rosydev.studyminecraft.commands");
        new ListenerHandler(this, "fr.rosydev.studyminecraft.events");
    }

    @Override
    public void onDisable() {
        System.out.println("Plugin stop !");
    }
}
