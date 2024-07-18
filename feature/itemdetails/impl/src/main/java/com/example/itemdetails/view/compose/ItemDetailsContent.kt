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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.itemdetails.R
import com.example.itemdetails.view.model.ItemDetailsUiState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemDetailsContent(uiState: ItemDetailsUiState.Content) {
    val item = uiState.item

    val pagerState = rememberPagerState(pageCount = { item.additionalImages.size + 1 })

    Column {
        Text(
            stringResource(R.string.item_details_item_id_template, item.objectID),
            modifier = Modifier.padding(16.dp).clearAndSetSemantics {  },
        )
        HorizontalPager(
            state = pagerState,
            pageSpacing = 8.dp,
            modifier = Modifier.clearAndSetSemantics {  },
        ) {
            if (it == 0) {
                AsyncImage(
                    model = item.primaryImage,
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    placeholder = painterResource(id = R.drawable.ic_image_loading),
                    error = painterResource(id = R.drawable.ic_image_error),
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxWidth(),
                )
            } else if (it >= 1) {
                AsyncImage(
                    model = item.additionalImages[it - 1],
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    placeholder = painterResource(id = R.drawable.ic_image_loading),
                    error = painterResource(id = R.drawable.ic_image_error),
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
            TextIfAvailable(stringResource(R.string.item_details_title), item.title)
            TextIfAvailable(stringResource(R.string.item_details_department), item.department)
            TextIfAvailable(stringResource(R.string.item_details_culture), item.culture)
            TextIfAvailable(stringResource(R.string.item_details_period), item.period)
            TextIfAvailable(stringResource(R.string.item_details_dynasty), item.dynasty)
            TextIfAvailable(stringResource(R.string.item_details_reign), item.reign)
            TextIfAvailable(stringResource(R.string.item_details_portfolio), item.portfolio)
            TextIfAvailable(stringResource(R.string.item_details_city), item.city)
            TextIfAvailable(stringResource(R.string.item_details_state), item.state)
            TextIfAvailable(stringResource(R.string.item_details_county), item.county)
            TextIfAvailable(stringResource(R.string.item_details_country), item.country)
            TextIfAvailable(stringResource(R.string.item_details_region), item.region)
            TextIfAvailable(stringResource(R.string.item_details_subregion), item.subregion)
            TextIfAvailable(stringResource(R.string.item_details_locale), item.locale)
        }
    }
}

@Composable
private fun TextIfAvailable(category: String, value: String) {
    if (value.isNotBlank()) {
        Text("$category: $value")
    }
}