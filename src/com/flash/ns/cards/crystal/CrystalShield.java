package com.flash.ns.cards.crystal;

import com.flash.ns.patches.AbstractCardEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import basemod.abstracts.CustomCard;

public class CrystalShield extends CustomCard {
	public static final String ID = "Crystal_Shield";

	private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;

	public static final String IMG_PATH = "images/cards/placeholder.png";

	public static final int COST = 2;

	public CrystalShield() {
		super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.SKILL, AbstractCardEnum.CRYSTAL, CardRarity.BASIC,
				CardTarget.SELF);
	}

	@Override
	public AbstractCard makeCopy() {
		return new CrystalShield();
	}

	@Override
	public void upgrade() {
		if (!upgraded) {
			upgradeName();
			updateCost(1);
		}
	}

	@Override
	public void use(AbstractPlayer p, AbstractMonster m) {
		
	}
}
