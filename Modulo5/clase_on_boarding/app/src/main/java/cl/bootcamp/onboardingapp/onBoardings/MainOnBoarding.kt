package cl.bootcamp.onboardingapp.onBoardings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cl.bootcamp.onboardingapp.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainOnBoarding(
    modifier: Modifier
) {
    val items = ArrayList<PageData>()

    items.add(
        PageData(
            R.raw.hola_android,
            "Hola Mundo!",
            "Esta es la primera page de nuestro onBoarding"
        )
    )

    items.add(
        PageData(
            R.raw.page2,
            "Page 2!",
            "Esta es la segunda page de nuestro onBoarding"
        )
    )

    items.add(
        PageData(
            R.raw.finish,
            "FINISH!!",
            "Esta es la tercera page de nuestro onBoarding"
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )

    OnBoardingPager(
        item = items,
        pagerState = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
    )
}