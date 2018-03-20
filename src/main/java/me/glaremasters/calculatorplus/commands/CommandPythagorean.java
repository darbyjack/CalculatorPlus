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
        super("pythagorean", "Pythagorean theorem", "cp.pythagorean", false, null, null, 2, 2);
    }

    public void execute(Player player, String[] args) {
        int a, b;
        double answer;
        FileConfiguration config = CalculatorPlus.getI().getConfig();
        try {
            a = Integer.valueOf(args[0]);
            b = Integer.valueOf(args[1]);

            answer = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
            player.sendMessage(color(config.getString("messages.answer-pythagorean").replace("{answer}", String.valueOf(answer))));


        } catch (NumberFormatException e) {
            player.sendMessage(color(config.getString("messages.not-valid-number")));
        }
    }

}
