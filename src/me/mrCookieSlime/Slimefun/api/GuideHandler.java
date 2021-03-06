package me.mrCookieSlime.Slimefun.api;

import java.util.List;

import org.bukkit.entity.Player;

import me.mrCookieSlime.CSCoreLibPlugin.PlayerRunnable;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.Slimefun.SlimefunGuide;

public abstract class GuideHandler {
	
	public abstract void addEntry(List<String> texts, List<String> tooltips);
	public abstract PlayerRunnable getRunnable();
	public abstract int getTier();
	public abstract boolean trackHistory();

	public abstract int next(Player p, int index, ChestMenu menu);

	public PlayerRunnable getRunnable(boolean book) {
		return this.getRunnable();
	}
	
	public void run(Player p, boolean survival, boolean book) {
		this.getRunnable(book).run(p);
		
		if (survival && this.trackHistory()) {
			SlimefunGuide.addToHistory(p, this);
		}
	}

}
