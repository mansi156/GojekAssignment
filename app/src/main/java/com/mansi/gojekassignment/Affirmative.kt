package com.mansi.gojekassignment

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmative(
    @StringRes val stringResourceId : Int,
    @DrawableRes val imageResourceId : Int
)