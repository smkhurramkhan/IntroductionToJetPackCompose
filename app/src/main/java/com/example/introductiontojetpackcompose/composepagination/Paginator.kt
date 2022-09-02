package com.example.introductiontojetpackcompose.composepagination

interface Paginator<Key,Item> {
    suspend fun loadNextItems()
    fun reset()
}