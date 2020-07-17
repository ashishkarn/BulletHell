package com.projectiles.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class Launcher {
    private float[] baseVertices=new float[8];
    private float[] barrelVertices=new float[8];
    private Polygon basePolygon;
    private Polygon barrelPolygon;
    private Rectangle barrel_, base_;

    public Launcher(Rectangle base, Rectangle barrel, ShapeRenderer renderer){
        barrel_=barrel;
        base_=base;
        updateBaseVertices(base);
        updateBarrelVertices(barrel);
        basePolygon=new Polygon(baseVertices);
        barrelPolygon=new Polygon(barrelVertices);
        barrelPolygon.setOrigin(barrel.x+barrel.width/2,barrel.y+barrel.height/2);
        System.out.println(basePolygon.getVertices());
        System.out.println(baseVertices);
    }

    public void updateBaseVertices(Rectangle base){
        baseVertices[0]=base.x;
        baseVertices[1]=base.y;

        baseVertices[2]=base.x+base.width;
        baseVertices[3]=base.y;

        baseVertices[4]=base.x+base.width;
        baseVertices[5]=base.y+base.height;

        baseVertices[6]=base.x;
        baseVertices[7]=base.y+base.height;
    }

    public void updateBarrelVertices(Rectangle barrel){
        barrelVertices[0]=barrel.x;
        barrelVertices[1]=barrel.y;

        barrelVertices[2]=barrel.x+barrel.width;
        barrelVertices[3]=barrel.y;

        barrelVertices[4]=barrel.x+barrel.width;
        barrelVertices[5]=barrel.y+barrel.height;

        barrelVertices[6]=barrel.x;
        barrelVertices[7]=barrel.y+barrel.height;
    }

    public void renderBasePolygon(ShapeRenderer renderer){
        //basePolygon.setRotation(basePolygon.getRotation()+1);
        renderer.polygon(basePolygon.getTransformedVertices());
    }

    public void renderBarrelPolygon(ShapeRenderer renderer){
        Vector2 coords=new Vector2();
        coords.x= Gdx.input.getX()-(barrel_.x+barrel_.width/2);
        coords.y=Gdx.input.getY()-(barrel_.y+barrel_.height/2);
        barrelPolygon.setRotation(barrelPolygon.getRotation()+10);
        renderer.polygon(barrelPolygon.getTransformedVertices());
    }
}
