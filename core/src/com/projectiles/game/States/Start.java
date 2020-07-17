package com.projectiles.game.States;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.projectiles.game.GdxGameClass;

public class Start extends State implements Screen {
    private GdxGameClass game;
    private BitmapFont bitmapFont;

    public Start(GdxGameClass game){
        this.game=game;
        bitmapFont=new BitmapFont();
        stateNumber=0;
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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