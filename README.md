# StudyMinecraft
> Command et Listener handler - Paper plugin 1.19.4

> Version : `0.0.1`

> Repo : https://github.com/C1ach0/studyminecraft
***

## Installation : 
> How to install the command handler in your project?
- Main.java
```java
@Override
public void onEnable() {
    System.out.println("Plugin lancer !");
    new CommandHandler(this, "fr.rosydev.studyminecraft.commands");
    new ListenerHandler(this, "fr.rosydev.studyminecraft.events");
}
```


## Command :
> A minecraft command handler that works with annotation : @_Command(name = "commandName")

[CommandHanler.java](https://github.com/C1ach0/StudyMinecraft/blob/master/src/main/java/fr/rosydev/studyminecraft/configurations/CommandHandler.java)

- Commands:
```java
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
```

## Listener :
> A minecraft listener handler that works with the annotation : @_Listener(name = "eventName")

[ListenerHandler.java](https://github.com/C1ach0/StudyMinecraft/blob/master/src/main/java/fr/rosydev/studyminecraft/configurations/ListenerHandler.java)

- Listener:
```java
@_Listener(name = "Join")
public class JoinListener  implements Listener {
    @EventHandler
    public void joinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.joinMessage(Component.text(player.getName() + " viens de rejoindre le serveur !"));

        player.playSound(player, Sound.ENTITY_ENDER_DRAGON_DEATH, 100, 1);

        player.sendMessage(Component.text("Salut bg !"));
    }
}
```

***
> Author : [Me](https://github.com/C1ach0)

