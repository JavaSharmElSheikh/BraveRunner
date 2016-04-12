package com.mygdx.game.stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.character.Character;

public class PlayStage extends Stage{
    Texture bg;
    Character player;

    public PlayStage(GameStageManager gsm){
        super(gsm);
        player = new Character(100,150);
        bg = new Texture("Mario_0.4_map.png");
        cam.setToOrtho(false, 800, 500);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP) ||
                Gdx.input.isKeyPressed(Input.Keys.W)) {
             if (player.getY() <= 100){
                player.jump();
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) ||
                Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.goRight();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) ||
                Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.goLeft();
        }
    }

    @Override
    public void update(float deltaTime) {
        handleInput();
        cam.position.x = player.getPosition().x + 50;
        player.update(deltaTime);
        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, 0, 30);
        sb.draw(player.getTexture(), player.getPosition().x, player.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
