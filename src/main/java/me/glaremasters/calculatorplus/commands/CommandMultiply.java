package me.glaremasters.calculatorplus.commands;

import static me.glaremasters.calculatorplus.util.ColorUtil.color;
import static me.glaremasters.calculatorplus.util.ColorUtil.color2;
import me.glaremasters.calculatorplus.CalculatorPlus;
import me.glaremasters.calculatorplus.commands.base.CommandBase;
import me.rayzr522.jsonmessage.JSONMessage;
import org.bukkit.ChatColor;
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
        String signs = config.getString("colors.signs");
        String inputs = config.getString("colors.inputs");
        try {
            for (int x = 0; x < args.length; x++) {
                number = Double.valueOf(args[x]);
                total *= number;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                sb.append(ChatColor.translateAlternateColorCodes('&',
                        inputs + args[i]))
                        .append(ChatColor.translateAlternateColorCodes('&',
                                " " + signs + "* "));
            }
            sb.setLength(sb.length() - 2);
            JSONMessage.create(color(config.getString("messages.answer-multiply")
                    .replace("{answer}", String.valueOf(total)))).tooltip(
                    color2(config.getString("messages.solution") + sb.toString().trim() + signs + "= "
                            + inputs + total)).send(player);
        } catch (NumberFormatException e) {
            player.sendMessage(color(config.getString("messages.not-valid-number")));
        }
    }

}
