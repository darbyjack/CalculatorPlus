package me.glaremasters.calculatorplus.util;

import me.glaremasters.calculatorplus.CalculatorPlus;
import org.bukkit.ChatColor;

/**
 * Created by GlareMasters on 3/19/2018.
 */
public class ColorUtil {

    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', CalculatorPlus.getPrefix() + string);
    }

    public static String color2(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

}