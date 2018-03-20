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
public class CommandSubtract extends CommandBase {

    public CommandSubtract() {
        super("subtract", "Subtract two numbers", "cp.subtract", false, null, null, 2, -1);
    }

    public void execute(Player player, String[] args) {
        FileConfiguration config = CalculatorPlus.getI().getConfig();
        if (args.length < 2) {
            return;
        }
        double number = 0;
        double total = 0;
        try {
            for (int x = 0; x < args.length; x++) {
                number = Double.valueOf(args[x]);
                total -= number;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                sb.append(ChatColor.translateAlternateColorCodes('&', "&a" + args[i]))
                        .append(ChatColor.translateAlternateColorCodes('&', " &7- "));
            }
            sb.setLength(sb.length() - 2);
            JSONMessage.create(color(config.getString("messages.answer-subtract")
                    .replace("{answer}", String.valueOf(total)))).tooltip(
                    color2(config.getString("messages.solution") + sb.toString().trim() + "= "
                            + "&a" + total)).send(player);
        } catch (NumberFormatException e) {
            player.sendMessage(color(config.getString("messages.not-valid-number")));
        }
    }

}
