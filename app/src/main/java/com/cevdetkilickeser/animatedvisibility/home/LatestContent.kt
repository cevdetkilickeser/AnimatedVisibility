package com.cevdetkilickeser.animatedvisibility.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cevdetkilickeser.animatedvisibility.R
import com.cevdetkilickeser.animatedvisibility.model.HomeGridItem
import com.cevdetkilickeser.animatedvisibility.model.homeGridItems
import com.cevdetkilickeser.animatedvisibility.ui.theme.AnimatedVisibilityTheme

@Composable
fun LatestContent(
    listState: LazyListState,
    onClickImageCard: () -> Unit
) {
    LazyColumn(
        state = listState,
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .background(color = Color.Transparent)
    ) {
        item {
            Spacer(Modifier.height(16.dp))
            MeasurementCard()
            Spacer(Modifier.height(16.dp))
        }
        item {
            ImageCard(R.drawable.jpg_zero_commission, onClickImageCard)
            Spacer(Modifier.height(16.dp))
        }
        item {
            Campaigns()
            Spacer(Modifier.height(16.dp))
        }
        items(homeGridItems.chunked(2)) { rowItems ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                rowItems.forEach { item ->
                    when (item) {
                        is HomeGridItem.NavigateItem -> {
                            NavigateItem(item = item, modifier = Modifier.weight(1f))
                        }

                        is HomeGridItem.Product -> {
                            ProductItem(item = item, modifier = Modifier.weight(1f))
                        }
                    }
                }
                if (rowItems.size < 2) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LatestContentPreview() {
    AnimatedVisibilityTheme {
        LatestContent(listState = LazyListState(), onClickImageCard = {})
    }
}