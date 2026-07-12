package com.spensei.app.presentation.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.spensei.app.ui.theme.Ink
import com.spensei.app.ui.theme.Line
import com.spensei.app.ui.theme.Paper
import com.spensei.app.ui.theme.SpenseiTheme
import com.spensei.app.ui.theme.Surface
import com.spensei.app.ui.theme.TextPrimary
import com.spensei.app.ui.theme.TextSecondary

@Composable
fun LoginScreen(
    onSignInClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Paper)
            .padding(horizontal = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(Ink, RoundedCornerShape(18.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text("₹", color = Surface, fontSize = 26.sp, fontWeight = FontWeight.SemiBold)
        }

        Spacer(Modifier.height(24.dp))

        Text(
            text = "Spensei",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = TextPrimary
        )
        Spacer(Modifier.height(6.dp))
        Text(
            text = "Know where every rupee goes.\nSimple, private, offline-first.",
            fontSize = 13.sp,
            color = TextSecondary,
            textAlign = TextAlign.Center,
            lineHeight = 18.sp
        )

        Spacer(Modifier.height(36.dp))

        OutlinedButton(
            onClick = onSignInClick,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = Surface),
            border = androidx.compose.foundation.BorderStroke(1.dp, Line)
        ) {
            Text("Continue with Google", color = TextPrimary, fontWeight = FontWeight.SemiBold, fontSize = 13.sp)
        }

        Spacer(Modifier.height(10.dp))
        Text(
            text = "By continuing you agree to the Privacy Policy",
            fontSize = 9.5.sp,
            color = TextSecondary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    SpenseiTheme {
        LoginScreen()
    }
}
