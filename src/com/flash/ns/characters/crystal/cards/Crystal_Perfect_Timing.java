
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
import com.megacrit.cardcrawl.powers.BlurPower;

import basemod.abstracts.CustomCard;

public class Crystal_Perfect_Timing extends CustomCard
{

    public static final String ID = "Crystal_Perfect_Timing";

    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    public static final String IMG_PATH = "images/cards/placeholder.png";

    public static final int COST = 1;
    public static final int UPGRADE_COST = 0;

    // Constructor
    public Crystal_Perfect_Timing()
    {
	super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.SKILL, AbstractCardEnum.CRYSTAL, CardRarity.BASIC,
		CardTarget.SELF);
    }

    // On make copy of card
    @Override
    public AbstractCard makeCopy()
    {
	return new Crystal_Perfect_Timing();
    }

    // On upgrade
    @Override
    public void upgrade()
    {
	if (!upgraded)
	{
	    upgradeName();
	    upgradeBaseCost(UPGRADE_COST);
	}
    }

    // On card use
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
	AbstractDungeon.actionManager
		.addToBottom(new com.megacrit.cardcrawl.actions.common.ApplyPowerAction(p, p, new BlurPower(p, 1), 1));
    }

}
