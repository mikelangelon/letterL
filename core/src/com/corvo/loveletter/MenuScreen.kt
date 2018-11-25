package com.corvo.loveletter

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector3

class MenuScreen(app: App) : ScreenAdapter() {
    val app = app

    val camera = OrthographicCamera(320f, 480f)
    val font = BitmapFont()
    var touchPoint = Vector3();
    val startLabel = Rectangle(320 / 2f, 480 / 2f-100, 100f, 100f)

    init {
        font.data.setScale(2f)
        camera.position.set(320 / 2f, 480 / 2f, 0f)
    }

    override fun render(delta: Float) {
        update()
        draw()
    }

    fun update() {
        if (Gdx.input.justTouched()) {
            camera.unproject(touchPoint.set(Gdx.input.x.toFloat(), Gdx.input.y.toFloat(), 0f))

            // TODO: Something is wrong with the coordenates. The ShapeRender and the Batch have a different set of coordinates.
            //       And the startLabel is different than expected.

            if (startLabel.contains(touchPoint.x, touchPoint.y)) {
                app.screen = GameScreen(app)
                return
            }
        }
    }

    fun draw() {
        val gl = Gdx.gl
        gl.glClearColor(1f, 0f, 0f, 1f)
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        camera.update()
        app.batch.projectionMatrix = camera.combined


        app.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        app.shapeRenderer.setColor(Color.BLUE);
        app.shapeRenderer.rect(320 / 2f, 480 / 2f, 100f, 100f);
        app.shapeRenderer.end();

        app.batch.enableBlending()
        app.batch.begin()
        font.draw(app.batch, "Start", 320 / 2f, 480 / 2f);
        app.batch.end()
    }
}