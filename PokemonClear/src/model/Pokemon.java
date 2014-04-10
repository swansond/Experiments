package model;

import java.util.List;

public class Pokemon {
	int number; // 1 - 151 for now, eventually higher
	int level; // 1 - 100
	int currentExp; // current experience points
	Status currentStatus; // Burned, Paralyzed, Frozen, Asleep, Poisoned, Badly Poisoned
	List<Type> types; // up to 2 types
	List<Attack> attacks; // up to 4 attacks
	Item heldItem; // the currently held item
	int[] effortValues; // the current effort values
	int[] individualValues; // the pokemon's individual values
	String nickname; 
	
}
