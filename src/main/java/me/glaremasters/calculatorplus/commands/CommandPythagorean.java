package me.glaremasters.calculatorplus.commands;

import static me.glaremasters.calculatorplus.util.ColorUtil.color;
import static me.glaremasters.calculatorplus.util.ColorUtil.color2;
import java.text.DecimalFormat;
import me.glaremasters.calculatorplus.CalculatorPlus;
import me.glaremasters.calculatorplus.commands.base.CommandBase;
import me.rayzr522.jsonmessage.JSONMessage;
import org.bukkit.ChatColor;
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
        double answer, fa;
        FileConfiguration config = CalculatorPlus.getI().getConfig();
        try {
            a = Integer.valueOf(args[0]);
            b = Integer.valueOf(args[1]);
            String signs = config.getString("colors.signs");
            String inputs = config.getString("colors.inputs");

            DecimalFormat df = new DecimalFormat("#.###");

            fa = Math.pow(a, 2) + Math.pow(b, 2);
            answer = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

            String answerFixed = df.format(answer);
            JSONMessage.create(color(config.getString("messages.answer-pythagorean")
                    .replace("{answer}", String.valueOf(answer))))
                    .tooltip(color2(config.getString("messages.solution") + ChatColor.RESET + "\n"
                            + signs + "("
                            + inputs + a + signs + "^2 + " + inputs + b + signs + "^2) = "
                            + inputs + fa + "\n" + signs + "√(" + inputs + fa + signs + ") = "
                            + inputs + answerFixed))
                    .send(player);


        } catch (NumberFormatException e) {
            player.sendMessage(color(config.getString("messages.not-valid-number")));
        }
    }

}
