package de.tails.cpsreader.utils;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;

public class CPSComputer {

	public static HashMap<Player, Integer> cps = new HashMap<Player, Integer>();
	public static ArrayList<Player> readcps = new ArrayList<Player>();

	Player player;

	public CPSComputer(Player player) {
		this.player = player;
	}

	public int getCPS() {
		return cps.get(player);
	}

	public void setCPS(int cps) {
		CPSComputer.cps.put(player, cps);
	}
}