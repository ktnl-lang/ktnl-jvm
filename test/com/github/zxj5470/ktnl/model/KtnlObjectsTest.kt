package com.github.zxj5470.ktnl.model

/*
 * @date: 2017/11/17
 */
fun main(args: Array<String>) {
    val s=KtnlString("Boy","2333")
    println(s)
    println(s.name)
    println(s.value)
    println(s.typeName)

    val kf=KtnlFunction("f", emptyList())

}