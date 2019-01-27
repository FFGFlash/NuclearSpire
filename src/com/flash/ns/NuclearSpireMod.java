package com.flash.ns;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.EditKeywordsSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.OnCardUseSubscriber;
import basemod.interfaces.OnPowersModifiedSubscriber;
import basemod.interfaces.PostBattleSubscriber;
import basemod.interfaces.PostDrawSubscriber;
import basemod.interfaces.PostDungeonInitializeSubscriber;
import basemod.interfaces.PostExhaustSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import basemod.interfaces.SetUnlocksSubscriber;

@SpireInitializer
public class NuclearSpireMod implements PostInitializeSubscriber, EditCardsSubscriber, EditRelicsSubscriber,
		EditCharactersSubscriber, EditStringsSubscriber, SetUnlocksSubscriber, OnCardUseSubscriber,
		EditKeywordsSubscriber, OnPowersModifiedSubscriber, PostExhaustSubscriber, PostBattleSubscriber,
		PostDungeonInitializeSubscriber, PostDrawSubscriber {

	public static final Logger logger = LogManager.getLogger(NuclearSpireMod.class.getName());
	private List<CharacterMod> mods;

	public NuclearSpireMod() {
		BaseMod.subscribe(this);

		mods = new ArrayList<>();
		mods.add(new StripperMod());
		mods.add(new CrystalMod());
	}

	public static void initialize() {
		logger.info("Begin Initializing");

		@SuppressWarnings("unused")
		NuclearSpireMod nuclearSpire = new NuclearSpireMod();

		logger.info("Done Initializing");
	}

	@Override
	public void receiveEditCards() {
		logger.info("Begin Editting Cards");

		for (EditCardsSubscriber mod : mods) {
			mod.receiveEditCards();
		}

		logger.info("Done Editting Cards");
	}

	@Override
	public void receivePostDraw(AbstractCard c) {
		for (PostDrawSubscriber mod : mods) {
			mod.receivePostDraw(c);
		}
	}

	@Override
	public void receivePostDungeonInitialize() {
		for (PostDungeonInitializeSubscriber mod : mods) {
			mod.receivePostDungeonInitialize();
		}
	}

	@Override
	public void receivePostBattle(AbstractRoom battleRoom) {
		for (PostBattleSubscriber mod : mods) {
			mod.receivePostBattle(battleRoom);
		}
	}

	@Override
	public void receivePostExhaust(AbstractCard c) {
		for (PostExhaustSubscriber mod : mods) {
			mod.receivePostExhaust(c);
		}
	}

	@Override
	public void receivePowersModified() {
		for (OnPowersModifiedSubscriber mod : mods) {
			mod.receivePowersModified();
		}
	}

	@Override
	public void receiveEditKeywords() {
		logger.info("Begin Editting Keywords");

		for (EditKeywordsSubscriber mod : mods) {
			mod.receiveEditKeywords();
		}

		logger.info("Done Editting Keywords");
	}

	@Override
	public void receiveCardUsed(AbstractCard c) {
		for (OnCardUseSubscriber mod : mods) {
			mod.receiveCardUsed(c);
		}
	}

	@Override
	public void receiveEditStrings() {
		logger.info("Begin Editting Strings");

		for (EditStringsSubscriber mod : mods) {
			mod.receiveEditStrings();
		}

		logger.info("Done Editting Strings");
	}

	@Override
	public void receiveEditCharacters() {
		logger.info("Begin Editting Characters");

		for (EditCharactersSubscriber mod : mods) {
			mod.receiveEditCharacters();
		}

		logger.info("Done Editting Characters");
	}

	@Override
	public void receiveEditRelics() {
		logger.info("Begin Editting Relics");

		for (EditRelicsSubscriber mod : mods) {
			mod.receiveEditRelics();
		}

		logger.info("Done Editting Relics");
	}

	@Override
	public void receivePostInitialize() {
	}

	@Override
	public void receiveSetUnlocks() {
	}
}
