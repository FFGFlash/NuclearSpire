package com.flash.ns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

import basemod.BaseMod;

public class StripperMod implements CharacterMod {
	public static final Logger logger = LogManager.getLogger(NuclearSpireMod.class.getName());
	
	public void removeCard(AbstractCard card) {
		BaseMod.removeCard(card.cardID, card.color);
	}

	@Override
	public void receiveEditCards() {
	}

	@Override
	public void receiveEditCharacters() {
	}

	@Override
	public void receiveEditRelics() {
	}

	@Override
	public void receiveEditStrings() {
	}

	@Override
	public void receiveEditKeywords() {
	}

	@Override
	public void receiveCardUsed(AbstractCard c) {
	}

	@Override
	public void receivePowersModified() {
	}

	@Override
	public void receivePostBattle(AbstractRoom battleRoom) {
	}

	@Override
	public void receivePostDungeonInitialize() {
	}

	@Override
	public void receivePostExhaust(AbstractCard c) {
	}

	@Override
	public void receivePostDraw(AbstractCard c) {
	}
}
