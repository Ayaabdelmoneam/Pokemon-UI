//package com.example.pokemon_assignmnet
//
//import androidx.compose.ui.platform.LocalContext
//import java.io.File
//import java.io.IOException
//
//fun main() {
//        val context = LocalContext.current
////    context.resources
//    val List_Pokemon:MutableList<Pokemon> = mutableListOf()
//    try {
//        context.assets.open("pokemons_data.csv").bufferedReader().use { reader ->
//            reader.forEachLine { line ->
//                val tokens = line.split(",")
//
//                    List_Pokemon.add(Pokemon(tokens[0], tokens[1], tokens[2], tokens[3]))
//
//            }
//        }
//    } catch (e: IOException) {
//        e.printStackTrace()
//    }
////}