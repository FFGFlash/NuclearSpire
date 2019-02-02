package com.flash.ns;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.badlogic.gdx.Gdx;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;
import basemod.interfaces.EditKeywordsSubscriber;
import basemod.interfaces.EditRelicsSubscriber;
import basemod.interfaces.EditStringsSubscriber;
import basemod.interfaces.OnCardUseSubscriber;
import basemod.interfaces.OnPowersModifiedSubscriber;
import basemod.interfaces.PostBattleSubscriber;
import basemod.interfaces.PostDrawSubscriber;
import basemod.interfaces.PostDungeonInitializeSubscriber;
import basemod.interfaces.PostExhaustSubscriber;
import basemod.interfaces.PostInitializeSubscriber;
import basemod.interfaces.PreMonsterTurnSubscriber;
import basemod.interfaces.SetUnlocksSubscriber;

/**
 * 
 * The Core Mod, Slay The Spire events run through here and are then pass them
 * to the {@linkplain CharacterMod}s.
 * 
 * @author Flash
 * @version 0.0.1
 *
 */
@SpireInitializer
public class NuclearSpireMod implements PostInitializeSubscriber, EditCardsSubscriber, EditRelicsSubscriber,
	EditCharactersSubscriber, EditStringsSubscriber, SetUnlocksSubscriber, OnCardUseSubscriber,
	EditKeywordsSubscriber, OnPowersModifiedSubscriber, PostExhaustSubscriber, PostBattleSubscriber,
	PostDungeonInitializeSubscriber, PostDrawSubscriber, PreMonsterTurnSubscriber
{

    /**
     * The {@linkplain Logger} used to print debug info to the console.
     */
    public static final Logger logger = LogManager.getLogger(NuclearSpireMod.class.getName());

    private static final String CHARACTER_STRINGS = "localization/characters.json";

    /**
     * List of {@linkplain CharacterMod}s.
     */
    private List<CharacterMod> mods;

    /**
     * Constructor
     */
    public NuclearSpireMod()
    {
	BaseMod.subscribe(this);

	mods = new ArrayList<>();
	mods.add(new CrystalMod());
    }

    /**
     * Initializes Nuclear Spire
     */
    public static void initialize()
    {
	logger.info("Begin Initializing");

	@SuppressWarnings("unused")
	NuclearSpireMod nuclearSpire = new NuclearSpireMod();

	logger.info("Done Initializing");
    }

    /**
     * Add and Remove Cards
     */
    @Override
    public void receiveEditCards()
    {
	logger.info("Begin Editting Cards");

	for (EditCardsSubscriber mod : mods)
	{
	    mod.receiveEditCards();
	}

	logger.info("Done Editting Cards");
    }

    /**
     * Called after the player draws cards.
     */
    @Override
    public void receivePostDraw(AbstractCard c)
    {
	for (PostDrawSubscriber mod : mods)
	{
	    mod.receivePostDraw(c);
	}
    }

    /**
     * Called after a dungeon is initialized.
     */
    @Override
    public void receivePostDungeonInitialize()
    {
	for (PostDungeonInitializeSubscriber mod : mods)
	{
	    mod.receivePostDungeonInitialize();
	}
    }

    /**
     * Called after a battle.
     */
    @Override
    public void receivePostBattle(AbstractRoom battleRoom)
    {
	for (PostBattleSubscriber mod : mods)
	{
	    mod.receivePostBattle(battleRoom);
	}
    }

    /**
     * Called after a card is exhausted.
     */
    @Override
    public void receivePostExhaust(AbstractCard c)
    {
	for (PostExhaustSubscriber mod : mods)
	{
	    mod.receivePostExhaust(c);
	}
    }

    /**
     * Called when powers are modified.
     */
    @Override
    public void receivePowersModified()
    {
	for (OnPowersModifiedSubscriber mod : mods)
	{
	    mod.receivePowersModified();
	}
    }

    /**
     * Add and Remove Keywords.
     */
    @Override
    public void receiveEditKeywords()
    {
	logger.info("Begin Editting Keywords");

	for (EditKeywordsSubscriber mod : mods)
	{
	    mod.receiveEditKeywords();
	}

	logger.info("Done Editting Keywords");
    }

    /**
     * Called when a card is played.
     */
    @Override
    public void receiveCardUsed(AbstractCard c)
    {
	for (OnCardUseSubscriber mod : mods)
	{
	    mod.receiveCardUsed(c);
	}
    }

    /**
     * Add and Remove CardStrings, RelicStrings, and CharacterStrings.
     */
    @Override
    public void receiveEditStrings()
    {
	logger.info("Begin Editting Strings");

	String characterStrings = Gdx.files.internal(CHARACTER_STRINGS)
		.readString(String.valueOf(StandardCharsets.UTF_8));
	BaseMod.loadCustomStrings(CharacterStrings.class, characterStrings);

	for (EditStringsSubscriber mod : mods)
	{
	    mod.receiveEditStrings();
	}

	logger.info("Done Editting Strings");
    }

    /**
     * Add and Remove Characters.
     */
    @Override
    public void receiveEditCharacters()
    {
	logger.info("Begin Editting Characters");

	for (EditCharactersSubscriber mod : mods)
	{
	    mod.receiveEditCharacters();
	}

	logger.info("Done Editting Characters");
    }

    /**
     * Add and Remove Relics.
     */
    @Override
    public void receiveEditRelics()
    {
	logger.info("Begin Editting Relics");

	for (EditRelicsSubscriber mod : mods)
	{
	    mod.receiveEditRelics();
	}

	logger.info("Done Editting Relics");
    }

    /**
     * Called after initialization.
     */
    @Override
    public void receivePostInitialize()
    {
    }

    /**
     * Unlock cards/relics/characters
     */
    @Override
    public void receiveSetUnlocks()
    {
    }

    /**
     * Called before a monster's turn.
     * 
     * @return
     */
    @Override
    public boolean receivePreMonsterTurn(AbstractMonster m)
    {

	for (PreMonsterTurnSubscriber mod : mods)
	{
	    mod.receivePreMonsterTurn(m);
	}

	return false;
    }
}
