
package com.flash.ns.characters.crystal.cards;

/*
 * @author Knilax
 * @version 0.0.1
 */
import com.flash.ns.patches.AbstractCardEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import basemod.abstracts.CustomCard;

public class Crystal_Thronebutt extends CustomCard {

	public static final String ID = "Crystal_Thronebutt";

	private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;

	public static final String IMG_PATH = "images/cards/placeholder.png";

	public static final int COST = 1;
	public static final int UPGRADE_MODIFY_STRENGTH = 1;
	public static final int STRENGTH = 3;
	public static final int DEXTERITY = -1;
	
	// Constructor
	public Crystal_Thronebutt()
	{
		super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.POWER, AbstractCardEnum.CRYSTAL, CardRarity.BASIC,
				CardTarget.SELF);
		magicNumber = baseMagicNumber = STRENGTH;
	}
	
	// On make copy of card
	@Override
	public AbstractCard makeCopy()
	{
		return new Crystal_Thronebutt();
	}
	
	// On upgrade
	@Override
	public void upgrade()
	{
		if (!upgraded)
		{
			upgradeName();
			upgradeMagicNumber(1);
		}
	}
	
	// On card use
	@Override
	public void use(AbstractPlayer p, AbstractMonster m)
	{
		AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.ApplyPowerAction(p, p, new DexterityPower(p, DEXTERITY), DEXTERITY));
		AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.ApplyPowerAction(p, p, new StrengthPower(p, this.magicNumber), this.magicNumber));
	}

}
