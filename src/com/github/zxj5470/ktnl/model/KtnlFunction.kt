package com.github.zxj5470.ktnl.model

/**
 * @param name String: the name of Function
 */
data class KtnlFunction(private val name: String,
                        private var params: ArrayList<Map<String, Any>>):KtnlObject(name,params){
    init {
        this.typeName="Function"
    }
}