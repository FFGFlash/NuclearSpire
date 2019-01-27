package com.flash.ns.characters;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.MathUtils;
import com.flash.ns.patches.AbstractCardEnum;
import com.flash.ns.patches.PlayerClassEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.AbstractCard.CardColor;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ScreenShake;
import com.megacrit.cardcrawl.screens.CharSelectInfo;

import basemod.abstracts.CustomPlayer;
import basemod.animations.SpineAnimation;

public class Crystal extends CustomPlayer {
	public static final int ENERGY_PER_TURN = 3;
	public static final String SHOULDER_2 = "images/characters/crystal/shoulder2.png";
	public static final String SHOULDER_1 = "images/characters/crystal/shoulder1.png";
	public static final String CORPSE = "images/characters/crystal/corpse.png";
	public static final String SKELETON_ATLAS = "images/characters/crystal/idle/skeleton.atlas";
	public static final String SKELETON_JSON = "images/characters/crystal/idle/skeleton.json";

	public Crystal(String name) {
		super(name, PlayerClassEnum.CRYSTAL, null, null, new SpineAnimation(SKELETON_ATLAS, SKELETON_JSON, 1.0f));

		initializeClass(null, SHOULDER_2, SHOULDER_1, CORPSE, getLoadout(), 20.0F, -10.0F, 220.0F, 290.0F,
				new EnergyManager(ENERGY_PER_TURN));
	}

	@Override
	public ArrayList<String> getStartingDeck() {
		ArrayList<String> retVal = new ArrayList<>();
		
		retVal.add("Revolver_Crystal");
		retVal.add("Revolver_Crystal");
		retVal.add("Revolver_Crystal");
		retVal.add("Revolver_Crystal");
		retVal.add("Revolver_Crystal");

		retVal.add("Crystal_Shield");
		
		retVal.add("Shield_Crystal");
		retVal.add("Shield_Crystal");
		retVal.add("Shield_Crystal");
		retVal.add("Shield_Crystal");
		
		return retVal;
	}

	@Override
	public ArrayList<String> getStartingRelics() {
		ArrayList<String> retVal = new ArrayList<>();
		return retVal;
	}

	@Override
	public CharSelectInfo getLoadout() {
		return new CharSelectInfo("Crystal", "A mutant from the Crystal Caves, trying to save her family who are trapped in crystal form.", 80, 80, 0, 99, 5, this, getStartingRelics(), getStartingDeck(), false);
	}

	@Override
	public String getTitle(PlayerClass paramPlayerClass) {
		return "Crystal";
	}

	@Override
	public CardColor getCardColor() {
		return AbstractCardEnum.CRYSTAL;
	}

	@Override
	public Color getCardRenderColor() {
		return Color.PURPLE;
	}

	@Override
	public AbstractCard getStartCardForEvent() {
		return null;
	}

	@Override
	public Color getCardTrailColor() {
		return Color.PURPLE;
	}

	@Override
	public int getAscensionMaxHPLoss() {
		return 13;
	}

	@Override
	public BitmapFont getEnergyNumFont() {
		return FontHelper.energyNumFontRed;
	}

	@Override
	public void doCharSelectScreenSelectEffect() {
		CardCrawlGame.sound.playA("ATTACK_HEAVY", MathUtils.random(-0.2f, 0.2f));
		CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.HIGH, ScreenShake.ShakeDur.XLONG, true);
	}

	@Override
	public String getCustomModeCharacterButtonSoundKey() {
		return "ATTACK_HEAVY";
	}

	@Override
	public String getLocalizedCharacterName() {
		return "Crystal";
	}

	@Override
	public AbstractPlayer newInstance() {
		return new Crystal(name);
	}

	@Override
	public String getSpireHeartText() {
		return null;
	}

	@Override
	public Color getSlashAttackColor() {
		return null;
	}

	@Override
	public AttackEffect[] getSpireHeartSlashEffect() {
		return new AbstractGameAction.AttackEffect[0];
	}

	@Override
	public String getVampireText() {
		return null;
	}

}
