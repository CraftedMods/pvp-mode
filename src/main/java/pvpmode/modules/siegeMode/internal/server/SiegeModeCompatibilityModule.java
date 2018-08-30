package pvpmode.modules.siegeMode.internal.server;

import static pvpmode.modules.siegeMode.api.server.SiegeModeServerConfigurationConstants.*;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import pvpmode.PvPMode;
import pvpmode.api.common.SimpleLogger;
import pvpmode.api.common.compatibility.CompatibilityModule;
import pvpmode.api.server.compatibility.events.*;
import pvpmode.api.server.compatibility.events.PvPListEvent.UnsafeClassification;
import siege.common.siege.SiegeDatabase;

/**
 * The compatibility module for the Siege Mode Mod.
 *
 * @author CraftedMods
 *
 */
public class SiegeModeCompatibilityModule implements CompatibilityModule
{

    private boolean disablePvPLoggingDuringSieges;

    @Override
    public void load (SimpleLogger logger) throws Exception
    {
        MinecraftForge.EVENT_BUS.register (this);

        Configuration configuration = PvPMode.instance.getServerProxy ().getConfiguration ();

        disablePvPLoggingDuringSieges = configuration.getBoolean (
            DISABLE_PVP_LOGGING_DURING_SIEGES_CONFIGURATION_NAME,
            SIEGE_MODE_CONFIGURATION_CATEGORY, true, "If true, PvP events for all players of a siege won't be logged.");

        configuration.addCustomCategoryComment (SIEGE_MODE_CONFIGURATION_CATEGORY,
            "Configuration entries for compatibility with the \"Siege Mode\" Mod");

        PvPMode.instance.getServerProxy ().getOverrideManager ()
            .registerOverrideCondition (new SiegeZoneOverrideCondition ());
    }

    @SubscribeEvent
    public void onPartialInventoryLoss (OnPartialInventoryLossEvent event)
    {
        if (SiegeDatabase.getActiveSiegeForPlayer (event.getPlayer ()) != null)
        {
            event.setCanceled (true);
        }
    }

    @SubscribeEvent
    public void onPvPLog (OnPvPLogEvent event)
    {
        if (disablePvPLoggingDuringSieges && (SiegeDatabase.getActiveSiegeForPlayer (event.getAttacker ()) != null
            || SiegeDatabase.getActiveSiegeForPlayer (event.getVictim ()) != null))
        {
            event.setCanceled (true);
        }
    }

    @SubscribeEvent
    public void onUnsafePriorization (UnsafeClassification event)
    {
        if (SiegeDatabase.getActiveSiegeForPlayer (event.getConsumer ()) != null
            || SiegeDatabase.getActiveSiegeForPlayer (event.getProvider ()) != null)
        {
            event.setCanceled (true);
        }
    }

}
