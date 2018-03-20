package me.glaremasters.calculatorplus.commands;

import me.glaremasters.calculatorplus.commands.base.CommandBase;
import org.bukkit.command.CommandSender;

/**
 * Created by GlareMasters on 3/19/2018.
 */
public class CommandHelp extends CommandBase {

    public CommandHelp() {
        super("help", "List all commands", "cp.help", false, null, null, 0, 0);
    }

    public void execute(CommandSender sender, String[] args) {

    }

}
