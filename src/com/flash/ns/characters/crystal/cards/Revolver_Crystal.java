package com.flash.ns.characters.crystal.cards;

import com.flash.ns.patches.AbstractCardEnum;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import basemod.abstracts.CustomCard;

/**
 * 
 * @author Flash
 * @version 0.0.1
 *
 */
public class Revolver_Crystal extends CustomCard {
	/**
	 * The card ID.
	 */
	public static final String ID = "Revolver_Crystal";

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
	public static final int COST = 1;

	public static final int UPGRADE_PLUS_DMG = 3;
	public static final int ATTACK_DMG = 6;

	/**
	 * Class constructor.
	 */
	public Revolver_Crystal() {
		super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.ATTACK, AbstractCardEnum.CRYSTAL, CardRarity.BASIC,
				CardTarget.ENEMY);
		damage = baseDamage = ATTACK_DMG;
	}

	/**
	 * Called to make a copy of the card.
	 */
	@Override
	public AbstractCard makeCopy() {
		return new Revolver_Crystal();
	}

	/**
	 * Called to upgrade the card.
	 */
	@Override
	public void upgrade() {
		if (!upgraded) {
			upgradeName();
			upgradeDamage(UPGRADE_PLUS_DMG);
		}
	}

	/**
	 * Called when the card is played.
	 */
	@Override
	public void use(AbstractPlayer p, AbstractMonster m) {
		AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn),
				AbstractGameAction.AttackEffect.BLUNT_LIGHT));
	}

}
