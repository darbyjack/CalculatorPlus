package me.glaremasters.calculatorplus;

import java.util.stream.Stream;
import me.glaremasters.calculatorplus.commands.CommandHelp;
import me.glaremasters.calculatorplus.commands.base.CommandHandler;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class CalculatorPlus extends JavaPlugin {

    private CommandHandler commandHandler;
    private static String prefix;
    private static CalculatorPlus i;

    public static CalculatorPlus getI() {
        return i;
    }

    @Override
    public void onEnable() {

        i = this;

        prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("plugin-prefix"))
                + ChatColor.RESET + " ";

        commandHandler = new CommandHandler();
        commandHandler.enable();

        getCommand("cp").setExecutor(commandHandler);

        Stream.of(new CommandHelp()).forEach(commandHandler::register);

    }

    @Override
    public void onDisable() {

        commandHandler.disable();

    }

    public static String getPrefix() {
        return prefix;
    }
}
