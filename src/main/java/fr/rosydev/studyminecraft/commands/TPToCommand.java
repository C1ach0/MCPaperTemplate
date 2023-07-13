package fr.rosydev.studyminecraft.commands;

import fr.rosydev.studyminecraft.annotations._Command;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

@_Command(name = "tpto")
public class TPToCommand  implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (strings.length == 0) {
                player.sendMessage(Component.text("§cVous devez mentionner un joueur !"));
                return true;
            }
            if(strings.length == 1) {
                Player target = Bukkit.getPlayer(strings[0]);
                if(target == null) {
                    player.sendMessage(Component.text("§bCe joueur n'est pas connecté !"));
                }
                assert target != null;
                Location loc = target.getLocation();
                player.teleport(loc);
                player.sendMessage(Component.text("§aEffectué !"));
            }
            return strings.length >= 2;

        } else {
            commandSender.sendMessage(Component.text("Vous n'êtes pas un joueur !"));
        }

        return false;
    }
}
