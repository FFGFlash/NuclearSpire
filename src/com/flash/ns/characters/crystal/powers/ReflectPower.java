package com.flash.ns.characters.crystal.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;

public class ReflectPower extends CustomPower
{
    public static final String POWER_ID = "Reflect";

    private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
    public static final String NAME = powerStrings.NAME;
    public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

    public ReflectPower(AbstractCreature owner, int amount)
    {
	super(POWER_ID, NAME, "rebound", PowerType.BUFF);

	this.owner = owner;
	this.amount = amount;

	if (this.amount > 9999)
	{
	    this.amount = 9999;
	}

	isTurnBased = true;
    }

    @Override
    public void playApplyPowerSfx()
    {
	CardCrawlGame.sound.play("POWER_POISON", 0.05F);
    }

    @Override
    public void updateDescription()
    {
	description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }

    @Override
    public void atEndOfTurn(boolean isPlayer)
    {
	this.amount--;
    }
}
