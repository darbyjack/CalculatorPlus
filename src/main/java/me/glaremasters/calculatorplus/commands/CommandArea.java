package me.glaremasters.calculatorplus.commands;

import static me.glaremasters.calculatorplus.util.ColorUtil.color;
import me.glaremasters.calculatorplus.CalculatorPlus;
import me.glaremasters.calculatorplus.commands.base.CommandBase;
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
                a = Integer.valueOf(args[0]);
                b = Integer.valueOf(args[1]);




            } catch (NumberFormatException e) {
                player.sendMessage(color(config.getString("messages.not-valid-number")));
            }
        }


    }

}
