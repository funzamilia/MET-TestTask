package com.example.itemdetails.view.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.itemdetails.R
import com.example.itemdetails.view.TextIfAvailable
import com.example.itemdetails.view.model.ItemDetailsUiState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemDetailsContent(uiState: ItemDetailsUiState.Content) {
    val item = uiState.item

    val pagerState =
        rememberPagerState(pageCount = { item.additionalImages.size + 1 })

    Column {
        Text(
            "Item ID: ${item.objectID}",
            modifier = Modifier.padding(16.dp),
        )
        HorizontalPager(
            state = pagerState,
            pageSpacing = 8.dp,
        ) {
            if (it == 0) {
                AsyncImage(
                    model = item.primaryImage,
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    placeholder = painterResource(id = R.drawable.chrome_dino),
                    error = painterResource(id = R.drawable.chrome_dino),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxWidth(),
                )
            } else if (it >= 1) {
                AsyncImage(
                    model = item.additionalImages[it - 1],
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxWidth(),
                )
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
                .wrapContentHeight(),
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            TextIfAvailable("Title", item.title)
            TextIfAvailable("Department", item.department)
            TextIfAvailable("Culture", item.culture)
            TextIfAvailable("Period", item.period)
            TextIfAvailable("Dynasty", item.dynasty)
            TextIfAvailable("Reign", item.reign)
            TextIfAvailable("Portfolio", item.portfolio)
            TextIfAvailable("City", item.city)
            TextIfAvailable("State", item.state)
            TextIfAvailable("County", item.county)
            TextIfAvailable("Country", item.country)
            TextIfAvailable("Region", item.region)
            TextIfAvailable("Subregion", item.subregion)
            TextIfAvailable("Locale", item.locale)
        }
    }
}