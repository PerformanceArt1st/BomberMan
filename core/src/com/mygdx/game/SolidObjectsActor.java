package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import javax.swing.Box;

public class SolidObjectsActor extends Actor {

    private Texture texture;

    private Rectangle boundary;

    public SolidObjectsActor(int startX, int startY){

        texture = new Texture(Gdx.files.internal("stone.jpg"));

        setX(startX);
        setY(startY);
        setHeight(160);
        setWidth(160);

        boundary = new Rectangle(startX, startY, 160, 160);
    }

    public Rectangle getBoundary() {
        return boundary;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());

    }
}
