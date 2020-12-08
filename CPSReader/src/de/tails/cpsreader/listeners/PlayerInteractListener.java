package de.tails.cpsreader.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import de.tails.cpsreader.main.CPSReader;
import de.tails.cpsreader.utils.CPSComputer;

public class PlayerInteractListener implements Listener {

	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if(!(CPSComputer.cps.containsKey(player))) {
			CPSComputer.cps.put(player, 0);
		}
		CPSComputer cpscomputer = new CPSComputer(player);
		cpscomputer.setCPS(cpscomputer.getCPS() + 1); // Die CPS wird um 1 addiert
		if(!(CPSComputer.readcps.contains(player))) { // Die Abfrage dient dazu, das der Schduler nur
														// einmal pro Sekunde ausgeführt wird
			CPSComputer.readcps.add(player);
			Bukkit.getScheduler().scheduleSyncDelayedTask(CPSReader.getPlugin(), new Runnable() {

				@Override
				public void run() {
					player.sendMessage(cpscomputer.getCPS() + ""); // Die CPS wird ausgegeben
					cpscomputer.setCPS(0); // Die CPS wird nach der Ausgabe/Nach Ablauf der Sekunde auf
											// 0 gesetzt
					CPSComputer.readcps.remove(player); // Nun kann der Scheduler wieder ausgeführt
														// werden.
				}
			}, 20);

		}
	}
}