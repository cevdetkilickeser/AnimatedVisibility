package com.cevdetkilickeser.animatedvisibility.home

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.cevdetkilickeser.animatedvisibility.model.HomeGridItem
import com.cevdetkilickeser.animatedvisibility.model.homeGridItems
import com.cevdetkilickeser.animatedvisibility.ui.theme.AnimatedVisibilityTheme

@Composable
fun HomeList(homeGridItems: List<Any>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(homeGridItems) { item ->
            when (item) {
                is HomeGridItem.NavigateItem -> NavigateItem(item)
                is HomeGridItem.Product -> ProductItem(item)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeListPreview() {
    AnimatedVisibilityTheme {
        HomeList(homeGridItems)
    }
}