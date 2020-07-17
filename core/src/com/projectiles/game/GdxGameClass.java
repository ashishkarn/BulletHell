/*This package will handle all the Scenes and rendering logic*/
package com.projectiles.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.projectiles.game.States.*;


public class GdxGameClass extends Game {
	public SpriteBatch batch;

	public FSM fsm;

	public ExitScreen exit;
	public GameScreen g;

	public OrthographicCamera camera;


	@Override
	public void create() {
		batch=new SpriteBatch();
		fsm=new FSM();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);

		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);

		g=new GameScreen(this, camera);
		exit=new ExitScreen(this, camera);

		this.setScreen(g);
	}

	public void changeToNewG(){
		g=new GameScreen(this, camera);
		setScreen(g);
	}
	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

}
