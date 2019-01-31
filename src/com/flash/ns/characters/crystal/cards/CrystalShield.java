package com.flash.ns.characters.crystal.cards;

import com.flash.ns.patches.AbstractCardEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import basemod.abstracts.CustomCard;

/**
 * 
 * @author Flash
 * @version 0.0.1
 *
 */
public class CrystalShield extends CustomCard {
	/**
	 * The card ID.
	 */
	public static final String ID = "Crystal_Shield";

	/**
	 * The card's CardString.
	 */
	private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);

	/**
	 * The name of the card.
	 */
	public static final String NAME = cardStrings.NAME;

	/**
	 * The description of the card.
	 */
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;

	/**
	 * The image the card will display.
	 */
	public static final String IMG_PATH = "images/cards/placeholder.png";

	/**
	 * The amount of energy the card will use.<br>
	 * If the value is negative one then it'll consume as much energy as possible.
	 */
	public static final int COST = 2;

	/**
	 * Class constructor.
	 */
	public CrystalShield() {
		super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.SKILL, AbstractCardEnum.CRYSTAL, CardRarity.BASIC,
				CardTarget.ALL_ENEMY);
	}

	/**
	 * Called to make a copy of the card.
	 */
	@Override
	public AbstractCard makeCopy() {
		return new CrystalShield();
	}

	/**
	 * Called to upgrade the card.
	 */
	@Override
	public void upgrade() {
		if (!upgraded) {
			upgradeName();
			updateCost(1);
		}
	}

	/**
	 * Called when the card is played.
	 */
	@Override
	public void use(AbstractPlayer p, AbstractMonster m) {

	}
}
