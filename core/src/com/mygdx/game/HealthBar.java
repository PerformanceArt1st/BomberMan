package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class HealthBar extends Actor {

    private Texture healthBarFull;
    private Texture healthBarNormal;
    private Texture healthBarLow;
    private Texture healthBarNull;

    public HealthBar(){
        healthBarFull = new Texture(Gdx.files.internal("healthFull.png"));
        setWidth(180);
        setHeight(180);
        setX(0);
        setY(880);

        healthBarNormal = new Texture(Gdx.files.internal("healthNormal.png"));
        healthBarLow = new Texture(Gdx.files.internal("healthLow.png"));
        healthBarNull = new Texture(Gdx.files.internal("healthNull.png"));
    }


    public void healthBar() {
        if (PlayerActor.healthBar == 3) {
            healthBarFull = healthBarFull;
        }
        if (PlayerActor.healthBar == 2) {
            healthBarFull = healthBarNormal;
        }
        if (PlayerActor.healthBar == 1) {
            healthBarFull = healthBarLow;
        }
        if (PlayerActor.healthBar == 0) {
            healthBarFull = healthBarNull;
        }
    }

    @Override
    public void act(float delta) {
        healthBar();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(healthBarFull, getX(), getY(), getWidth(), getHeight());
    }
}
