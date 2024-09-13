package com.example.pokemon_assignmnet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.pokemon_assignmnet.ui.theme.PokemonAssignmnetTheme
import com.example.pokemon_assignmnet.ui.theme.Pokemontransprant
import java.io.File
import java.io.IOException

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            run()

        }
    }
}


@Composable
fun PokemonList(list:List<Pokemon>) {
    LazyColumn {
        items(list.size){
            PokemonCard(pokemon = list[it])
        }
    }
}

@Composable
fun run(){
    val context = LocalContext.current
    val List_Pokemon:MutableList<Pokemon> = mutableListOf()
    try {
        context.assets.open("pokemons_data.csv").bufferedReader().use { reader ->
            reader.forEachLine { line ->
                val tokens = line.split(",")

                    List_Pokemon.add(Pokemon(tokens[0], tokens[1], tokens[2], tokens[3]))

            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }
    PokemonList(List_Pokemon)
}
@Composable
fun PokemonCard(pokemon: Pokemon) {
    ConstraintLayout(
        Modifier
            .padding(11.dp)
            .fillMaxWidth()
            .background(pokemon.setBackgroundColor(), RoundedCornerShape(20.dp))) {
    val (name , type,sp_attack,sp_attack_title,valsp_defense,valsp_defense_title,pokemonImage) = createRefs()
      Text(text = pokemon.Name ?: "UnKonown",
          Modifier
              .padding(20.dp)
              .constrainAs(name) {
                  top.linkTo(parent.top)
                  start.linkTo(parent.start)
              }, fontSize = 20.sp,color=Color.White)
        Text(
            text = pokemon.type ?: "Fire",
            Modifier
                .padding(start = 25.dp)
                .background(color = pokemon.setTypeBackgroundColor(), shape = CircleShape)
                .padding(10.dp)
                .padding(horizontal = 8.dp)
                .constrainAs(type) {
                    top.linkTo(name.bottom)
                    start.linkTo(name.start)

                },
            color = Color.White, fontSize = 16.sp
        )
        Text(text = "Attack:",
            Modifier
                .padding(horizontal = 9.dp)
                .constrainAs(sp_attack_title) {

                    start.linkTo(type.end)
                    top.linkTo(type.top)
                    bottom.linkTo(valsp_defense_title.top)


                }
                .padding(5.dp), fontSize = 16.sp,color=Color.White)

           Text(text ="Defense:" ,
               Modifier
                   .padding(horizontal = 9.dp)
                   .constrainAs(valsp_defense_title) {
                       bottom.linkTo(type.bottom)
                       start.linkTo(type.end)
                       top.linkTo(sp_attack_title.bottom)


                   }
                   .padding(5.dp), fontSize = 16.sp ,color=Color.White)

        Text(text = pokemon.sp_attack ?: "00", Modifier.constrainAs(sp_attack) {
            start.linkTo(sp_attack_title.end)
            top.linkTo(sp_attack_title.top)
            bottom.linkTo(sp_attack_title.bottom)


        })
        Text(text = pokemon.valsp_defense ?: "00", Modifier.constrainAs(valsp_defense) {
            start.linkTo(valsp_defense_title.end)
            top.linkTo(valsp_defense_title.top)
            bottom.linkTo(valsp_defense_title.bottom)


        })
        val context = LocalContext.current
        context.resources
        Image(painter = painterResource(context.resources.getIdentifier(pokemon.Name?.lowercase()?:"e", "drawable", context.packageName)),
            contentDescription = "Pokemon Picture",
            Modifier
                .padding(15.dp)
                .background(color = Pokemontransprant, shape = CircleShape)
                .size(120.dp)
                .constrainAs(pokemonImage) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                })

    }

//    Box(Modifier.fillMaxWidth().background(Color.Red)){
//        Text(text = pokemon.Name)
//
//    }

}

@Preview(showSystemUi = true)
@Composable

fun GreetingPreview() {

run()
}