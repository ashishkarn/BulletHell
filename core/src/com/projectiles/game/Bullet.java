package com.projectiles.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bullet {
    private Circle circle;
    Vector2 normal;
    int displacement;
    public boolean delete=false;
    public boolean playerShot=false;
    private GdxGameClass game;


    public Bullet(GdxGameClass game, Circle circle, Vector2 _normal, int _displacement){
        this.game=game;
        this.circle=circle;
        normal=new Vector2(_normal.x, _normal.y);
        displacement=_displacement;
    }

    public void update(){
        circle.x=circle.x+normal.x*displacement;
        circle.y=circle.y+normal.y*displacement;
    }

    public void simulate(ShapeRenderer renderer, Rectangle boundingBox, Rectangle player){
        update();

        if(!boundingBox.contains(circle)){
            delete=true;
        }
        if(Intersector.overlaps(circle, player)){
            playerShot=true;
            game.g.music.stop();
            game.setScreen(game.exit);
        }

        renderer.circle(circle.x, circle.y, circle.radius);
    }
}


/*
         if(Intersector.overlaps(circle,boundingBox)){
             angleOfincidence=normal.dot(new Vector2(0,1).nor());
             changeAngle=true;
         }else if(Intersector.overlaps(circle,boundingBox1)){
             System.out.println(1);
             angleOfincidence=normal.dot(new Vector2(1,0).nor());
         }else if(Intersector.overlaps(circle,boundingBox2)){
             angleOfincidence=normal.dot(new Vector2(0,-1).nor());
         }else if(Intersector.overlaps(circle,boundingBox3)){
             angleOfincidence=normal.dot(new Vector2(-1,0).nor());
         }

         if(changeAngle){
             changeAngle=false;
             normal.setAngle(angleOfincidence);
         }
*/