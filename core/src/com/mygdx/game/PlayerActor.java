package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;

import java.awt.Button;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class PlayerActor extends Actor {

    public Texture texture;

    public int startX;
    public int startY;

    private Texture bombTexture;
    private Texture boomExplosion;


    private static Rectangle boundary;

    private int playerSpeed = 160;

    public static int healthBar = 3;

    static float invulnerability = 0;

    static float bombCount = 3;

    public PlayerActor() {

        texture = new Texture(Gdx.files.internal("techies.png"));


        setX(160);
        setY(160);
        setWidth(160);
        setHeight(160);

        boundary = new Rectangle(getX(), getY(), 160, 160);

        bombTexture = new Texture(Gdx.files.internal("bomb.png"));
        boomExplosion = new Texture(Gdx.files.internal("boomExplosion.png"));


    }

    public static Rectangle getBoundary() {
        return boundary;
    }

    public void moveDown() {
        float y = getY();
        if (getY() > 160) {
//            boundary.setPosition(getX(), getY() - 160);
//            if (!isOverlapSolid(boundary)) {
            setY(y - playerSpeed);
//            }
//            boundary.setPosition(getX(), getY());
        }
    }

    public void moveUp() {
        float y = getY();
        if (getY() < 800) {
//            boundary.setPosition(getX(), getY() + 160);
//            if (!isOverlapSolid(boundary)) {
            setY(y + playerSpeed);
        }
//            boundary.setPosition(getX(), getY());
    }

    public void moveRight() {
        float x = getX();
        if (getX() < 1600) {
//            boundary.setPosition(getX() + 160, getY());
//            if (!isOverlapSolid(boundary)) {
            setX(x + playerSpeed);
        }
//            boundary.setPosition(getX(), getY());
    }

    public void moveLeft() {
        float x = getX();
        if (getX() > 160) {
//            boundary.setPosition(getX() - 160, getY());
//            if (!isOverlapSolid(boundary)) {
        setX(x - playerSpeed);
            }
//            boundary.setPosition(getX(), getY());
    }

//    public void techiesMove() {
//
//        float x = getX();
//        float y = getY();
//
//
//        if (Gdx.input.isKeyJustPressed(Input.Keys.UP) && getY() < 800) {
//            boundary.setPosition(getX(), getY() + 160);
//            if (!isOverlapSolid(boundary)) {
//                setY(y + playerSpeed);
//            }
//            boundary.setPosition(getX(), getY());
//
//        } else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN) && getY() > 160) {
//            boundary.setPosition(getX(), getY() - 160);
//            if (!isOverlapSolid(boundary)) {
//                setY(y - playerSpeed);
//            }
//            boundary.setPosition(getX(), getY());
//
//        } else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT) && getX() < 1600) {
//            boundary.setPosition(getX() + 160, getY());
//            if (!isOverlapSolid(boundary)) {
//                setX(x + playerSpeed);
//            }
//            boundary.setPosition(getX(), getY());
//
//        } else if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT) && getX() > 160) {
//            boundary.setPosition(getX() - 160, getY());
//            if (!isOverlapSolid(boundary)) {
//                setX(x - playerSpeed);
//            }
//            boundary.setPosition(getX(), getY());
//        }
//
//    }

    private boolean isOverlapSolid(Rectangle boundary) {
        Stage stage = getStage();
        Array<Actor> actors = stage.getActors();
        for (Actor actor : actors) {
            if (actor instanceof SolidObjectsActor) {
                SolidObjectsActor solidActor = (SolidObjectsActor) actor;
                return solidActor.getBoundary().overlaps(boundary);
            }
        }
        return false;
    }

    public void health() {
        Stage stage = getStage();
        Array<Actor> actors = stage.getActors();
        for (Actor actor : actors) {
            if (actor instanceof PlayerActor) {
                PlayerActor playerActor = (PlayerActor) actor;
                if (healthBar == 0) {
                    playerActor.remove();
                }
            }
        }
    }


    public void summonBomb(float delta) {
        bombCount++;
        if (bombCount >= 3) {
            Stage stage = getStage();
            if (stage != null) {
                BombActor bombActor = new BombActor(getX(), getY(), bombTexture, boomExplosion);
                stage.addActor(bombActor);
                toFront();
                bombCount = 0;
            }
        }
    }

    public void boundarySetPosition() {
        boundary.setPosition(getX(), getY());
    }

    public void invulnerability(float delta) {
        invulnerability = invulnerability - delta;
    }

    @Override
    public void act(float delta) {
        invulnerability(delta);
        health();
        boundarySetPosition();
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

}
