
package com.flash.ns.characters.crystal.cards;

/*
 * @author Knilax
 * @author Flash
 * @version 0.0.1
 */
import com.flash.ns.patches.AbstractCardEnum;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import basemod.abstracts.CustomCard;

public class Crystal_Hammerhead extends CustomCard
{

    public static final String ID = "Crystal_Hammerhead";

    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    public static final String IMG_PATH = "images/cards/placeholder.png";

    public static final int COST = 1;
    public static final int BLOCK = 7;
    public static final int UPGRADE_AMNT = 3;

    // Constructor
    public Crystal_Hammerhead()
    {
	super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.SKILL, AbstractCardEnum.CRYSTAL, CardRarity.COMMON,
		CardTarget.ALL_ENEMY);
	block = baseBlock = BLOCK;
    }

    // On make copy of card
    @Override
    public AbstractCard makeCopy()
    {
	return new Crystal_Hammerhead();
    }

    // On upgrade
    @Override
    public void upgrade()
    {
	if (!upgraded)
	{
	    upgradeName();
	    upgradeBlock(UPGRADE_AMNT);
	}
    }

    // On card use
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
	AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, block));
    }

}
