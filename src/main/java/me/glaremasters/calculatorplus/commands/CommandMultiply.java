package me.glaremasters.calculatorplus.commands;

import static me.glaremasters.calculatorplus.util.ColorUtil.color;
import me.glaremasters.calculatorplus.CalculatorPlus;
import me.glaremasters.calculatorplus.commands.base.CommandBase;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * Created by GlareMasters on 3/19/2018.
 */
public class CommandMultiply extends CommandBase {

    public CommandMultiply() {
        super("multiply", "Multiply two numbers", "cp.multiply", false, null, null, 2, -1);
    }

    public void execute(Player player, String[] args) {
        FileConfiguration config = CalculatorPlus.getI().getConfig();
        if (args.length < 2) {
            return;
        }
        double number = 0;
        double total = 1;
        try {
            for (int x = 0; x < args.length; x++) {
                number = Double.valueOf(args[x]);
                total *= number;
            }
            player.sendMessage(color(config.getString("messages.answer-multiply").replace("{answer}", String.valueOf(total))));
        } catch (NumberFormatException e) {
            player.sendMessage(color(config.getString("messages.not-valid-number")));
        }
    }

}
