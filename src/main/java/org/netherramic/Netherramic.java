/*
 * Copyright (c) 2012 Sean Porter <glitchkey@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.netherramic;

//* IMPORTS: JDK/JRE
	//* NOT NEEDED
//* IMPORTS: BUKKIT
	import org.bukkit.Bukkit;
	import org.bukkit.entity.Player;
	import org.bukkit.event.inventory.CraftItemEvent;
	import org.bukkit.event.EventHandler;
	import org.bukkit.event.EventPriority;
	import org.bukkit.event.Listener;
	import org.bukkit.inventory.ItemStack;
	import org.bukkit.inventory.ShapedRecipe;
	import org.bukkit.Material;
	import org.bukkit.plugin.java.JavaPlugin;
//* IMPORTS: SPOUT
	//* NOT NEEDED
//* IMPORTS: OTHER
	//* NOT NEEDED

public class Netherramic extends JavaPlugin implements Listener
{
	public	boolean recipeAdded = false;
	
	public void onLoad() {}
	
	public void onEnable()
	{
		ItemStack	netherBrickItem		= new ItemStack(Material.NETHER_BRICK, 1);
		ShapedRecipe 	netherBrickRecipe	= new ShapedRecipe(netherBrickItem);
		
		netherBrickRecipe = netherBrickRecipe.shape(new String[] { "nnn", "nnn", "nnn" });
		netherBrickRecipe = netherBrickRecipe.setIngredient('n', Material.NETHERRACK);
		
		getServer().addRecipe(netherBrickRecipe);
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	public void onDisable() {}
	
	public void reload() {}

	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void craftNetherBrick(CraftItemEvent event)
	{
		if(event == null)
			return;
		else if(event.getRecipe() == null)
			return;
		else if(event.getRecipe().getResult() == null)
			return;
		else if(event.getRecipe().getResult().getType() == null)
			return;
		else if(event.getRecipe().getResult().getType() != Material.NETHER_BRICK)
			return;
		else if(event.getWhoClicked() == null)
			return;
		else if(!(event.getWhoClicked() instanceof Player))
			return;

		final Player player = (Player) event.getWhoClicked();

		Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable()
		{
			@Override
			public void run()
			{
				player.updateInventory();
			}
		});
	}
}
