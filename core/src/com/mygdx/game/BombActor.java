package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

public class BombActor extends Actor {

    private Rectangle boundary;
    private boolean blownUp = false;
    private Texture bombTexture;
    private Texture boomExplosion;

    int counter = 0;

    float timer = 0;

    public BombActor(float startX, float startY, Texture texture1, Texture texture2) {
        boundary = new Rectangle(getX(), getY(), 160, 160);
        setX(startX);
        setY(startY);

        bombTexture = texture1;
        boomExplosion = texture2;

        setWidth(160);
        setHeight(160);
    }

    public void bombExplosion(float delta) {


        timer = timer + delta;

        if (timer > 3) {
            blownUp = true;
            bombTexture = boomExplosion;

            setWidth(480);
            setHeight(480);

            if (counter == 0){
                counter = 1;
                setX(getX() - 160);
                setY(getY() - 160);
            }

            boundary.setPosition(getX(), getY());
            boundary.setWidth(480);
            boundary.setHeight(480);
        }

        Stage stage = getStage();
        Array<Actor> actors = stage.getActors();
        for (Actor actor : actors) {
            if (actor instanceof PlayerActor) {
                if ((boundary.overlaps(PlayerActor.getBoundary())) && (blownUp) && PlayerActor.invulnerability <= 0) {
                    PlayerActor.healthBar = PlayerActor.healthBar - 1;
                    PlayerActor.invulnerability = 3;
                }
            }

        }
        for (Actor actor : actors) {
            if (actor instanceof EnemyActor) {
                EnemyActor enemyActor = (EnemyActor) actor;
                if ((boundary.overlaps(EnemyActor.getBoundary())) && (blownUp)) {
                    enemyActor.remove();
                }
            }
        }


        if (timer > 3.5) {
            remove();
        }
    }

    @Override
    public void act(float delta) { // 1 / 60 - Значение Delta
        bombExplosion(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(bombTexture, getX(), getY(), getWidth(), getHeight());
    }
}
