package com.corvo.loveletter

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.corvo.loveletter.domain.Assets


class App : Game() {

    companion object {
        const val WIDTH = 320f
        const val HEIGHT = 480f
        const val CARD_WIDTH = 80f
        const val CARD_HEIGHT = 128f
    }

    lateinit var batch: SpriteBatch
    lateinit var shapeRenderer : ShapeRenderer
    lateinit var assets: Assets

    override fun create() {
        batch = SpriteBatch()
        shapeRenderer = ShapeRenderer()
        assets = Assets()

        setScreen(MenuScreen(this))
    }

}