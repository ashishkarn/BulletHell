package com.projectiles.game.States;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.projectiles.game.Bullet;
import com.projectiles.game.GdxGameClass;
import com.projectiles.game.Spawner;

import java.util.Random;


public class GameScreen extends State implements Screen {
    private GdxGameClass game;

    private Rectangle player;
    private Music track;

    private Spawner spawner;
    private Spawner spawner2;
    private Spawner spawner3;
    private Spawner spawner4;
    private Spawner spawner5;
    public float deltaIntegral=0;

    OrthographicCamera camera;
    ShapeRenderer shapeRenderer;
    SpriteBatch batch;
    Sprite bg, ship1, ship2, ship3, ship4, ship5, userShip;

    Rectangle boundingBoxWhole=new Rectangle(0,0,800,480);

    public Music music;

    float spawnTime=0;
    int playerDelta=4;

    public GameScreen(GdxGameClass game, OrthographicCamera camera){
        this.game=game;
        stateNumber=4;
        Random rand = new Random();
        int rand_int = rand.nextInt(6);
        music = Gdx.audio.newMusic(Gdx.files.internal((rand_int+1)+".mp3"));
        music.setLooping(true);
        music.play();

        player=new Rectangle(boundingBoxWhole.getCenter(new Vector2()).x-50, boundingBoxWhole.getCenter(new Vector2()).y-100,30,30);

        this.camera = camera;

        shapeRenderer=new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

        spawner=new Spawner(game,0,90,new Rectangle(boundingBoxWhole.getCenter(new Vector2()).x-40, boundingBoxWhole.getCenter(new Vector2()).y-40,40,40),1);
        spawner2=new Spawner(game,0,90,new Rectangle(10,10,80,80),1);
        spawner3=new Spawner(game,0,90,new Rectangle(680,10,80,80),0);
        spawner4=new Spawner(game,0,90,new Rectangle(10,400,80,80),3);
        spawner5=new Spawner(game,0,90,new Rectangle(680,400,80,80),2);

        batch=new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);

        bg=new Sprite(new Texture("bg.jpg"));
        ship1=new Sprite(new Texture("ship1.png"));
        ship2=new Sprite(new Texture("ship2.png"));
        ship3=new Sprite(new Texture("ship3.png"));
        ship4=new Sprite(new Texture("ship4.png"));
        ship5=new Sprite(new Texture("ship5.png"));

        ship1.setBounds(360, 200,40,40);
        ship2.setBounds(10,10,80,80);
        ship3.setBounds(680,10,80,80);
        ship4.setBounds(10,400,80,80);
        ship5.setBounds(680,400,80,80);
        userShip=new Sprite(new Texture("userShip.png"));

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        if(Gdx.input.isKeyPressed(Input.Keys.W) ||Gdx.input.isKeyPressed(Input.Keys.UP)){
            player.y=player.y+playerDelta;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)||Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            player.x=player.x-playerDelta;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)||Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            player.y=player.y-playerDelta;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)|| Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            player.x=player.x+playerDelta;
        }
        /*
        if(Gdx.input.isTouched()){
            Random rand = new Random();
            int rand_int1 = rand.nextInt(3);
            Vector2 pos=new Vector2(Gdx.input.getX(), 480-Gdx.input.getY());
            playerShootingVec=pos.sub(player.getCenter(new Vector2())).nor();
            bullets.add(new Bullet(new Circle(player.getCenter(new Vector2()).x, player.getCenter(new Vector2()).y, 10), playerShootingVec, rand_int1+1));
        }*/

        deltaIntegral=deltaIntegral+delta;
        spawnTime=spawnTime+delta;
        if(spawnTime>0.3){
            spawnTime=0;
            spawner.spawn(10,3);
            spawner2.spawn(-10,2);
            spawner3.spawn(20,1);
            spawner4.spawn(-20,1);
            spawner5.spawn(30,5);
        }
        userShip.setBounds(player.x, player.y, player.getWidth(), player.height);
        batch.begin();
        bg.draw(batch);
        ship1.draw(batch);
        ship2.draw(batch);
        ship3.draw(batch);
        ship4.draw(batch);
        ship5.draw(batch);
        userShip.draw(batch);
        batch.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.GREEN);
        //shapeRenderer.rect(player.x, player.y, player.getWidth(),player.getHeight());
        spawner.update(shapeRenderer, boundingBoxWhole, player);
        spawner2.update(shapeRenderer, boundingBoxWhole, player);
        spawner3.update(shapeRenderer, boundingBoxWhole, player);
        spawner4.update(shapeRenderer, boundingBoxWhole, player);
        spawner5.update(shapeRenderer, boundingBoxWhole, player);
        shapeRenderer.end();
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

    }
}