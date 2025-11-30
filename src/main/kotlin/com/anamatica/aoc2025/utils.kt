package com.anamatica.aoc2025

import java.io.InputStreamReader

private val lineSplitRegex = "[\\s,]+".toRegex()

fun loadFile(fileName: String): String =
    object {}.javaClass.getResourceAsStream(fileName).let { InputStreamReader(it!!).readText() }

fun loadFileAsLines(fileName: String): Sequence<String> =
    object {}.javaClass.getResourceAsStream(fileName).let { InputStreamReader(it!!).readLines().asSequence() }

fun loadFileSplitLine(fileName: String) = loadFileAsLines(fileName).map { line -> line.split(lineSplitRegex) }

fun loadFileLinesOfIntegers(fileName: String) = loadFileSplitLine(fileName).map { line -> line.map { it.toInt()} }