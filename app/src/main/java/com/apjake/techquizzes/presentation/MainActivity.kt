package com.apjake.techquizzes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.Login
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.apjake.techquizzes.presentation.mvvm.event.HomeUiEvent
import com.apjake.techquizzes.presentation.mvvm.model.UserProfileUiModel
import com.apjake.techquizzes.presentation.mvvm.viewmodel.HomeViewModel
import com.apjake.techquizzes.presentation.ui.components.CardView
import com.apjake.techquizzes.presentation.ui.theme.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var viewModel: HomeViewModel

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            viewModel = hiltViewModel()
            val state = viewModel.state.value
            val snackBarHostState = remember{
                SnackbarHostState()
            }

            TechQuizzesTheme {
                LaunchedEffect(key1 = true){
                    viewModel.event.collectLatest { event ->
                        when(event){
                            is HomeUiEvent.ShowErrorSnackBar ->{
                                val snackBarResult = snackBarHostState.showSnackbar(
                                    message = event.message,
                                    actionLabel = "Retry",
                                    duration = SnackbarDuration.Indefinite
                                )
                                when(snackBarResult){
                                    SnackbarResult.Dismissed -> {

                                    }
                                    SnackbarResult.ActionPerformed ->{
                                        viewModel.reload()
                                    }
                                }
                            }
                        }
                    }
                }
                Scaffold(
                    snackbarHost = {
                        SnackbarHost(
                            hostState = snackBarHostState,
                            snackbar = {
                                Snackbar(
                                    snackbarData = it,
                                    contentColor = MaterialTheme.colorScheme.onSurface,
                                    actionColor = MaterialTheme.colorScheme.primaryContainer,
                                    containerColor = MaterialTheme.colorScheme.surface
                                )
                            }
                        )
                    }
                ) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background,
                    ) {

                        LazyColumn(
                            modifier = Modifier.fillMaxSize()
                        ){
                            item {
                                Box {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(200.dp)
                                            .background(MaterialTheme.colorScheme.primary)
                                    )
                                    Column {
                                        HeaderSession(loading = state.profileLoading, profile = state.profile)
                                        Spacer(modifier = Modifier.height(30.dp))
                                        ProfileRankBox(
                                            profile = if(state.profileLoading) null else state.profile
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(SpaceMedium))
                            }
                            items(
                                count = state.quizList.size
                            ){ index ->
                                val quizHeader = state.quizList[index]
                                Spacer(modifier = Modifier.height(SpaceLarge))
                                Text(
                                    text = quizHeader.title,
                                    style = MaterialTheme.typography.displayMedium,
                                    color = MaterialTheme.colorScheme.onBackground,
                                    modifier = Modifier.padding(horizontal = SpaceMedium)
                                )
                                Spacer(modifier = Modifier.height(SpaceLarge))
                                quizHeader.quizzes.forEach { quiz ->
                                    CardView(
                                        modifier = Modifier
                                            .padding(horizontal = SpaceMedium)
                                            .fillMaxWidth(),
                                        shadowElevation = ElevationSmall
                                    ) {
                                        Box(
                                            Modifier
                                                .padding(
                                                    horizontal = SpaceMedium,
                                                    vertical = SpaceMedium
                                                )
                                                .fillMaxSize()
                                        ){
                                            Row(horizontalArrangement = Arrangement.Center) {
                                                NetworkImage(
                                                    image = quiz.posterUrl,
                                                    contentDescription = quiz.title,
                                                    modifier = Modifier
                                                        .width(80.dp)
                                                        .height(80.dp)
                                                )
                                                Spacer(modifier = Modifier.width(SpaceMedium))
                                                Column(verticalArrangement = Arrangement.Center) {
                                                    Text(
                                                        text = quiz.title,
                                                        style = MaterialTheme.typography.displaySmall,
                                                        color = MaterialTheme.colorScheme.onSurface
                                                    )
                                                    Spacer(modifier = Modifier.height(SpaceTiny))
                                                    Text(
                                                        text = "${quiz.totalQuiz} Questions",
                                                        style = MaterialTheme.typography.labelMedium,
                                                        color = MaterialTheme.colorScheme.tertiary
                                                    )
                                                }
                                            }
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(SpaceMedium))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NetworkImage(image: String, contentDescription: String, modifier: Modifier = Modifier){
    CardView(shadowElevation = 0.dp) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(image)
                .crossfade(true)
                .build(),
            contentDescription = contentDescription,
            contentScale = ContentScale.Fit,
            modifier = modifier,
        )
    }
}

@Composable
fun ProfileRankBox(profile: UserProfileUiModel?, modifier: Modifier = Modifier){
    CardView(
        modifier = modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(horizontal = SpaceMedium),
        shadowElevation = ElevationLarge,
    ){
        Box(Modifier.fillMaxSize()) {
            Row {
                Box(Modifier.weight(1f)) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.StarOutline,
                            contentDescription = "Star",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(32.dp)
                        )
                        Text(text = "Points", color = MaterialTheme.colorScheme.tertiary, style = MaterialTheme.typography.labelMedium, modifier = Modifier.padding(vertical = SpaceTiny))
                        Text(text = profile?.points?.toString() ?: "...", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.displayMedium)
                    }
                }
                Divider(
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .padding(vertical = SpaceMedium)
                )
                Box(Modifier.weight(1f)) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Language,
                            contentDescription = "Globe",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(32.dp)
                        )
                        Text(text = "Rank", color = MaterialTheme.colorScheme.tertiary, style = MaterialTheme.typography.labelMedium, modifier = Modifier.padding(vertical = SpaceTiny))
                        Text(text = profile?.rank.let {
                            if(it==null)"..." else "#$it"
                        }, color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.displayMedium)
                    }
                }
            }
        }
    }
}

@Composable
fun LoginHere(modifier: Modifier = Modifier) {
    ElevatedButton(onClick = {}, modifier = modifier) {
        Row {
            Icon(imageVector = Icons.Outlined.Login, contentDescription = "Login Icon")
            Spacer(modifier = Modifier.width(SpaceTiny))
            Text(text = "Please login here")
        }
    }
}

@Composable
fun HeaderSession(
    loading: Boolean,
    profile: UserProfileUiModel?
){
    Box(
        Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = SpaceMedium)) {
        when{
            loading ->{
                CircularProgressIndicator(modifier = Modifier.size(SizeSmall).align(Alignment.Center))
            }
            profile == null ->{
                LoginHere(modifier = Modifier.align(Alignment.CenterStart))
            }
            else ->{
                ProfileHeader(profile = profile, modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

@Composable
fun ProfileHeader(profile: UserProfileUiModel?, modifier: Modifier = Modifier){
    Row(
        modifier.padding(
            top = SpaceMedium,
            start = SpaceMedium,
            end = SpaceMedium,
        ),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(Modifier.weight(1f)) {
            Text(
                text = profile?.name ?: "...",
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            Text(
                text = "Let's take a quiz!",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
        CircleText(text = profile?.shortName?:"??")
    }
}

@Composable
fun CircleText(
    text: String,
    textStyle: TextStyle = MaterialTheme.typography.headlineMedium,
    color: Color = MaterialTheme.colorScheme.surface,
    textColor: Color = MaterialTheme.colorScheme.primary,
    padding: Dp = SpaceMedium
){
    Text(
        text = text,
        modifier = Modifier
            .padding(padding)
            .drawBehind {
                drawCircle(
                    color = color,
                    radius = this.size.maxDimension - 6
                )
            },
        color = textColor,
        style = textStyle
    )
}