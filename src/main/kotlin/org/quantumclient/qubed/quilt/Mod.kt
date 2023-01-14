package org.quantumclient.qubed.quilt

import org.quantumclient.qubed.Qubed
import org.quiltmc.loader.api.ModContainer
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer

class Mod : ModInitializer {
    override fun onInitialize(mod: ModContainer?) {
        println("Hello from quilt!")
        Qubed.init()
    }
}