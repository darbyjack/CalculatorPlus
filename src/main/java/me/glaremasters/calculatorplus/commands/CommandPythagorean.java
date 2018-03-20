package me.glaremasters.calculatorplus.commands;

import static me.glaremasters.calculatorplus.util.ColorUtil.color;
import me.glaremasters.calculatorplus.CalculatorPlus;
import me.glaremasters.calculatorplus.commands.base.CommandBase;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * Created by GlareMasters on 3/20/2018.
 */
public class CommandPythagorean extends CommandBase {

    public CommandPythagorean() {
        super("quadratic", "Pythangorean theorem", "cp.pythagorean", false, null, null, 3, 3);
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

            if (d > 0) {
                player.sendMessage(color(config.getString("messages.real-unequal")));
                r1 = ( - b + Math.sqrt(d))/(2*a);
                r2 = ( - b - Math.sqrt(d))/(2*a);
                player.sendMessage(color(config.getString("messages.root-one").replace("{root}", String.valueOf(r1))));
                player.sendMessage(color(config.getString("messages.root-two").replace("{root}", String.valueOf(r2))));
            }
            else if (d == 0) {
                player.sendMessage(color(config.getString("messages.real-equal")));
                r1 = ( - b + Math.sqrt(d))/(2*a);
                player.sendMessage(color(config.getString("messages.root-one").replace("{root}", String.valueOf(r1))));
            }
            else {
                player.sendMessage(color(config.getString("messages.imaginary")));
            }

        } catch (NumberFormatException e) {
            player.sendMessage(color(config.getString("messages.not-valid-number")));
        }
    }

}
