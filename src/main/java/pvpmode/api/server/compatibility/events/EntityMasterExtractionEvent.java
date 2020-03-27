package pvpmode.api.server.compatibility.events;

import java.util.UUID;

import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.Entity;

/**
 * This event will be fired if PvPMode has to determine the master of an
 * attacking entity - the master as to be a player.
 *
 * @author CraftedMods
 *
 */
public class EntityMasterExtractionEvent extends Event
{

    private final Entity entity;
    private UUID masterUUID;

    public EntityMasterExtractionEvent (Entity entity)
    {
        this.entity = entity;
    }

    /**
     * Returns the entity which master should be determined
     */
    public Entity getEntity ()
    {
        return entity;
    }

    /**
     * Returns the currently determined master player UUID
     */
    public UUID getMasterUUID ()
    {
        return masterUUID;
    }

    /**
     * Sets the determined master UUID. This will replace the current value.
     */
    public void setMasterUUID (UUID masterUUID)
    {
        this.masterUUID = masterUUID;
    }

}
