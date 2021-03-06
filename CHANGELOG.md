# Changelog of PvPMode for Minecraft 1.7.10:

## 1.5.0-BETA
### General changes:
* Added a `soulbound` command which marks items as soulbound, preventing them from being dropped on death

### Deathcraft compatibility:
* Fixed a crash occurring when a player dies with empty inventory

## 1.4.1-BETA
### LOTR compatibility:
* Fixed a crash with v34.3 when a player dies

## 1.4.0-BETA
### General changes:
* Determining the owner of an entity now recursively checks for it

### Ender IO compatibility:
* Added a configuration option to prevent soulbound items from being dropped

### Deathcraft compatibility:
* Deathcraft now works with the partial inventory loss

### Lootable Bodies compatibility:
* Lootable Bodies now works with the partial inventory loss

## 1.3.1-BETA
### General changes:

#### Bug fixes:
* Fixed a crash with some ownable entities
* Fixed that players with PvP disabled couldn't attack themselves or their owned entities

### LOTR compatibility:
* Updated to Beta 34.1 of the LOTR Mod

## 1.3.0-BETA
### General changes:
* PvP toggling for players is now disableable

#### Default PvP mode:
* The default PvP mode of a player is now configurable
* Added a configuration option to force the default PvP mode for every player if PvP toggling is disabled
* Added `pvpadmin <player> default` which sets the PvP mode of a player to the default one

#### Chat messages:
* It's now configurable whether chat messages announcing PvP mode changes are displayed globally or locally

#### Bug fixes:
* Fixed an exception occurring with `pvpadmin info <player>` when no player was specified
* Fixed that the warmup timer ran out up to one second later than specified under some circumstances

### LOTR compatibility:
* Added an optional  "safe biome" override condition which forces PvP to OFF

## 1.2.0-BETA
### General changes:

#### Partial inventory loss:
* Added a configurable "main inventory loss" to the partial inventory loss
* Transferring items via shift-clicking in the player's inventory during PvP is now disableable
* If an inventory contains less stacks than have to be dropped, the game can optionally scan other inventories
* Added PvE (Player versus Environment) support for the partial inventory loss

#### `pvplist` command:
* Players can now optionally decide with `pvp spy [on|off]` whether they want to provide/receive proximity informations
* The displayed proximity informations in `pvplist` now can contain the actual direction of the player
* Changed `pvplist` to show only players with PvP enabled by default
* Added `pvplist all` which shows the whole list
* Added `pvplist <maxEntryCount>` which shows the specified number of entries
* The displayed player list in `pvplist` now shows the count of displayed entries
* The players displayed in `pvplist` with a running warmup timer and PvP off are now sorted by the timer

#### `pvphelp` command:
* Added `pvphelp <commandName>` to retrieve detailed information about the specified command
* Restructured the whole `pvphelp` overview menu

#### Warmup timer:
* Added an on-off warmup timer which specifies the toggle time from PvP ON to PvP OFF
* The default value of the off-on warmup timer is now 30 seconds
* A message will now inform the player if the warmup timer was canceled because of PvP

#### PvP timer:
* Increased the default PvP timer value to 45 seconds
* Increased the maximum possible value of the PvP timer to 300 seconds
* The PvP timer is now reset when a player dies
* A player whose PvP timer was started now'll be notified about that

#### Chat messages:
* The chat messages are now gender neutral
* Unified the style and content of the chat messages
* Made some chat messages more clear
* Global chat messages are now prefixed with a configurable prefix

#### Misc:
* Admins can now specify with `pvpadmin <player> [on|off]` the new PvP mode of a player
* Added `pvp info` and `pvpadmin info <player>` to retrieve the PvP stats of a player
* Added full tab-completion support for all commands

#### Bug fixes:
* Fixed that players drop too less items with partial inventory loss under rare circumstances
* Fixed a memory leak with the PvP override manager

### LOTR compatibility:
* Players now optionally drop their skulls when killed with a weapon with "headhunter" even if keepInventory is on
* Changed the default enemy biome configuration
* Added an extended enemy biome configuration file template generated on startup and stored in the main MC directory
* Added a map displaying the default enemy biomes generated on startup and stored in the main MC directory

### SuffixForge compatibility:
* Added a configuration option to prevent soulbound items to be dropped with the partial inventory loss

### Siege Mode compatibility
* The PvP mode is forced to on upon entering sieges
* The partial inventory loss doesn't apply for players in sieges
* PvP logging can be disabled for players in a siege
* Players in a siege don't send or receive proximity informations
* Players in a siege are displayed further down on the PvP list

## 1.1.4-BETA
### General changes:
#### Bug fixes:
* Fixed that players switching from PvP on to off couldn't do PvP during the warmup phase
* Fixed that the warmup timer was displayed in an incorrect way sometimes in `pvplist`

