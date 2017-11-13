package com.github.zxj5470.ktnl.core

/**
 * @author: zxj5470
 * @date: 17-11-7
 */

import com.github.zxj5470.ktnl.constants.StringConstants
import com.github.zxj5470.ktnl.model.KtnlObject
import com.github.zxj5470.ktnl.util.collections.*
import com.github.zxj5470.ktnl.util.extensions.*
import com.github.zxj5470.ktnl.parser.*
import com.github.zxj5470.ktnl.util.Echoer

val sb = StringBuilder()
val currentStr
    get() = sb.toString()

fun parse(content: String) {

    val charStack = Stack<Char>()
    val statusStack = Stack<Status>()
    val nameList = ArrayList<String>()
    val varsMap = HashMap<String, Any>()

    var currentStatus: Status?
    content.forEach {
        currentStatus = statusStack.peek()

        when {
            it.isLeftBracket -> {
                charStack.push(it)
            }
            it.isWord -> {
                sb.append(it)
                when (currentStr) {
                    StringConstants.DEFINE -> {
                        println("find $currentStr")
                        sb.removeAll()
                        statusStack.push(Status.DEFINING)
                    }
                    StringConstants.SET -> {
                        println("find $currentStr")
                        sb.removeAll()
                        statusStack.push(Status.SETTING)
                    }
                }
            }

            it.isNumeric -> {
                when (currentStatus) {
                    Status.QUOTING, Status.DEFINING, Status.SETTING -> {
                        sb.append(it)
                    }
                    Status.LAMBDA_ING -> {

                    }
                    Status.FUNCTION_ING -> {

                    }
                    else -> {
                    }
                }
            }
        // find " to parse to a string
            it.isQuote -> {
                if (statusStack.peek() != Status.QUOTING) {
                    statusStack.push(Status.QUOTING)
                } else {
                    currentStr.isString = true
                    statusStack.pop()
                }
            }

            it.isSpace -> {
                if (sb.isNotEmpty() || currentStatus == Status.DEFINING || currentStatus == Status.SETTING)
                    nameList.add(currentStr)
                sb.removeAll()
            }


            it.isRightBracket -> {
                if (charStack.isNotEmpty() && charStack.peek()!!.isLeftBracket) {
                    println("match Bracket.")
                    charStack.pop()//pop the `)`

                    if (statusStack.peek() == Status.DEFINING) {
                        statusStack.pop()
                    }
                    if (statusStack.peek() == Status.SETTING) {
                        statusStack.pop()
                        if (varsMap[nameList.last] == null) {
                            Echoer.printUnderLine("set! the undefined `${nameList.last}` ,create it!\n", Echoer.ForeheadColor.WHITE)
                        }
                    }
                    val ktnlObjType =
                            when {
                                currentStr.isString -> "String"
                                currentStr.canBeDouble() -> "Double"
                                currentStr.canBeInt() -> "Int"
                                currentStr.canBeLong() -> "Long"
                                currentStr.canBeBigDecimal() -> "BigDecimal"
                                else -> "String"
                            }
                    varsMap[nameList.last] = KtnlObject(ktnlObjType, currentStr)
                }
                sb.removeAll()
            }
        }
    }
    varsMap.println()

}