package org.quantumclient.qubed.features.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import net.minecraft.command.CommandBuildContext
import net.minecraft.server.command.CommandManager
import net.minecraft.text.Text
import org.apache.commons.logging.LogFactory
import org.quiltmc.loader.impl.util.log.Log
import org.quiltmc.loader.impl.util.log.LogCategory
import org.quiltmc.qsl.command.api.client.ClientCommandManager

import org.quiltmc.qsl.command.api.client.ClientCommandRegistrationCallback
import org.quiltmc.qsl.command.api.client.QuiltClientCommandSource


object CommandManager {
    private val commands = HashSet<Command>()
        .also { it.add(Test()) }


    fun registerCommand(command: Command) {
        commands.add(command)
    }

    fun load() {
        ClientCommandRegistrationCallback.EVENT.register(object : ClientCommandRegistrationCallback {
            override fun registerCommands(
                dispatcher: CommandDispatcher<QuiltClientCommandSource>?,
                buildContext: CommandBuildContext?,
                environment: CommandManager.RegistrationEnvironment?
            ) {
                val cat = LogCategory("CommandManager")
                commands.forEach {
                    Log.info(cat,"Registering command ${it.name}")
                    dispatcher?.register(it.register())
                }
            }
        })
    }
}