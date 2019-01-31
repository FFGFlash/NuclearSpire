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
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.screens.CharSelectInfo;

import basemod.abstracts.CustomPlayer;
import basemod.animations.SpineAnimation;

/**
 * 
 * @author Flash
 * @version 0.0.1
 *
 */
public class Crystal extends CustomPlayer {
	public static final int ENERGY_PER_TURN = 3;
	public static final String SHOULDER_2 = "images/characters/crystal/shoulder2.png";
	public static final String SHOULDER_1 = "images/characters/crystal/shoulder1.png";
	public static final String CORPSE = "images/characters/crystal/corpse.png";
	public static final String SKELETON_ATLAS = "images/characters/crystal/idle/skeleton.atlas";
	public static final String SKELETON_JSON = "images/characters/crystal/idle/skeleton.json";

	public static final String ID = "Crystal";
	private static final CharacterStrings characterStrings = CardCrawlGame.languagePack.getCharacterString(ID);
	public static final String[] NAMES = characterStrings.NAMES;
	public static final String[] TEXT = characterStrings.TEXT;
	private static final int STARTING_HP = 80;
	private static final int STARTING_GOLD = 99;
	private static final int MAX_ORBS = 0;
	private static final int CARD_DRAW = 5;

	/**
	 * 
	 * Class constructor.
	 * 
	 * @param name
	 *            The player's username.
	 */
	public Crystal(String name) {
		super(name, PlayerClassEnum.CRYSTAL, null, null, new SpineAnimation(SKELETON_ATLAS, SKELETON_JSON, 1.0f));

		initializeClass(null, SHOULDER_2, SHOULDER_1, CORPSE, getLoadout(), 20.0F, -10.0F, 220.0F, 290.0F,
				new EnergyManager(ENERGY_PER_TURN));
	}

	/**
	 * @return The character's starting deck.
	 */
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
		
		retVal.add("Crystal_Thronebutt");
		retVal.add("Crystal_Needle_Rain");

		return retVal;
	}

	/**
	 * @return The charcter's starting relics.
	 */
	@Override
	public ArrayList<String> getStartingRelics() {
		ArrayList<String> retVal = new ArrayList<>();
		return retVal;
	}

	/**
	 * @return The character's selection info.
	 */
	@Override
	public CharSelectInfo getLoadout() {
		return new CharSelectInfo(NAMES[0], TEXT[0], STARTING_HP, STARTING_HP, MAX_ORBS, STARTING_GOLD, CARD_DRAW, this,
				getStartingRelics(), getStartingDeck(), false);
	}

	/**
	 * @return The character's title.
	 */
	@Override
	public String getTitle(PlayerClass paramPlayerClass) {
		return "Crystal";
	}

	/**
	 * @return The card color which this character uses.
	 */
	@Override
	public CardColor getCardColor() {
		return AbstractCardEnum.CRYSTAL;
	}

	/**
	 * @return The render color which this character uses.
	 */
	@Override
	public Color getCardRenderColor() {
		return Color.PURPLE;
	}

	@Override
	public AbstractCard getStartCardForEvent() {
		return null;
	}

	/**
	 * @return The trail color which this character uses.
	 */
	@Override
	public Color getCardTrailColor() {
		return Color.PURPLE;
	}

	/**
	 * @return The health loss for ascension run.
	 */
	@Override
	public int getAscensionMaxHPLoss() {
		return 13;
	}

	/**
	 * @return The font used for energy.
	 */
	@Override
	public BitmapFont getEnergyNumFont() {
		return FontHelper.energyNumFontRed;
	}
	
	/**
	 * Called when player selects the character
	 */
	@Override
	public void doCharSelectScreenSelectEffect() {
		CardCrawlGame.sound.playA("ATTACK_HEAVY", MathUtils.random(-0.2f, 0.2f));
		CardCrawlGame.screenShake.shake(ScreenShake.ShakeIntensity.MED, ScreenShake.ShakeDur.SHORT, true);
	}
	
	/**
	 * Called when player selects the character for CustomMode
	 */
	@Override
	public String getCustomModeCharacterButtonSoundKey() {
		return "ATTACK_HEAVY";
	}
	
	/**
	 * @return The character's name.
	 */
	@Override
	public String getLocalizedCharacterName() {
		return "Crystal";
	}
	
	/**
	 * Creates a new instance of the character.
	 */
	@Override
	public AbstractPlayer newInstance() {
		return new Crystal(name);
	}
	
	/**
	 * @return The text to display when completing a run.
	 */
	@Override
	public String getSpireHeartText() {
		return null;
	}
	
	/**
	 * @return The slash color which this character uses.
	 */
	@Override
	public Color getSlashAttackColor() {
		return null;
	}
	
	/**
	 * @return The attack effect when reaching the heart.
	 */
	@Override
	public AttackEffect[] getSpireHeartSlashEffect() {
		return new AbstractGameAction.AttackEffect[0];
	}
	
	/**
	 * @return The text for the vampire event?
	 */
	@Override
	public String getVampireText() {
		return null;
	}

}
