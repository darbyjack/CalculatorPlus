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
        DecimalFormat df = new DecimalFormat("#.###");

        int a, b, c;

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
                                + signs + ") = " + inputs + String.valueOf(a * b))).send(player);


            } catch (NumberFormatException e) {
                player.sendMessage(color(config.getString("messages.not-valid-number")));
            }
        }
        if (args[0].equalsIgnoreCase("triangle")) {
            if (args.length != 3) {
                return;
            }

            try {
                a = Integer.valueOf(args[1]);
                b = Integer.valueOf(args[2]);

                String answer = df.format((a * b) / 2);

                JSONMessage.create(color(
                        config.getString("messages.area-answer").replace("{shape}",
                                args[0]).replace("{area}", answer)))
                        .tooltip(color2(config.getString("messages.solution") + ChatColor.RESET
                                + "\n" + signs + "(" + inputs + a + signs + " * " + inputs + b
                                + signs + ") / 2 = " + inputs + answer)).send(player);

            } catch (NumberFormatException e) {
                player.sendMessage(color(config.getString("messages.not-valid-number")));
            }
        }

        if (args[0].equalsIgnoreCase("trapezoid")) {
            if (args.length != 4) {
                return;
            }
            try {
                a = Integer.valueOf(args[1]);
                b = Integer.valueOf(args[2]);
                c = Integer.valueOf(args[3]);

                int bases = (a + b);
                int baseHeight = (bases * c);
                int area = (baseHeight / 2);

                JSONMessage.create(color(
                        config.getString("messages.area-answer").replace("{shape}",
                                args[0]).replace("{area}", String.valueOf(area))))
                        .tooltip(color2(config.getString("messages.solution") + ChatColor.RESET
                                + "\n" + signs + "(" + inputs + a + signs + " + " + inputs + b
                                + signs + ") = " + inputs + bases + ChatColor.RESET + "\n" + signs
                                + "(" + inputs + bases + signs + ") * " + inputs + c + signs + " = "
                                + inputs + baseHeight + ChatColor.RESET + "\n" + signs + "("
                                + inputs + baseHeight + signs + ") / 2 = " + inputs + area))
                        .send(player);
            } catch (NumberFormatException e) {
                player.sendMessage(color(config.getString("messages.not-valid-number")));
            }

        }
        if (args[0].equalsIgnoreCase("circle")) {
            if (args.length != 2) {
                return;
            }
            try {

                a = Integer.valueOf(args[1]);

                double answer = (a * a * Math.PI);

                String answerFormat = df.format(answer);

                JSONMessage.create(color(
                        config.getString("messages.area-answer").replace("{shape}",
                                args[0]).replace("{area}", answerFormat))).tooltip(
                        color2(config.getString("messages.solution") + signs + "π(" + inputs + a
                                + signs + ")^2 = " + inputs + answerFormat)).send(player);

            } catch (NumberFormatException e) {
                player.sendMessage(color(config.getString("messages.not-valid-number")));
            }
        }
    }

}
