package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

public class ButtonDownActor extends Actor {

    public Texture downButton;

    public ButtonDownActor() {
        downButton = new Texture(Gdx.files.internal("downButton.png"));
        setHeight(200);
        setWidth(160);
        setX(220);
        setY(80);
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
