package com.github.zxj5470.ktnl.model



data class KtnlNumber(
        var name: String,
        var value: Number):KtnlObject(name,value){

    init {
        this.typeName="Number"
    }
}