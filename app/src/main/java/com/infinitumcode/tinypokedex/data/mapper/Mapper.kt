package com.infinitumcode.tinypokedex.data.mapper

interface Mapper<I, O> {
    fun map(from: I): O
    fun mapList(from: List<I>): List<O> = from.mapTo(mutableListOf()) { element -> map(element) }
}