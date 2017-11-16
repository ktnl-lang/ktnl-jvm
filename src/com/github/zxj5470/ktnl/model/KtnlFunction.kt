package com.github.zxj5470.ktnl.model

/**
 * @param name String: the name of Function
 */
data class KtnlFunction(val name: String,
                        var params: List<Map<String, Any>>
                        ) :
        KtnlObject(name, params,"Function")