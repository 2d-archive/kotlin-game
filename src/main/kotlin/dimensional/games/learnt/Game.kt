package dimensional.games.learnt

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import ktx.app.KtxApplicationAdapter
import ktx.app.clearScreen
import ktx.graphics.use

class Game : KtxApplicationAdapter {
  private lateinit var shapeRenderer: ShapeRenderer
  private lateinit var bitmapFont: BitmapFont

  var posX = WIDTH / 2 - 30f
  var speedX = 10

  var posY = HEIGHT / 2 - 30f
  var speedY = 10

  override fun create() {
    shapeRenderer = ShapeRenderer()
    bitmapFont = BitmapFont()
  }

  override fun render() {
    clearScreen(0f, 0f, 0f, 0f)

    val deltaTime = Gdx.graphics.deltaTime

    /* horizontal */
    if (Gdx.input.isKeyPressed(Input.Keys.A)) {
      posX -= 5
    }

    if (Gdx.input.isKeyPressed(Input.Keys.D)) {
      posX += 5
    }

    /* vertical */
    if (Gdx.input.isKeyPressed(Input.Keys.W)) {
      posY += 5
    }

    if (Gdx.input.isKeyPressed(Input.Keys.S)) {
      posY -= 5
    }

    shapeRenderer.use(ShapeRenderer.ShapeType.Filled) {
      shapeRenderer.color = Color.BLUE
      shapeRenderer.rect(posX, posY, 60f, 60f)
    }


  }

  companion object {
    const val WIDTH = 1280f
    const val HEIGHT = 720f
  }
}

fun main(args: Array<out String>) {

  val config = LwjglApplicationConfiguration().apply {
    title = "poop"
    height = Game.HEIGHT.toInt()
    width = Game.WIDTH.toInt()
  }

  LwjglApplication(Game(), config)

}
