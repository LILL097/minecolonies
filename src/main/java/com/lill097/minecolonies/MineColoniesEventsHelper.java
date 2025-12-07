package com.lill097.minecolonies;

import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.common.NeoForge;

import java.util.function.Consumer;

// Nome della classe corretto per matchare il nuovo nome del file
public class MineColoniesEventsHelper { 

    // Costruttore vuoto.
    public MineColoniesEventsHelper() { }

    /**
     * Metodo generico: MineColoniesEvents.addListener(MyEventClass, callback)
     */
    public void addListener(Class<?> eventClass, Consumer<Event> consumer) {
        if (!Event.class.isAssignableFrom(eventClass)) {
            throw new IllegalArgumentException("La classe evento deve estendere net.neoforged.bus.api.Event!");
        }
        var bus = NeoForge.EVENT_BUS;
        bus.addListener(EventPriority.NORMAL, false, eventClass, consumer);
    }
    
    // =========================================================================
    // METODO HELPER SPECIFICO PER MINECOLONIES (Aggiunto per snellire lo script)
    // =========================================================================

    /**
     * Metodo specifico per l'evento di MineColonies di costruzione completata.
     * Non richiede al JS di caricare la classe Java dell'evento.
     */
    public void onBuildingConstructionFinished(Consumer<com.minecolonies.api.eventbus.events.colony.buildings.BuildingConstructionModEvent> consumer) {
        
        // Carica la classe evento direttamente qui in Java
        var eventClass = com.minecolonies.api.eventbus.events.colony.buildings.BuildingConstructionModEvent.class;
        
        // Registra un listener che chiama il consumer JS SOLO se la costruzione è FINITA
        NeoForge.EVENT_BUS.addListener(EventPriority.NORMAL, false, eventClass, event -> {
            // Controlla il tipo in Java prima di passare a JS
            if (event.isFinished()) {
                consumer.accept(event);
            }
        });
    }

    // Qui puoi aggiungere altri metodi helper per altri eventi MineColonies...
}