package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ButtonUpActor extends Actor {

    public Texture upButton;

    public ButtonUpActor() {
        upButton = new Texture(Gdx.files.internal("upButton.png"));
        setHeight(200);
        setWidth(160);
        setX(220);
        setY(400);
    }

    @Override
    public void act(float delta) {
        toFront();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(upButton, getX(), getY(), getHeight(),getWidth());
    }
}
