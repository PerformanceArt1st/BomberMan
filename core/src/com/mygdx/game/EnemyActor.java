package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

public class EnemyActor extends Actor {

    private Texture texture;
    private static Rectangle boundary;

    private int enemySpeed = 160;

    float timer;


    public EnemyActor() {
        texture = new Texture(Gdx.files.internal("techies1.gif"));
        setX(1600);
        setY(800);
        setWidth(160);
        setHeight(160);


        boundary = new Rectangle(getX(), getY(), 160, 160);
    }

    public static Rectangle getBoundary() {
        return boundary;
    }


    @Override
    public void act(float delta) {

        Stage stage = getStage();
        Array<Actor> actors = stage.getActors();

        for (Actor actor : actors) {
            if (actor instanceof PlayerActor) {
                if ((boundary.overlaps(PlayerActor.getBoundary()) && PlayerActor.invulnerability <= 0)) {
                    PlayerActor.healthBar = PlayerActor.healthBar - 1;
                    PlayerActor.invulnerability = 2;
                }
            }
        }

        timer = timer + delta;
        if (timer < 0.4) {
            return;
        }

        boundary.setPosition(getX(), getY());

        float x = getX();
        float y = getY();

        for (Actor actor : actors) {
            if (actor instanceof PlayerActor) {
                PlayerActor playerActor = (PlayerActor) actor;
                float playerX = playerActor.getX();
                float playerY = playerActor.getY();
                if (getY() < playerY) {
                    setY(y + enemySpeed);
                } else if (getY() > playerY) {
                    setY(y - enemySpeed);
                } else if (getX() < playerX) {
                    setX(x + enemySpeed);
                } else if (getX() > playerX) {
                    setX(x - enemySpeed);
                }
            }
        }
        timer = 0;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }
}
