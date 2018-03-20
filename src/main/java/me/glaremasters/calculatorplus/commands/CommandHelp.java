package me.glaremasters.calculatorplus.commands;

import static me.glaremasters.calculatorplus.util.ColorUtil.color;
import me.glaremasters.calculatorplus.CalculatorPlus;
import me.glaremasters.calculatorplus.commands.base.CommandBase;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Created by GlareMasters on 3/19/2018.
 */
public class CommandHelp extends CommandBase {

    public CommandHelp() {
        super("help", "List all commands", "cp.help", false, null, null, 0, 0);
    }

    public void execute(CommandSender sender, String[] args) {
        FileConfiguration config = CalculatorPlus.getI().getConfig();

        sender.sendMessage(color(config.getString("messages.add")));
        sender.sendMessage(color(config.getString("messages.subtract")));
        sender.sendMessage(color(config.getString("messages.multiply")));
        sender.sendMessage(color(config.getString("messages.divide")));
        sender.sendMessage(color(config.getString("messages.quadratic")));
        sender.sendMessage(color(config.getString("messages.pythagorean")));

    }

}
