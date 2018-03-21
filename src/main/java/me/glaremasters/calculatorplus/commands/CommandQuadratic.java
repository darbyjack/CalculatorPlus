package me.glaremasters.calculatorplus.commands;

import static me.glaremasters.calculatorplus.util.ColorUtil.color;
import java.text.DecimalFormat;
import me.glaremasters.calculatorplus.CalculatorPlus;
import me.glaremasters.calculatorplus.commands.base.CommandBase;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * Created by GlareMasters on 3/20/2018.
 */
public class CommandQuadratic extends CommandBase {

    public CommandQuadratic() {
        super("quadratic", "Quadratic formula", "cp.quadratic", false, null, null, 3, 3);
    }

    public void execute(Player player, String[] args) {
        int a, b, c;
        double r1, r2, d;
        FileConfiguration config = CalculatorPlus.getI().getConfig();
        try {
            a = Integer.valueOf(args[0]);
            b = Integer.valueOf(args[1]);
            c = Integer.valueOf(args[2]);

            d = b * b - 4 * a * c;
            DecimalFormat df = new DecimalFormat("#.###");

            if (d > 0) {
                player.sendMessage(color(config.getString("messages.real-unequal")));
                r1 = (-b + Math.sqrt(d)) / (2 * a);
                r2 = (-b - Math.sqrt(d)) / (2 * a);

                String r1Format = df.format(r1);
                String r2Format = df.format(r2);
                player.sendMessage(color(config.getString("messages.roots")
                        .replace("{root1}", r1Format)
                        .replace("{root2}", r2Format)));
            } else if (d == 0) {
                player.sendMessage(color(config.getString("messages.real-equal")));
                r1 = (-b + Math.sqrt(d)) / (2 * a);

                String r1Format = df.format(r1);
                player.sendMessage(color(config.getString("messages.roots")
                        .replace("{root1}", r1Format).replace("{root2}", "")));
            } else {
                player.sendMessage(color(config.getString("messages.imaginary")));
            }

        } catch (NumberFormatException e) {
            player.sendMessage(color(config.getString("messages.not-valid-number")));
        }
    }

}
