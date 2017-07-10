# textrpg
A Java-based RPG that I created over summer 2017. The game is designed to be easily extensible so others can add and remove items and change parameters as they like. The game's saves are in the TOML format.

To add a new attack: Decide whether it is a physical attack or a magic attack. If it is physical, add a constant to the PhysAttack enum in the attack package; if it is magical, add a constant to the MagAttack enum in the attack package. If there is any special logic you would like the attack to follow, provide it in the execute method of the Attack class in the attack package following the pattern of what is already there.

To add a new item: 
  For armor: add a constant to the Armor enum in the item package.
  For weapons: add a constant to the Weapon enum in the item package.
  For shields: add a constant to the Shield enum in the item package.
  For healing: add a constant to the Healing enum in the item package.
  
To add an enemy: extend the abstract Entity class in the entity package and implement the battle method, which contains the enemy AI. Then modify the spawn method in the RoomTile class in the map package to set the conditions under which the new enemy will spawn in the infinite dungeon.

To modify enemy logic: modify that enemy's battle method.


