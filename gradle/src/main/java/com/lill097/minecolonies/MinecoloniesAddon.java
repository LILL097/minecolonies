package com.lill097.minecolonies;

import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import net.neoforged.fml.common.Mod;

@Mod("kubejs-minecolonies") // ID Mod Corretto
public class MinecoloniesAddon implements KubeJSPlugin {
    
    /**
     * Questo metodo è chiamato da KubeJS quando sta configurando lo scope JavaScript.
     */
    @Override
    public void addBindings(BindingsEvent event) {
        // Espone la classe helper con un nome semplice e pulito per lo script JS
        event.add("MineColoniesEvents", new MineColoniesEventsHelper()); 
    }

    // Aggiungi qui l'implementazione del Mod principale se necessario, es. costruttore.
}