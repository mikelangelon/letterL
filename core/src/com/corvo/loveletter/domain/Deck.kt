package com.corvo.loveletter.domain

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Rectangle
import com.corvo.loveletter.App
import java.util.*

class Deck {
    var cards = ArrayList<Card>()
    
    val position = Rectangle(
            App.WIDTH / 2 - App.CARD_WIDTH / 2,
            App.HEIGHT - App.CARD_HEIGHT - 150,
            App.CARD_WIDTH,
            App.CARD_HEIGHT)


    val valueCards = intArrayOf(1, 1, 1, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8)

    fun initDeck(texture: Texture) {
        cards = ArrayList()
        for (i in valueCards) {
            val image = TextureRegion(texture, (i - 1) * 208, 0, 208, 319)
            cards.add(Card(i, image))
        }

        shuffle()
    }

    fun shuffle() {
        Collections.shuffle(cards)
    }

    fun takeCard(): Card {
        val card = cards[0]
        cards.remove(card)
        return card
    }
}