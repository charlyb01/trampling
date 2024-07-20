# Versions Changelog

* **X versions** are major updates with lots of new content. Very rare
* **x.X versions** are either updates that add content or major bug fixes
* **x.x.X versions** are either small content updates (language translation, new textures, ...) or bug fixes

## v1.1.2
* Use item tag to prevent trampling, so we can add other foot armors
* Use enchantment tag to prevent trampling, so we can add foot armor enchantments

## v1.1.1
* Port to 1.20.1

## v1.1
### Crops breaking
* Crops can be broken when a living entity walks on it.
* Applies only to player if *mob griefing* rule is disabled. 
* Default 5% chance to break on collision with an entity.

### Crops growth stunning
* Crops growth can be stunned when a living entity walks on it.
* Applies only to player if *mob griefing* rule is disabled. 
* Default 80% chance to get stunned.
* Stun can disappear after trying to grow again.
* Default 10% chance to remove stun status on growth try.

### Crops buff
* Crops breaking and growth stunning isn't enabled if wearing leather boots, having any level of feather falling 
  enchantment, or sneaking.
* Sneaking when falling on crops won't disable trampling.

## v1.0
* Wearing leather boots disable trampling (when landing on crops).
* Same thing if wearing boots with any level of feather falling enchantment.
