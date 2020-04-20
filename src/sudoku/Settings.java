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
    private int masterVolume; // to hold the max volume of all sounds
    private int screenHeight;
    private int screenWidth;
    private String pathIconImage;
    private String pathLogoImage;
    private String pathBackgroundImage;
    private String pathHelpMenuIcon;
    private String pathLeaderboardMenuIcon;
    private String pathStartGameMenuIcon;
    private String pathSaveGameMenuIcon;
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
        this.screenWidth = 750;
        this.screenHeight = 750;
        this.pathIconImage = "icons/icons8-yoda-96.png";
        this.pathLogoImage = "icons/logo.png";
        this.pathBackgroundImage = "backgrounds/galaxy_1.jpg";
        this.pathHelpMenuIcon = "icons/icons8-help.png";
        this.pathLeaderboardMenuIcon = "icons/icons8-leaderboard.png";
        this.pathStartGameMenuIcon = "icons/icons8-play.png";
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
     * to the desired image for the 'Save Game' button icon
     * in the 'game' menu
     *
	 * <hr>
	 * Date created: April 18, 2020
	 */
    public String getPathSaveGameMenuIcon()
    {
        /*
         * return the String attribute which represents the path
         * to the desired image for the 'Save Game' button icon
         * in the 'game' menu
         */
		return this.pathSaveGameMenuIcon;
	} // END: getPathSaveGameMenuIcon() method

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
} // END: Settings() class