package com.github.zxj5470.ktnl.model

/*
 * @date: 2017/11/17
 */
data class KtnlString(private val name:String,
                      private var value:String):KtnlObject(name,value){
    init {
        this.typeName="String"
    }
}