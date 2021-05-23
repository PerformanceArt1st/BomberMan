package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BombButtonActor extends Actor {

    public Texture downButton;

    public BombButtonActor() {
        downButton = new Texture(Gdx.files.internal("bombButton.png"));
        setHeight(200);
        setWidth(180);
        setX(1400);
        setY(220);
    }

    @Override
    public void act(float delta) {
        toFront();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(downButton, getX(), getY(), getHeight(),getWidth());
    }
}
