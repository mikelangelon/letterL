package com.corvo.loveletter

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer


class App : Game() {

    lateinit var batch: SpriteBatch
    lateinit var shapeRenderer : ShapeRenderer

    override fun create() {
        batch = SpriteBatch()
        shapeRenderer = ShapeRenderer()

        setScreen(MenuScreen(this))
    }

}