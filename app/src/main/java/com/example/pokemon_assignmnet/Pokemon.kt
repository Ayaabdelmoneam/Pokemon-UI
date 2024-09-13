package com.example.pokemon_assignmnet

import androidx.compose.ui.graphics.Color
import com.example.pokemon_assignmnet.ui.theme.fireBackground
import com.example.pokemon_assignmnet.ui.theme.fireTypeBackground
import com.example.pokemon_assignmnet.ui.theme.grassBackground
import com.example.pokemon_assignmnet.ui.theme.grassTypeBackground
import com.example.pokemon_assignmnet.ui.theme.waterBackground
import com.example.pokemon_assignmnet.ui.theme.waterTypeBackground

data class Pokemon(
   val Name : String?=null, val type : String?=null, val sp_attack : String?=null, val valsp_defense:String?=null
)
{

   fun setBackgroundColor() : Color {
      when (type) {
         "grass" -> return grassBackground
         "water" -> return waterBackground
         "fire" -> return fireBackground
         else -> return Color.White

      }
   }
      fun setTypeBackgroundColor() : Color {
         when (type) {
            "grass" -> return grassTypeBackground
            "water" -> return waterTypeBackground
            "fire" -> return fireTypeBackground
            else -> return Color.White

         }

      }
//}
//   fun setImage(): Int{
//    val name = Name?:"".lowercase()
//      return R.drawable.
//   }

}