## 1.1.3-BETA
### General changes:

#### Bug fixes:
* Fixed that the PvP timer wasn't resetted for creative/flying players
* Fixed that a chat message wasn't displayed correctly with small chat widths

## 1.1.2-BETA
### General changes:

#### Bug fixes:
* Fixed that the entries in `pvplist` with PvP on were sorted by descending proximity

## 1.1.1-BETA
### General changes:

#### Bug fixes:
* Fixed that the conditional overrides were applied delayed to some players
* Fixed that using `pvp` while the warmup timer is running restarts it
* Fixed that creative/flying players could use `pvp` (and `pvpadmin` could used on them)
* Fixed that the warmup timer of creative/flying players wasn't canceled

## 1.1.0-BETA
### General changes:

#### `pvplist` command:
* The calling player of `pvplist` now will always be displayed on the top of the list
* Added a header and a footer to the `pvplist` player list
* Players in the `pvplist` list with PvP enabled are now sorted by their proximity (if radar is enabled)

#### `pvphelp` command:
* Clicking on `pvpadmin` in `pvphelp` now appends a space to the suggested chat input
* Added a footer to the `pvphelp` command list

#### Misc:
* The changelog will now be integrated into the JAR of PvPMode
* Restructured the internal handling of compatibility-related code (added compatibility modules)
* Added a warning if the attacking player has PvP disabled
* The commands added by PvP mode now behave uniformly regarding invalid usage
* Added a configurable partial armour and hotbar inventory loss (applies only when keepInventory is true)
* Added general support for conditional PvP mode overrides (forcing PvP mode to OFF or ON)
* Added missing comments to some configuration properties
* The PvP mode of players involved in a PvP event cannot be changed anymore
* Added a command blacklist for players which are in PvP: While in PvP, they cannot use the blacklisted commands

#### Bug fixes:
* Fixed that the chat text formattings were screwed up with small chat widths
* Fixed that players which aren't able to do PvP could see the proximity informations in `pvplist`
* Fixed that the `pvphelp` command list contains unnecessary spaces

### LOTR compatibility:
* Improved the performance if the LOTR Mod is present
* Added a configurable override condition for the LOTR Mod (players in enemy biomes will have PvP mode ON)
* A file containing the LOTR biome ids now will be generated on startup (if the LOTR mod is present)
* Fixed that hired units from the LOTR Mod start attacking players/units with PvP mode OFF (without causing damage)
* Players which are in PvP cannot use the LOTR Mod fast travel system

## 1.0.0-BETA
### General changes:

#### Breaking changes:
* Java 8 is now required
* Removed `pvpcancel`. Canceling now will be done via `pvp cancel`

#### Misc:
* Added combat logging (two handlers: csv (default) and simple)
* Added a command `pvpconfig` for admins which displays the configuration data
* The default distance rounding factor for the player radar is now 100 instead of 64
* Improved `pvphelp`. Also it won't display configuration data anymore.
* Improved the performance and restructured things internally

#### Bug fixes:
* Fixed that typing invalid player names in `pvpadmin` outputs an unmeaningful error message

## 1.8.0-ALPHA
* Added a new command `pvphelp` which displays usage of all commands and also values of configuration options
* Player radar now rounds up rather than down

## 1.7.0-ALPHA
* Minor tweaks as suggested by MilkMC and AlteOgre
* The admin PvP command is now a separate command, `pvpadmin <playername>`
* Added a new command `pvpcancel` which cancels a player's warmup time

## 1.6.0-ALPHA
* The cooldown and warmup are now configurable in a configuration file
* Player radar behaviour is now configurable as well

## 1.5.0-ALPHA
* The `pvplist` command will now display player distances to the nearest four chunks for players who have PvP enabled
* There is now a cooldown as well as a warmup on the `pvp` command; the warmup is now 15 seconds rather than five

## 1.4.1-ALPHA
* Players in creative mode or who have fly ability have PvP disabled automatically

## 1.4.0-ALPHA
* Added a 5-second cooldown on the `pvp` command
* Removed on/off functionality; the command is now simply a toggle
* Added some messages that will send debug info to the log. This is so that the LOTR unit problem can be fixed

## 1.3.0-ALPHA
* Added a `pvplist` command that enables players to see who is PvP enabled or disabled
* Temporarily removed the config file option preparatory to LOTR mod testing

## 1.2.0-ALPHA
* Added a patch that disables LOTR units from attacking other players in PvP-off situations
* Added a patch that disables tamed wolves from attacking another player

## 1.1.0-ALPHA
* Added a config option that disables PvE along with PvP if the command is entered
* Fixed a bug with permission levels

## 1.0.0-ALPHA
* Added `pvp <on:off> [playername]` command
* Players cannot hit or shoot each other if either has PvP disabled
* Admins can enable/disable PvP for other players, but regular players can only do it on themselves
