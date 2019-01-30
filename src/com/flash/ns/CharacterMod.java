package com.flash.ns;

import basemod.interfaces.*;

/**
 * 
 * Character Mod Interface
 * 
 * @author Flash
 * @version 0.0.1
 * 
 */
public interface CharacterMod
		extends EditCharactersSubscriber, EditRelicsSubscriber, EditCardsSubscriber, EditStringsSubscriber,
		EditKeywordsSubscriber, OnCardUseSubscriber, OnPowersModifiedSubscriber, PostBattleSubscriber,
		PostDungeonInitializeSubscriber, PostExhaustSubscriber, PostDrawSubscriber, PreMonsterTurnSubscriber {
}