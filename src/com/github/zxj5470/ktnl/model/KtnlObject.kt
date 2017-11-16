package com.github.zxj5470.ktnl.model

/*
 * @date: 2017/11/17
 */
open class KtnlObject(private var name: String,
                      private var value: Any) {
    lateinit var typeName:String
    override fun toString(): String =
        when (typeName) {
            "String" -> " $typeName = \"$value\""
            else -> " $typeName = $value"
        }
}