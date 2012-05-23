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
	import org.bukkit.inventory.ItemStack;
	import org.bukkit.inventory.ShapedRecipe;
	import org.bukkit.Material;
	import org.bukkit.plugin.java.JavaPlugin;
//* IMPORTS: SPOUT
	//* NOT NEEDED
//* IMPORTS: OTHER
	//* NOT NEEDED

public class Netherramic extends JavaPlugin
{
	public static String pluginName = "Netherramic";
	public	boolean recipeAdded = false;
	
	public void onLoad() {}
	
	public void onEnable()
	{
		ItemStack	netherBrickItem		= new ItemStack(Material.NETHER_BRICK, 1);
		ShapedRecipe 	netherBrickRecipe	= new ShapedRecipe(netherBrickItem);
		
		netherBrickRecipe = netherBrickRecipe.shape(new String[] { "nnn", "nnn", "nnn" });
		netherBrickRecipe = netherBrickRecipe.setIngredient('n', Material.NETHERRACK);
		
		getServer().addRecipe(netherBrickRecipe);
		
		Log.info("%s enabled.", getDescription().getVersion());
	}
	
	public void onDisable()
	{
		Log.info("%s disabled.", getDescription().getVersion());
	}
	
	public void reload()
	{
		Log.info("%s reloaded.", getDescription().getVersion());
	}
}
