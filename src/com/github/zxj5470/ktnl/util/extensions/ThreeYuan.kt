package com.github.zxj5470.ktnl.util.extensions


/**
 * @from: Kotlinx(wechat)
 * @author: BennyHuo??? , 今天三块钱??? , ice1000???
 * @update: 17-11-7
 *
 * @author: zxj5470
 * @update: 17-11-17
 */

infix fun Boolean.`?`(value: Any) = ThreeYuan(this, value)
infix fun Boolean.`?`(ifBlock: ()->Any) = ThreeYuan(this, ifBlock)

class ThreeYuan(val value: Boolean){
    lateinit var elseValue:Any
    lateinit var ifBlock:()->Any
    constructor(value: Boolean,elseValue:Any):this(value){
        this.elseValue=elseValue
    }
    constructor(value: Boolean,ifBlock:()->Any):this(value){
        this.ifBlock=ifBlock
    }
}

infix fun ThreeYuan.`!`(valueForFalse: Any) = if(value) elseValue else valueForFalse
infix fun ThreeYuan.`!`(elseBlock: ()->Any) = if(value) ifBlock() else elseBlock()

operator infix fun Char.invoke(block:()->Any)=block()