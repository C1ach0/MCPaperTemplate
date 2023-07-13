package fr.rosydev.studyminecraft.commands;

import fr.rosydev.studyminecraft.annotations._Command;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@_Command(name = "test")
public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player) {
            commandSender.sendMessage(Component.text("UwU !!"));
        } else {
            commandSender.sendMessage(Component.text("Vous n'êtes pas un joueur !"));
        }

        return false;
    }
}
