package com.corvo.loveletter.domain

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion

class Assets {
    val cards: Texture
    val cardBack: TextureRegion
    var background: TextureRegion

    init {
        cards = loadTexture("data/cards.png")
        cardBack = TextureRegion(cards, 208, 319 * 4, 208, 319);
        background = TextureRegion(loadTexture("data/background.png"), 0, 0, 320, 480)
    }

    private fun loadTexture(file: String): Texture {
        return Texture(Gdx.files.internal(file))
    }
}