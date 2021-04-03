package com.mansi.gojekassignment

class DataSource {

    fun loadAffirmative(): List<Affirmative>{
        return  listOf(Affirmative(R.string.affirmation1, R.drawable.image1),
        Affirmative(R.string.affirmation2, R.drawable.image2),
        Affirmative(R.string.affirmation3, R.drawable.image3),
        Affirmative(R.string.affirmation4, R.drawable.image4),
        Affirmative(R.string.affirmation5, R.drawable.image5),
        Affirmative(R.string.affirmation6, R.drawable.image6),
        Affirmative(R.string.affirmation7, R.drawable.image7),
        Affirmative(R.string.affirmation8, R.drawable.image8),
        Affirmative(R.string.affirmation9, R.drawable.image9),
        Affirmative(R.string.affirmation10, R.drawable.image10))
    }

}