
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

import basemod.abstracts.CustomCard;

public class Crystal_Scarier_Face extends CustomCard
{

    public static final String ID = "Crystal_Scarier_Face";

    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    public static final String IMG_PATH = "images/cards/placeholder.png";

    public static final int COST = 2;
    public static final int UPGRADE_COST = 0;

    // Constructor
    public Crystal_Scarier_Face()
    {
	super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.SKILL, AbstractCardEnum.CRYSTAL, CardRarity.RARE,
		CardTarget.ALL_ENEMY);
	exhaust = true;
    }

    // On make copy of card
    @Override
    public AbstractCard makeCopy()
    {
	return new Crystal_Scarier_Face();
    }

    // On upgrade
    @Override
    public void upgrade()
    {
	if (!upgraded)
	{
	    upgradeName();
	    isInnate = true;
	    // TODO: Fix description on upgrade
	}
    }

    // On card use
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
	for (AbstractMonster _m : AbstractDungeon.getCurrRoom().monsters.monsters)
	{
	    // TODO: Add visual effects
	    _m.maxHealth = (int) Math.round(_m.maxHealth * 0.8F);
	    _m.currentHealth = Math.min(_m.currentHealth, _m.maxHealth);
	    _m.healthBarUpdatedEvent();
	}
    }

}
