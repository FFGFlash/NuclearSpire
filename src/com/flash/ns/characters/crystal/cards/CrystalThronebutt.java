
package com.flash.ns.characters.crystal.cards;

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

public class CrystalThronebutt extends CustomCard {

	public static final String ID = "Crystal_Thronebutt";

	private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;

	public static final String IMG_PATH = "images/cards/placeholder.png";

	public static final int COST = 1;
	public static final int UPGRADE_MODIFY_STRENGTH = 1;
	public static final int STRENGTH = 3;
	public static final int DEXTERITY = -1;
	
	public CrystalThronebutt() {
		super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.POWER, AbstractCardEnum.CRYSTAL, CardRarity.BASIC,
				CardTarget.SELF);
		magicNumber = baseMagicNumber = STRENGTH;
	}

	@Override
	public AbstractCard makeCopy() {
		return new CrystalThronebutt();
	}

	@Override
	public void upgrade() {
		if (!upgraded) {
			upgradeName();
			upgradeMagicNumber(1);
		}
	}

	@Override
	public void use(AbstractPlayer p, AbstractMonster m) {
		AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.ApplyPowerAction(p, p, new DexterityPower(p, DEXTERITY), DEXTERITY));
		AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.ApplyPowerAction(p, p, new StrengthPower(p, this.magicNumber), this.magicNumber));
	}

}
