package com.projectiles.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.projectiles.game.GdxGameClass;

public class ExitScreen extends State implements Screen {
    private GdxGameClass game;
    private OrthographicCamera camera;
    BitmapFont exitText;
    private Stage stage;

    public ExitScreen(GdxGameClass game, OrthographicCamera camera){
        this.game=game;
        this.camera=camera;
        stateNumber=5;


        exitText=new BitmapFont();
        stage=new Stage();
        Gdx.input.setInputProcessor(stage);

        Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        Button button2 = new TextButton("Restart",mySkin,"small");
        button2.setSize(120,60);
        button2.setPosition(370,120);
        button2.addListener(new Input());

        Button button1 = new TextButton("Exit",mySkin,"small");
        button1.setSize(120,60);
        button1.setPosition(370,40);
        button1.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.exit();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {

                return true;
            }
        });
        stage.addActor(button2);
        stage.addActor(button1);
    }

    class Input extends InputListener{
        @Override
        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
            game.changeToNewG();
        }
        @Override
        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
            return true;
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        exitText.draw(game.batch,"Game Over\n You Survived for:"+game.g.deltaIntegral+" Seconds", 370,245);
        game.batch.end();
        stage.act();
        stage.draw();
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