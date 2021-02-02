package de.Panischer;
import org.bukkit.inventory.ItemStack;
public class BonusManager
{
	public static double getDamageBonus(ItemStack is)
	{
			double bonus = LevelManager.getLevels(is) / 10;
			return bonus;
	}
	public static int getHasteBonus(ItemStack is)
	{
		if(LevelManager.getLevels(is) < 255)
		{
			int bonus = (int) LevelManager.getLevels(is);
			return bonus;
		}else
		{
			return 255;
		}
	}
	public static double getResistanceBonus(ItemStack is)
	{
		double bonus = LevelManager.getLevels(is) / 100;
		return bonus;
	}
}
