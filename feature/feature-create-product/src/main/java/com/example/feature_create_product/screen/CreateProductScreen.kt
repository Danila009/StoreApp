package com.example.feature_create_product.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.core_ui.theme.JetHabitTheme
import com.example.feature_create_product.enums.PagerProductState
import com.example.feature_create_product.veiw.AddFile
import com.example.feature_create_product.veiw.AddIcon
import com.example.feature_create_product.veiw.AddImages
import com.example.feature_create_product.veiw.AddVideo
import com.example.feature_create_product.veiw.CreateProduct
import com.example.feature_create_product.viewModel.CreateProductViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
internal fun CreateProductScreen(
    viewModel:CreateProductViewModel,
    onBackClick:() -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val pagerState = rememberPagerState()

    var productId by remember { mutableStateOf(0) }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                elevation = 8.dp,
                backgroundColor = JetHabitTheme.colors.primaryBackground,
                title = {
                    Text(
                        text = when(pagerState.currentPage){
                            PagerProductState.CREATE_PRODUCT.ordinal -> "Create product"
                            PagerProductState.ADD_FILE.ordinal -> "Add file"
                            PagerProductState.ADD_ICON.ordinal -> "Add icon"
                            PagerProductState.ADD_IMAGES.ordinal -> "Add images"
                            PagerProductState.ADD_VIDEO.ordinal -> "Add video"
                            else -> ""
                        },
                        color = JetHabitTheme.colors.primaryText
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = null,
                            tint = JetHabitTheme.colors.tintColor
                        )
                    }
                }
            )
        },
        content = {
            HorizontalPager(
                count = PagerProductState.values().size,
                state = pagerState,
                userScrollEnabled = false
            ) { pager ->
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = JetHabitTheme.colors.primaryBackground
                ) {
                    when(pager){
                        PagerProductState.CREATE_PRODUCT.ordinal -> CreateProduct(
                            viewModel = viewModel,
                            pagerState = pagerState,
                            onProductId = { productId = it }
                        )
                        PagerProductState.ADD_FILE.ordinal -> AddFile(
                            pagerState = pagerState,
                            scaffoldState = scaffoldState,
                            viewModel = viewModel,
                            productId = productId
                        )
                        PagerProductState.ADD_ICON.ordinal -> AddIcon()
                        PagerProductState.ADD_IMAGES.ordinal -> AddImages()
                        PagerProductState.ADD_VIDEO.ordinal -> AddVideo()
                    }
                }
            }
        }
    )
}