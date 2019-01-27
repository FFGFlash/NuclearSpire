package com.flash.ns;

import basemod.interfaces.*;

public interface CharacterMod extends EditCharactersSubscriber, EditRelicsSubscriber, EditCardsSubscriber,
		EditStringsSubscriber, EditKeywordsSubscriber, OnCardUseSubscriber, OnPowersModifiedSubscriber,
		PostBattleSubscriber, PostDungeonInitializeSubscriber, PostExhaustSubscriber, PostDrawSubscriber {
}