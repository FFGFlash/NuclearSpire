package com.flash.ns.cards.crystal;

import com.flash.ns.patches.AbstractCardEnum;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import basemod.abstracts.CustomCard;

public class CrystalTeleport extends CustomCard {

	public static final String ID = "Crystal_Teleport";

	private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;

	public static final String IMG_PATH = "images/cards/placeholder.png";

	public static final int COST = 1;
	public static final int UPGRADE_MODIFY_STRENGTH = 1;
	public static final int UPGRADE_MODIFY_DEXTERITY = -1;
	public static final int STRENGTH = 2;
	public static final int DEXTERITY = 1;
	
	public CrystalTeleport() {
		super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.POWER, AbstractCardEnum.CRYSTAL, CardRarity.BASIC,
				CardTarget.SELF);
		magicNumber = baseMagicNumber = STRENGTH;
	}

	@Override
	public AbstractCard makeCopy() {
		return new CrystalTeleport();
	}

	@Override
	public void upgrade() {
		if (!upgraded) {
			upgradeName();
			upgradeBlock(UPGRADE_PLUS_BLOCK);
		}
	}

	@Override
	public void use(AbstractPlayer p, AbstractMonster m) {
		AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, block));
	}

}
