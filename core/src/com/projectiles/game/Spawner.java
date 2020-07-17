package com.projectiles.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

public class Spawner {
    public Rectangle bounds;
    private Array<Bullet> bullets;
    Vector2 defaultLaunchingPos;
    float minAngle;
    float maxAngle;
    Vector2 pos;
    private GdxGameClass game;

    public Spawner(GdxGameClass game, float minAngle, float maxAngle, Rectangle bounds, int corner){
        this.game=game;
        this.minAngle=minAngle;
        this.maxAngle=maxAngle;

        bullets=new Array<Bullet>();
       this.bounds=bounds;

        switch(corner){
            case 0:
                pos=new Vector2(bounds.x,bounds.y+bounds.height);
                break;
            case 1:
                pos=new Vector2(bounds.x+bounds.width, bounds.y+bounds.height);
                break;
            case 2:
                pos=new Vector2(bounds.x, bounds.y);
                break;
            case 3:
                pos=new Vector2(bounds.x+bounds.width, bounds.y);
                break;
        }
        defaultLaunchingPos=pos.sub(bounds.getCenter(new Vector2())).nor();
        //defaultLaunchingPos.setAngle(90);
        System.out.println(defaultLaunchingPos.angle());
    }

    public void spawn(int angle, int minDisplacement){
        defaultLaunchingPos.setAngle(defaultLaunchingPos.angle()+angle);

        //System.out.println(defaultLaunchingPos.angle());
        Random rand = new Random();
        int rand_int = rand.nextInt(5);

        bullets.add(new Bullet(game, new Circle(bounds.getCenter(new Vector2()).x, bounds.getCenter(new Vector2()).y, 5), defaultLaunchingPos, rand_int+minDisplacement));
    }

    public void update(ShapeRenderer shapeRenderer, Rectangle boundingBox, Rectangle player){
        //shapeRenderer.rect(bounds.x, bounds.y, bounds.getWidth(),bounds.getHeight());
        if(!bullets.isEmpty()) {
            for (int i=0; i<bullets.size;i++) {
                Bullet b=bullets.get(i);
                b.simulate(shapeRenderer,boundingBox, player);
                if(b.delete){
                    bullets.removeIndex(i);
                    System.out.println("Del");
                }
            }
        }
    }
}
