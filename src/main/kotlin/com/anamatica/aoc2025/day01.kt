package com.anamatica.aoc2025

fun main() {
    fun rotateLeft(startPos: Int, count: Int) =
        generateSequence((startPos + 99) % 100) { (it + 99) % 100 }.take(count).toList()

    fun rotateRight(startPos: Int, count: Int) =
        generateSequence((startPos + 1) % 100) { (it + 1) % 100 }.take(count).toList()

    fun part1() = loadFileAsLines("/day01.txt").fold((50 to 0)) { (position, countZero), line ->
        val rotateBy = line.drop(1).toInt() % 100

        val newPos = if (line.first() == 'L') {
            rotateLeft(position, rotateBy).last()
        } else {
            rotateRight(position, rotateBy).last()
        }
        (newPos to if (newPos == 0) countZero + 1 else countZero)
    }.second

    fun part2() = loadFileAsLines("/day01.txt").fold((50 to 0)) { (position, countZero), line ->
        val rotateBy = line.drop(1).toInt()

        val list = if (line.first() == 'L') {
            rotateLeft(position, rotateBy)
        } else {
            rotateRight(position, rotateBy)
        }

        list.last() to countZero + (list.count { it == 0 })
    }.second

    println(part1())
    println(part2())
}

