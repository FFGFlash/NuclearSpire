package com.flash.ns.characters.crystal.powers;

import com.megacrit.cardcrawl.powers.AbstractPower;

public class CustomPower extends AbstractPower
{
    public CustomPower(String id, String name, String region, PowerType type)
    {
	ID = id;
	this.name = name;

	updateDescription();
	loadRegion(region);
	this.type = type;
    }
}
