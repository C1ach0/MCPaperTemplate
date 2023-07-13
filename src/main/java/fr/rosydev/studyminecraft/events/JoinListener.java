package fr.rosydev.studyminecraft.events;

import fr.rosydev.studyminecraft.annotations._Listener;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@_Listener(name = "Join")
public class JoinListener  implements Listener {
    @EventHandler
    public void joinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        //World world = Bukkit.getWorld("lobby");
        //if(world == null) return;
        //Location loc = world.getSpawnLocation();

        event.joinMessage(Component.text(player.getName() + " viens de rejoindre le serveur !"));

        //player.teleport(loc);
        player.playSound(player, Sound.ENTITY_ENDER_DRAGON_DEATH, 100, 1);

        player.sendMessage(Component.text("Salut bg !"));
    }
}
