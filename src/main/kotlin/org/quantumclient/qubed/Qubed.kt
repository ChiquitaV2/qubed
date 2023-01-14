package org.quantumclient.qubed

import org.quantumclient.qubed.features.commands.CommandManager
import org.quiltmc.loader.impl.util.log.Log

object Qubed {


    fun init() {
        CommandManager.load()
    }

}