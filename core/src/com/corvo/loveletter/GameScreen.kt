package com.corvo.loveletter

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer

class GameScreen(app: App) : ScreenAdapter(){
    val app = app
    val camera = OrthographicCamera(320f, 480f)

    override fun render(delta: Float) {
        val gl = Gdx.gl
        gl.glClearColor(1f, 0f, 0f, 1f)
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        camera.update()
        app.batch.projectionMatrix = camera.combined

        app.batch.enableBlending()
        app.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        app.shapeRenderer.setColor(Color.YELLOW);
        app.shapeRenderer.rect(320 / 2f, 480 / 2f, 100f, 100f);
        app.shapeRenderer.end();
    }
}