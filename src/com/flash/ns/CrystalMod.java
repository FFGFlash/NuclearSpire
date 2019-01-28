package com.flash.ns;

import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.flash.ns.cards.crystal.CrystalShards;
import com.flash.ns.cards.crystal.CrystalShield;
import com.flash.ns.cards.crystal.Revolver_Crystal;
import com.flash.ns.cards.crystal.Shield_Crystal;
import com.flash.ns.characters.Crystal;
import com.flash.ns.patches.AbstractCardEnum;
import com.flash.ns.patches.PlayerClassEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

import basemod.BaseMod;

public class CrystalMod implements CharacterMod {
	public static final Logger logger = LogManager.getLogger(NuclearSpireMod.class.getName());

	private static final Color PURPLE = CardHelper.getColor(139.0f, 0.0f, 139.0f);

	private static final String ATTACK = "images/characters/crystal/card/512/bg_attack.png";
	private static final String SKILL = "images/characters/crystal/card/512/bg_skill.png";
	private static final String POWER = "images/characters/crystal/card/512/bg_power.png";
	private static final String ENERGY_ORB = "images/characters/crystal/card/512/card_orb.png";
	private static final String CARD_ENERGY_ORB = "images/characters/crystal/card/512/card_small_orb.png";

	private static final String ATTACK_PORTRAIT = "images/characters/crystal/card/1024/bg_attack.png";
	private static final String SKILL_PORTRAIT = "images/characters/crystal/card/1024/bg_skill.png";
	private static final String POWER_PORTRAIT = "images/characters/crystal/card/1024/bg_power.png";
	private static final String ENERGY_ORB_PORTRAIT = "images/characters/crystal/card/1024/card_orb.png";

	private static final String BUTTON = "images/characters/crystal/button.png";
	private static final String PORTRAIT = "images/characters/crystal/portrait.jpg";

	private static final String CARD_STRINGS = "localization/crystal_cards.json";
	private static final String RELIC_STRINGS = "localization/crystal_relics.json";

	public CrystalMod() {
		logger.info("Adding Color " + AbstractCardEnum.CRYSTAL.toString());

		BaseMod.addColor(AbstractCardEnum.CRYSTAL, PURPLE, ATTACK, SKILL, POWER, ENERGY_ORB, ATTACK_PORTRAIT,
				SKILL_PORTRAIT, POWER_PORTRAIT, ENERGY_ORB_PORTRAIT, CARD_ENERGY_ORB);
	}

	@Override
	public void receiveEditCharacters() {
		logger.info("Adding Character " + PlayerClassEnum.CRYSTAL.toString());

		BaseMod.addCharacter(new Crystal(CardCrawlGame.playerName), BUTTON, PORTRAIT, PlayerClassEnum.CRYSTAL);
	}

	@Override
	public void receiveEditRelics() {

	}

	@Override
	public void receiveEditCards() {
		BaseMod.addCard(new Revolver_Crystal());
		BaseMod.addCard(new CrystalShield());
		BaseMod.addCard(new Shield_Crystal());
		BaseMod.addCard(new CrystalShards());
	}

	@Override
	public void receiveEditStrings() {
		String relicStrings = Gdx.files.internal(RELIC_STRINGS).readString(String.valueOf(StandardCharsets.UTF_8));
		BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);

		String cardStrings = Gdx.files.internal(CARD_STRINGS).readString(String.valueOf(StandardCharsets.UTF_8));
		BaseMod.loadCustomStrings(CardStrings.class, cardStrings);
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
