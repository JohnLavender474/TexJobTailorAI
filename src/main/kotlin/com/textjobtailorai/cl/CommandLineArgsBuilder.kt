package com.textjobtailorai.cl

import com.beust.jcommander.JCommander
import com.beust.jcommander.ParameterException
import kotlin.system.exitProcess

class CommandLineArgsBuilder {

    fun build(args: Array<String>): CommandLineArgs {
        val clArgs = CommandLineArgs()

        val jCommander = JCommander.newBuilder().addObject(clArgs).build()

        try {
            jCommander.parse(*args)
        } catch (e: ParameterException) {
            System.err.println("Error  while parsing CL args: $e")
            jCommander.usage()
            exitProcess(1)
        }

        return clArgs
    }
}