package com.github.zxj5470.ktnl.util

import com.github.zxj5470.ktnl.util.extensions.*

/**
 * `?` is in ASCII
 * `：` is in Chinese Character for illegality of `:`
 * but you can try `!`
 *
 *
 * @date 2017/11/17
 */
fun main(args: Array<String>) {
    var s=(1<2) `?` 123 `!` 233
    println(s)

    (2<3)`?`{ println(23333)}`!`{ println(45666)}

//  DSL:

//    '?' { println("???")}
//    ':' { println(":::")}

}