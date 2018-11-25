package com.corvo.loveletter

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.corvo.loveletter.domain.Deck

class GameScreen(app: App) : ScreenAdapter(){
    val app = app
    val camera = OrthographicCamera(App.WIDTH, App.HEIGHT)
    val deck = Deck()

    override fun render(delta: Float) {
        val gl = Gdx.gl
        gl.glClearColor(1f, 0f, 0f, 1f)
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        camera.update()
        app.batch.projectionMatrix = camera.combined

        app.batch.begin()
        app.batch.draw(app.assets.background, 0f, 0f, App.WIDTH, App.HEIGHT)
        app.batch.end()

        app.batch.begin()
        app.batch.draw(app.assets.cardBack, deck.position.x, deck.position.y, deck.position.width, deck.position.height)
        app.batch.end()
    }
}