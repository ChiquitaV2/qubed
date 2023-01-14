package org.quantumclient.qubed.features.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.builder.LiteralArgumentBuilder
import org.quantumclient.qubed.features.Ifeature
import org.quiltmc.qsl.command.api.client.QuiltClientCommandSource

abstract class Command(override val name: String, override val description: String): Ifeature, com.mojang.brigadier.Command<QuiltClientCommandSource> {

    abstract fun register() : LiteralArgumentBuilder<QuiltClientCommandSource>

}