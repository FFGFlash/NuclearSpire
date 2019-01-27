package com.flash.ns.cards.crystal;

import com.flash.ns.patches.AbstractCardEnum;
import com.megacrit.cardcrawl.actions.unique.WhirlwindAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import basemod.abstracts.CustomCard;

public class CrystalShards extends CustomCard {
	public static final String ID = "Crystal_Shards";

	private static CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;

	public static final String IMG_PATH = "images/cards/placeholder.png";

	public static final int COST = -1;
	public static final int UPGRADE_PLUS_DMG = 3;
	public static final int ATTACK_DMG = 5;

	public CrystalShards() {
		super(ID, NAME, IMG_PATH, COST, DESCRIPTION, CardType.ATTACK, AbstractCardEnum.CRYSTAL, CardRarity.COMMON,
				CardTarget.ALL_ENEMY);
		damage = baseDamage = ATTACK_DMG;
		isMultiDamage = true;
	}

	@Override
	public AbstractCard makeCopy() {
		return new Shield_Crystal();
	}

	@Override
	public void upgrade() {
		if (!upgraded) {
			upgradeName();
			upgradeDamage(UPGRADE_PLUS_DMG);
		}
	}

	@Override
	public void use(AbstractPlayer p, AbstractMonster m) {
		if (energyOnUse < EnergyPanel.totalCount) {
			energyOnUse = EnergyPanel.totalCount;
		}

		AbstractDungeon.actionManager
				.addToBottom(new WhirlwindAction(p, multiDamage, damageTypeForTurn, freeToPlayOnce, energyOnUse));
	}
}
