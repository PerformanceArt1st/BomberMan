package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ButtonRightActor extends Actor {

    public Texture rightButton;

    public ButtonRightActor() {
        rightButton = new Texture(Gdx.files.internal("rightButton.png"));
        setHeight(160);
        setWidth(160);
        setX(400);
        setY(240);
    }

    @Override
    public void act(float delta) {
        toFront();
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(rightButton, getX(), getY(), getHeight(),getWidth());
    }
}
