package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MyGdxGame extends ApplicationAdapter {

    private Stage stage;


    private static final int SCREEN_WIDTH = 1280;
    private static final int SCREEN_HEIGHT = 720;

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    @Override
    public void create() {

        BackgroundActor backgroundActor = new BackgroundActor();
        final PlayerActor playerActor = new PlayerActor();
        EnemyActor enemyActor = new EnemyActor();
        HealthBar healthBar = new HealthBar();

        ButtonUpActor buttonUpActor = new ButtonUpActor();
        ButtonDownActor buttonDownActor = new ButtonDownActor();
        ButtonRightActor buttonRightActor = new ButtonRightActor();
        ButtonLeftActor buttonLeftActor = new ButtonLeftActor();

        BombButtonActor bombButtonActor = new BombButtonActor();


        stage = new Stage();
        stage.addActor(backgroundActor);

        for (int i = 0; i < 16; i++) {
            SolidObjectsActor solidObjectsActor1 = new SolidObjectsActor(i * 160, 0);
            stage.addActor(playerActor);
            stage.addActor(solidObjectsActor1);
        }

        for (int i = 0; i < 9; i++) {
            SolidObjectsActor solidObjectsActor1 = new SolidObjectsActor(0, i * 160);
            stage.addActor(solidObjectsActor1);
        }

        for (int i = 0; i < 16; i++) {
            SolidObjectsActor solidObjectsActor1 = new SolidObjectsActor(i * 160, 960);
            stage.addActor(solidObjectsActor1);
        }

        for (int i = 0; i < 9; i++) {
            SolidObjectsActor solidObjectsActor1 = new SolidObjectsActor(1760, i * 160);
            stage.addActor(solidObjectsActor1);
        }

        stage.addActor(enemyActor);
        stage.addActor(healthBar);

        buttonDownActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                playerActor.moveDown();
            }
        });

        buttonUpActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                playerActor.moveUp();
            }
        });

        buttonRightActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                playerActor.moveRight();
            }
        });

        buttonLeftActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                playerActor.moveLeft();
            }
        });

        bombButtonActor.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                playerActor.summonBomb(Gdx.graphics.getDeltaTime());
            }
        });

        stage.addActor(buttonDownActor);
        stage.addActor(buttonUpActor);
        stage.addActor(buttonLeftActor);
        stage.addActor(buttonRightActor);

        stage.addActor(bombButtonActor);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render() {
        stage.act();
        stage.draw();
    }

    @Override
    public void dispose() {
    }
}
