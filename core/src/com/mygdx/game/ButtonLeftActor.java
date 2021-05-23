package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ButtonLeftActor extends Actor {

    public Texture leftButton;

    public ButtonLeftActor() {
        leftButton = new Texture(Gdx.files.internal("leftButton.png"));
        setHeight(160);
        setWidth(160);
        setX(80);
        setY(240);
    }

    @Override
    public void act(float delta) {
        toFront();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(leftButton, getX(), getY(), getHeight(),getWidth());
    }
}
