package helpers;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * Necessary informations about the game.
 * @author Mehmet Hasat Serinkan, Mehmet Eren Balasar
 * @date 06.12.2021
 */
public class GameInfo {

    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    public static final int PPM = 100;
    
    public static final float PLAYER_MOVESPEED = 2.3f;
    public static final float PLAYER_HEIGHT= 55f;
    public static final float PLAYER_WIDTH = 72f;
    public static final float BULLET_SPEED = 30;

    public static final float GUARDIAN_MOVESPEED = 1.3f;
    public static final float GUARDIAN_HEIGHT= 55f;
    public static final float GUARDIAN_WIDTH = 72f;
    
    public static final float CRAZY_MOVESPEED = 2f;
    public static final float CRAZY_HEIGHT= 55f;
    public static final float CRAZY_WIDTH = 45f;

    public static final short CHARACTER = 2;
    public static final short PLAYER = 2;
    public static final short ENEMY = 3;
    public static final short BULLET = 4;
    public static final short OBSTACLE = 5;

    public static float GUNSHOT_VOLUME = 0.7f;
    public static float FOOTSTEP_VOLUME = 0.5f;

    public static int CHARACTER_HEALTH = 3;
    public static int PLAYER_HEALTH = 5;

    public static int DIFFICULT_TICK = 2;
    public static int VOLUME_TICK= 2;
    public static int FULLSCREEN_TICK = 2;

}
