package com.example.tugas3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class Cat(
    val breed: String,
    val image: Int
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CatList()
        }
    }
}

@Composable
fun CatList() {
    val cats = listOf(
        Cat(
            breed = "Persian",
            image = R.drawable.persian
        ),
        Cat(
            breed = "British Shorthair",
            image = R.drawable.britishshorthair
        ),
        Cat(
            breed = "Ragdoll",
            image = R.drawable.ragdoll
        ),
        Cat(
            breed = "Siamese",
            image = R.drawable.siamese
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F6F2))
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 50.dp,
                bottom = 16.dp
            )
    )
    {

        Text(
            text = "Nama: Fidella Azkia Andini",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "NIM: 245150407111077",
            fontSize = 16.sp
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(cats) { cat ->
                CatCard(cat)
            }
        }
    }
}

@Composable
fun CatCard(cat: Cat) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFE8E1D5))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = cat.image),
            contentDescription = cat.breed,
            modifier = Modifier
                .size(110.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(
            modifier = Modifier.size(14.dp)
        )

        Text(
            text = cat.breed,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3F3B36)
        )
    }
}