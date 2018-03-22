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
 * Created by GlareMasters on 3/21/2018.
 */
public class CommandArea extends CommandBase {

    public CommandArea() {
        super("area", "Area of shape", "cp.area", false, null, null, 2, -1);
    }

    public void execute(Player player, String[] args) {
        FileConfiguration config = CalculatorPlus.getI().getConfig();

        String signs = config.getString("colors.signs");
        String inputs = config.getString("colors.inputs");

        int a, b;

        if (args[0].equalsIgnoreCase("rectangle") || args[0].equalsIgnoreCase("square") || args[0]
                .equalsIgnoreCase("parallelogram")) {
            if (args.length != 3) {
                return;
            }
            try {
                a = Integer.valueOf(args[1]);
                b = Integer.valueOf(args[2]);

                JSONMessage.create(color(
                        config.getString("messages.area-answer").replace("{shape}",
                                args[0]).replace("{area}", String.valueOf(a * b))))
                        .tooltip(color2(config.getString("messages.solution") + ChatColor.RESET
                                + "\n" + signs + "(" + inputs + a + signs + " * " + inputs + b
                                + signs + ") = " + String.valueOf(a * b))).send(player);


            } catch (NumberFormatException e) {
                player.sendMessage(color(config.getString("messages.not-valid-number")));
            }
        }
    }

}
