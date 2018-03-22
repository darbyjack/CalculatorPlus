package me.glaremasters.calculatorplus.commands;

import static me.glaremasters.calculatorplus.util.ColorUtil.color;
import static me.glaremasters.calculatorplus.util.ColorUtil.color2;
import me.glaremasters.calculatorplus.CalculatorPlus;
import me.glaremasters.calculatorplus.commands.base.CommandBase;
import me.rayzr522.jsonmessage.JSONMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

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
        JSONMessage.create(color(config.getString("messages.quadratic")))
                .tooltip(color2(config.getString("messages.formula") + "(ax^2 + bx + c)"))
                .send((Player) sender);
        JSONMessage.create(color(config.getString("messages.pythagorean")))
                .tooltip(color2(config.getString("messages.formula") + "(a^2 + b^2 = c^2)"))
                .send((Player) sender);
        sender.sendMessage(color(config.getString("messages.area")));

    }

}
