package github.com.sweetenpotato.simpleeconomy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

public class CommandManager implements CommandExecutor {
    private static final Logger logger = Logger.getLogger("Minecraft");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            logger.info(String.format("[%s] Only players are supported for this plugin, but you should not do this."));
        }

        Player player = (Player) sender;

        if (command.getLabel().equals("economy")) {
            sender.sendMessage(String.format("[%s] You have %s"));
        }
        return false;
    }
}
