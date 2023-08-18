package ricardo.solis.competitivel4d.data.model.history

open class GameResult(val mmr: Int) {
    class Win(mmr: Int) : GameResult(mmr)
    class Loss(mmr: Int) : GameResult(mmr)
    class Tie(mmr: Int) : GameResult(mmr)
}