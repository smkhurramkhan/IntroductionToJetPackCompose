package com.example.introductiontojetpackcompose.instaui.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.introductiontojetpackcompose.R
import com.example.introductiontojetpackcompose.instaui.ui.model.ImageWithText
import com.example.introductiontojetpackcompose.instaui.ui.model.StoryHighlight

@Preview
@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize()

    ) {
        TopBar(name = "S M Khurram Khan", modifier = Modifier.padding(16.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        HighlightSection(
            highlights = listOf(
                StoryHighlight(
                    image = painterResource(id = R.drawable.ic_profile),
                    text = "Youtube"
                ),
                StoryHighlight(
                    image = painterResource(id = R.drawable.ic_profile),
                    text = "Q&A"
                ),

                StoryHighlight(
                    image = painterResource(id = R.drawable.ic_profile),
                    text = "Discord"
                ),

                StoryHighlight(
                    image = painterResource(id = R.drawable.ic_profile),
                    text = "Telegram"
                )
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))

        PostTabView(
            imageWithText = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_baseline_grid_on),
                    text = "Posts"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_vid_on_demand),
                    text = "Reels"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_tv),
                    text = "IGTV"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_profile),
                    text = "Profile"
                ),
            ),
            onTabSelected = {
                selectedTabIndex = it
            }
        )
        when (selectedTabIndex) {
            0 -> {
                PostSection(
                    posts = listOf(
                        painterResource(id = R.drawable.ragnar),
                        painterResource(id = R.drawable.ragnar),
                        painterResource(id = R.drawable.ragnar3),
                        painterResource(id = R.drawable.ragnar1),
                        painterResource(id = R.drawable.ragnar2),
                        painterResource(id = R.drawable.ragnar1),
                    ),
                    modifier = Modifier.fillMaxWidth()

                )
            }

            1 -> {
                PostSection(
                    posts = listOf(
                        painterResource(id = R.drawable.ragnar1),
                        painterResource(id = R.drawable.ragnar1),
                        painterResource(id = R.drawable.ragnar2),
                        painterResource(id = R.drawable.ragnar1),
                        painterResource(id = R.drawable.ragnar2),
                        painterResource(id = R.drawable.ragnar3),
                    ),
                    modifier = Modifier.fillMaxWidth()

                )
            }


            2 -> {
                PostSection(
                    posts = listOf(
                        painterResource(id = R.drawable.ragnar2),
                        painterResource(id = R.drawable.ragnar2),
                        painterResource(id = R.drawable.ragnar),
                        painterResource(id = R.drawable.ragnar3),
                        painterResource(id = R.drawable.ragnar),
                        painterResource(id = R.drawable.ragnar1),
                    ),
                    modifier = Modifier.fillMaxWidth()

                )
            }


            3 -> {
                PostSection(
                    posts = listOf(
                        painterResource(id = R.drawable.ragnar3),
                        painterResource(id = R.drawable.ragnar3),
                        painterResource(id = R.drawable.ragnar2),
                        painterResource(id = R.drawable.ragnar1),
                        painterResource(id = R.drawable.ragnar),
                        painterResource(id = R.drawable.ragnar2),
                    ),
                    modifier = Modifier.fillMaxWidth()


                )
            }
        }
    }
}


@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Back",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "Notification",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_more),
            contentDescription = "More",
            tint = Color.Black,
            modifier = Modifier.size(24.dp)
        )

    }
}

@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)

        ) {

            RoundImage(
                image = painterResource(id = R.drawable.ic_profile),
                modifier = Modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }

        Spacer(modifier = Modifier.height(4.dp))

        ProfileDescription(
            displayName = "S M Khurram Khan",
            description = "Programmer \uD83D\uDCBB\t \nEx-Comsian \nOptimist \uD83C\uDF0D\t ",
            url = "https://github.com/smkhurramkhan",
            followedBy = listOf("Najeed Habib", "Syed Waqas", "Sardar Usama "),
            otherCount = 10
        )
    }

}

@Composable
fun RoundImage(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(
                1f,
                matchHeightConstraintsFirst = true
            )
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatSection(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {

        ProfileStats(numberText = "272", text = "Posts")
        ProfileStats(numberText = "211", text = "Followers")
        ProfileStats(numberText = "188", text = "Following")
    }
}


@Composable
fun ProfileStats(
    numberText: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = modifier.height(4.dp))
        Text(text = text)


    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
//    val letterSpacing = 0.5f
    val lineHeight = 20.sp
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            //     letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        Text(
            text = description,
            //   letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        Text(
            text = url,
            color = Color(0xFF3D3D91),
            // letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        if (followedBy.isNotEmpty()) {
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed By ")
                    pushStyle(boldStyle)
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1) {
                            append(", ")
                        }
                    }
                    if (otherCount > 2) {
                        append("and ")
                        pushStyle(boldStyle)
                        append("$otherCount others")
                    }
                },
                //   letterSpacing  = letterSpacing,
                lineHeight = lineHeight
            )
        }

    }
}


@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
) {
    val minWidth = 90.dp
    val minHeight = 30.dp

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {

        ActionButton(
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height = minHeight)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height = minHeight)
        )

        ActionButton(
            text = "Following",
            modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height = minHeight)
        )

        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth)
                .height(height = minHeight)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {
        if (text != null) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }

        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}


@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<StoryHighlight>
) {
    val context = LocalContext.current
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 15.dp)
                    .clickable {
                        Toast
                            .makeText(
                                context,
                                "Clicked at position $it",
                                Toast.LENGTH_LONG
                            )
                            .show()
                    }
            ) {
                RoundImage(
                    image = highlights[it].image,
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    text = highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithText: List<ImageWithText>,
    onTabSelected: (selectedIndex: Int) -> Unit
) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    androidx.compose.material.TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier

    ) {
        imageWithText.forEachIndexed { index, item ->
            Tab(selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == 0) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }

    }
}

@Composable
fun PostSection(
    posts: List<Painter>,
    modifier: Modifier = Modifier
) {
     val mContext = LocalContext.current
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier
            .scale(1.01f)

    ) {
        items(posts.size) {
            Image(
                painter = posts[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
                 .clickable {
                     Toast
                         .makeText(
                             mContext,
                             "image clicked at position $it",
                             Toast.LENGTH_LONG
                         )
                         .show()
                 }
            )
        }
    }
}