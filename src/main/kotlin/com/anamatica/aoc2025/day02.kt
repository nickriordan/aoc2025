package com.anamatica.aoc2025

fun main() {

    val ranges = loadFile("/day02.txt").split(',').map { r ->
        r.split('-').let { (from, to) -> from.toLong()..to.toLong() }
    }

    fun allSame(strings: List<String>) = strings.distinct().size == 1
    fun sumUp(fn: (Long) -> Boolean): Long = ranges.sumOf { range -> range.filter(fn).sum() }

    fun part1() = sumUp { id -> when (id) {
            in 10..99 -> id / 10 == id % 10
            in 1000..9999 -> id / 100 == id % 100
            in 100000..999999 -> id / 1000 == id % 1000
            in 10000000..99999999 -> id / 10000 == id % 10000
            in 1000000000..9999999999 -> id / 100000 == id % 100000
            in 100000000000..999999999999 -> id / 1000000 == id % 1000000
            in 10000000000000..99999999999999 -> id / 10000000 == id % 10000000
            else -> false
        }
    }

    fun part2() = sumUp { id ->
        id.toString().let { s ->
            (s.length > 1 && allSame(s.chunked(1))) ||
                    (s.length > 3 && allSame(s.chunked(2))) ||
                    (s.length > 5 && allSame(s.chunked(3))) ||
                    (s.length > 7 && allSame(s.chunked(4))) ||
                    (s.length > 9 && allSame(s.chunked(5)))
        }
    }

    println(part1())
    println(part2())
}

