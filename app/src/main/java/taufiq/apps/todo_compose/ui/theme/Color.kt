package taufiq.apps.todo_compose.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val lightGray = Color(0XFFFCFCFC)
val MediumGray = Color(0XFF9c9c9c)
val DarkGray = Color(0XFF141414)


val LowPriorityColor = Color(0xFF00C980)
val MediumPriorityColor = Color(0xFFFFC114)
val HighPriorityColor = Color(0xFFFF4646)
val NonePriorityColor = Color(0xFFFFFFFF)

// extension property
val Colors.topAppBarContentColor : Color
@Composable
get() = if (isLight) Color.White else Color.LightGray


val Colors.topAppBarBackgroundColor : Color
@Composable
get() = if (isLight) Purple500 else Color.Black


val Colors.fabBackGroundColor : Color
@Composable
get() = if (isLight) Teal200 else Purple700


