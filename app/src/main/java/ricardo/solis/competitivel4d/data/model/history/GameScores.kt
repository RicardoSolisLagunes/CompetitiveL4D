package ricardo.solis.competitivel4d.data.model.history

class GameScores(
    val chapterScores: List<ChapterScore>
) {
    val totalScores: ChapterScore = chapterScores.reduce { acc, chapterScore ->
        ChapterScore(
            acc.myTeam + chapterScore.myTeam,
            acc.enemyTeam + chapterScore.enemyTeam
        )
    }
}

class ChapterScore(val myTeam: Int, val enemyTeam: Int)