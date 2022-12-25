package github.com.sweetenpotato.simpleeconomy;

import jdk.vm.ci.code.Register;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class SimpleEconomy extends JavaPlugin {

    private static final Logger logger = Logger.getLogger("Minecraft");
    private static Economy economy = null;
    private static Permission permission = null;
    private static Chat chat = null;

    @Override
    public void onDisable() {
        logger.info(String.format("[%s] Disabled Version %s", getDescription().getName(), getDescription().getVersion()));
    }

    @Override
    public void onEnable() {
        if (!initEconomy()) {
            logger.severe(String.format("[%s] Disabled due to no Vault dependency found!", getDescription().getName()));
        }
        initPermission();
        initChat();
    }

    private boolean initEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> registeredServiceProvider = getServer().getServicesManager().getRegistration(Economy.class);
        if (registeredServiceProvider == null) {
            return false;
        }
        economy = registeredServiceProvider.getProvider();
        return (economy != null);
    }

    private boolean initPermission() {
        RegisteredServiceProvider<Permission> registeredServiceProvider = getServer().getServicesManager().getRegistration(Permission.class);
        permission = registeredServiceProvider.getProvider();
        return (permission != null);
    }

    private boolean initChat() {
        RegisteredServiceProvider<Chat> registeredServiceProvider = getServer().getServicesManager().getRegistration(Chat.class);
        chat = registeredServiceProvider.getProvider();
        return (chat != null);
    }

    public static Economy getEconomy() {
        return economy;
    }

    public static Permission getPermission() {
        return permission;
    }

    public static  Chat getChat() {
        return chat;
    }

}
