package levels;

import characters.*;
import characters.Character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.cscats.madend.GameMain;
import helpers.GameInfo;
import viewers.CharacterView;
import viewers.PlayerView;


/**
 * Level1 class
 * @author Mehmet Hasat Serinkan, Mehmet Eren Balasar
 * @date 07.12.2021
 */
public class Level1 implements Screen {

    //Properties
    private GameMain game;
    private Texture bg;
    private Character player;
    private CharacterView characterView;
    private PlayerView playerView;
    private World world;
    private OrthographicCamera mainCamera;
    private Viewport gameViewport;
    private Vector3 vector3;

    public Level1( GameMain game ) {


        this.game = game;
        bg = new Texture( "Level Backgrounds/Level 1 Background.png" );
        
        world = new World( new Vector2(0 , 0), true );
        
        player = new Player(world, GameInfo.WIDTH / 2f, GameInfo.HEIGHT / 2f);
        playerView = new PlayerView( "Player/Player.png", (Player) player);
        
        mainCamera = new OrthographicCamera( GameInfo.WIDTH / 1.3f , GameInfo.HEIGHT / 1.3f );
        gameViewport = new StretchViewport( GameInfo.WIDTH, GameInfo.HEIGHT, mainCamera);
        vector3 = new Vector3( 0, 0, 0);
    }


    public void update( float dt ) {
    	
        ((Player)player).handleMoveInput( dt );
        ((Player)player).handleMouseInput( dt, vector3.x, vector3.y);
        player.updateCharacter();
        moveCamera();
        mainCamera.update();
    }

    public void moveCamera() {
        mainCamera.position.x = player.getXPosition();
        mainCamera.position.y = player.getYPosition();
        
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        update( delta );

        Gdx.gl.glClearColor( 1, 0, 0, 1 );
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getBatch().begin(); //Begin for drawing

        game.getBatch().draw( bg, 0, 0);
        
        playerView.drawPlayer( game.getBatch() );
        playerView.drawPlayerAnimation(game.getBatch());

        game.getBatch().end(); //End for drawing

        game.getBatch().setProjectionMatrix( mainCamera.combined );

        vector3.set(Gdx.input.getX(), Gdx.input.getY(), 0f);
        mainCamera.unproject(vector3);

        world.step( delta, 6 ,2 );
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        bg.dispose();

    }
}
