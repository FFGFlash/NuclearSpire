
package com.flash.ns.characters.crystal.cards;

/*
 * @author Knilax
 * @version 0.0.1
 */
import com.flash.ns.patches.AbstractCardEnum;
import com.flash.ns.patches.CardTagsEnum;
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

public class Crystal_Needle_Rain extends CustomCard
{

    public static final String ID = "Crystal_Needle_Rain";

    private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    public static final String NAME = cardStrings.NAME;
    public static final String DESCRIPTION = cardStrings.DESCRIPTION;

    public static final String IMG_PATH = "images/cards/placeholder.png";

    public static final int COST = 1;
    public static final int DAMAGE_PER = 2;
    public static final int UPGRADE_BONUS = 1;

    // Constructor
    public Crystal_Needle_Rain()
    {
	super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.ATTACK, AbstractCardEnum.CRYSTAL, CardRarity.RARE,
		CardTarget.ENEMY);
	damage = baseDamage = 0;
	magicNumber = baseMagicNumber = DAMAGE_PER;
    }

    // Count number of shard cards
    public static int countShards()
    {
	int num = 0;
	for (AbstractCard c : AbstractDungeon.player.hand.group)
	    if (c.hasTag(CardTagsEnum.SHARD))
		num++;
	for (AbstractCard c : AbstractDungeon.player.drawPile.group)
	    if (c.hasTag(CardTagsEnum.SHARD))
		num++;
	for (AbstractCard c : AbstractDungeon.player.discardPile.group)
	    if (c.hasTag(CardTagsEnum.SHARD))
		num++;
	return num;
    }

    // On make copy of card
    @Override
    public AbstractCard makeCopy()
    {
	return new Crystal_Needle_Rain();
    }

    // On upgrade
    @Override
    public void upgrade()
    {
	if (!upgraded)
	{
	    upgradeName();
	    upgradeMagicNumber(UPGRADE_BONUS);
	}
    }

    // On card use
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
	AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn),
		AbstractGameAction.AttackEffect.BLUNT_LIGHT));
    }

}
