/**
 * ---------------------------------------------------------------------------
 * File name: Settings.java
 * Project name: SudokuWars
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
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
 * @author Shay Snyder
 */
public class Settings
{
    // global variables
    private int masterVolume; // max volume of all sounds
    private int screenHeight; // height of the frame in pixels
    private int screenWidth; // width of the frame in pixels
    private String pathIconImage; // path to icon image
    private String pathLogoImage; // path to logo image
    private String pathBackgroundImage; // path to background image
    private String pathHelpMenuIcon; // path to help menu icon
    private String pathLeaderboardMenuIcon; // path to leaderboard menu icon
    private String pathStartGameMenuIcon; // path to start game menu icon
    private String pathGridElementDir; // path to the grid element icon directory
    private String title; // the game's title

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
        this.screenWidth = 750;
        this.screenHeight = 750;
        this.pathIconImage = "icons/icons8-yoda-96.png";
        this.pathLogoImage = "icons/logo.png";
        this.pathBackgroundImage = "backgrounds/galaxy_1.jpg";
        this.pathHelpMenuIcon = "icons/icons8-help.png";
        this.pathLeaderboardMenuIcon = "icons/icons8-leaderboard.png";
        this.pathStartGameMenuIcon = "icons/icons8-play.png";
        this.pathGridElementDir = "icons/";
        this.title = "SudokuWars";
    } // END: Settings() no-arg constructor



    /**
	 * return the integer value that represents the
     * desired volume for the game's sounds
     *
	 * <hr>
	 * Date created: April 13, 2020
	 */
    public int getEffectsVolume()
    {
        /*
         * return the integer value that represents the
         * desired volume for the game's sounds
         */
        return this.masterVolume;
    } // END: getEffectsVolume() method


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
	 * return the String attribute which represents the path to the game's
     * logo
     *
	 * <hr>
	 * Date created: April 19, 2020
	 */
    public String getPathLogoImage()
    {
        /*
         * return the String attribute which represents the path to the
         * game's logo
         */
        return this.pathLogoImage;
    } // END: getPathLogoImage() method

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

    /**
	 * return the String attribute which represents the path
     * to the desired image for the 'Start Game' button icon in
     * the 'game' menu
     *
	 * <hr>
	 * Date created: April 18, 2020
	 */
    public String getPathNewGameMenuIcon()
    {
        /*
         * return the String attribute which represents the path
         * to the desired image for the 'Start Game' button icon
         * in the 'game' menu
         */
		return this.pathStartGameMenuIcon;
	} // END: getPathNewGameMenuIcon() method

    /**
	 * return the String attribute which represents the path
     * to the desired image for the 'Leaderboard' button icon
     * in the 'game' menu
     *
	 * <hr>
     * Date created: April 19, 2020
	 */
    public String getPathLeaderboardMenuIcon() 
    {
        /*
         * return the String attribute which represents the path to the
         * desired image for the 'Leaderboard' button icon in the 'game'
         * menu
         */
        return this.pathLeaderboardMenuIcon;
	} // END: getPathLeaderboardMenuIcon() method

    /**
	 * return the String attribute which represents the path
     * to the desired image for the 'Help' button icon in
     * the 'game' menu
     *
	 * <hr>
     * Date created: April 19, 2020
	 */
    public String getPathHelpMenuIcon()
    {
        /*
         * return the String attribute which represents the path
         * to the desired image for the 'Help' button in the
         * 'game' menu
         */
		return this.pathHelpMenuIcon;
	} // END: getPathHelpMenuIcon()


    /**
	 * return the path to the appropriate image for 
     * the grid element icon
     *
	 * <hr>
     * Date created: April 22, 2020
	 */
    public String getPathGridElementIcon(char value) 
    {
        // return the appropriate path
		return this.pathGridElementDir + value + ".png";
	} // END: getPathGridElementIcon() method
} // END: Settings() class