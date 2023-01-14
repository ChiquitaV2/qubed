package org.quantumclient.qubed.features.commands

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.builder.LiteralArgumentBuilder
import com.mojang.brigadier.context.CommandContext
import net.minecraft.command.CommandBuildContext
import net.minecraft.server.command.CommandManager
import net.minecraft.text.Text
import org.quiltmc.qsl.command.api.client.ClientCommandManager
import org.quiltmc.qsl.command.api.client.ClientCommandRegistrationCallback
import org.quiltmc.qsl.command.api.client.QuiltClientCommandSource

class Test:Command("test", "test") {

    override fun register(): LiteralArgumentBuilder<QuiltClientCommandSource> {
        return ClientCommandManager.literal("test")
            .executes(this)
    }

    override fun run(context: CommandContext<QuiltClientCommandSource>?): Int {
        context!!.source.sendFeedback(Text.of("test"))
        return 1
    }
}