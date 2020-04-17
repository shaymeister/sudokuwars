/**
 * ---------------------------------------------------------------------------
 * File name: Settings.java
 * Project name: SudokuWars
 * ---------------------------------------------------------------------------
 * Creator's name and email: Holden Dalton, daltonh@etsu.edu
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Creator's name and email: Hannah Taylor, hannahm1@mail.etsu.edu
 *
 * Course:  CSCI 1260-288
 * Creation Date: April 13, 2020
 * ---------------------------------------------------------------------------
 */

package sudoku;

/**
 * Manage and control all settings within SudokuWars
 *
 * <hr>
 * Date created: April 13, 2020
 * Last modified: April 13, 2020
 * <hr>
 * @author Holden Dalton
 * @author Shay Snyder
 * @author Hannah Taylor
 */
public class Settings
{
    // global variables
    private int masterVolume;
    private int effectsVolume;
    private int melodyVolume;
    private int screenHeight;
    private int screenWidth;
    private String pathIconImage;
    private String pathBackgroundImage;
    private String title;

    /**
	 * initialize the Settings class to the default values
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public Settings()
    {
        // set the initial values for all settings
        this.masterVolume = 100;
        this.effectsVolume = 100;
        this.melodyVolume = 100;
        this.screenWidth = 750;
        this.screenHeight = 750;
        this.pathIconImage = "backgrounds/star_wars_logo.jpg";
        this.pathBackgroundImage = "backgrounds/galaxy_1.jpg";
        this.title = "SudokuWars";
    } // END: Settings() no-arg constructor

    /**
	 * set the 'masterVolume' integer attribute to the
     * argued value; in other words, this changes the
     * max volume of the game's sounds to the argued
     * value
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public void setMasterVolume(int volume)
    {
        /*
         * set the 'masterVolume' integer attribute
         * to the argued value
         */
        this.masterVolume = volume;
    } // END: setMasterVolume() method

    /**
	 * set the 'effectVolume' integer attribute to the
     * argued value; in other words, this changes the
     * volume of the game's effects to the argued
     * value
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public void setEffectsVolume(int volume)
    {
        /*
         * set the 'effectsVolume' integer attribute
         * to the argued value
         */
        this.effectsVolume = volume;
    } // END: setEffectsVolume() method

    /**
	 * set the 'melodyVolume' integer attribute to the
     * argued value; in other words, this changes the
     * volume of the game's melodies to the argued
     * value
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public void setMelodyVolume(int volume)
    {
        /*
         * set the 'melodyVolume' integer attribute
         * to the argued value
         */
        this.melodyVolume = volume;
    } // END: setMelodyVolume() method

    /**
	 * return the integer value that represents the
     * desired volume for the game's effects
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public int getEffectsVolume()
    {
        /*
         * return the integer value that represents the
         * desired volume for the game's effects
         */
        return this.effectsVolume;
    } // END: getEffectsVolume() method

    /**
	 * return the integer value that represents the
     * desired volume for the game's melodies
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public int getMelodyVolume()
    {
        /*
         * return the integer valie that represents the
         * desired volume for the game's melodies
         */
        return this.melodyVolume;
    } // END: getMasterVolume() method

    /**
	 * return the integer value that represents the
     * desired height for the JFrame
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public int getScreenHeight()
    {
        /*
         * return the integer value that represents the
         * desired height for the JFrame
         */
        return this.screenHeight;
    } // END: getScreenHeight() method

    /**
	 * return the integer value that represents the
     * desired width for the JFrame
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public int getScreenWidth()
    {
        /*
         * return the integer value that represents the
         * desired width of the JFrame
         */
        return this.screenWidth;
    } // END: getScreenWidth() method

    /**
	 * return the String attribute which represents the path to the desired
     * image for the icon image
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public String getPathIconImage()
    {
        /*
         * return the String attribute which represents the path to the desired
         * image for the icon image
         */
        return this.pathIconImage;
    } // END: getPathIconImage() method

    /**
	 * return the String attribute which represents the path to the desired
     * image for the SudokuWars background
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public String getPathBackgroundImage()
    {
        /*
         * return the String attribute which represents the path to the desired
         * image for the background
         */
        return this.pathBackgroundImage;
    } // END: getPathBackgroundImage

    /**
	 * return the String attribute which represents the
     * desired title for the SudokuWars JFrame
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public String getTitle()
    {
        /*
         * return the String attribute which represents the
         * desired title for the SudokuWars JFrame
         */
        return this.title;
    } // END: getTitle() method
} // END: Settings() class