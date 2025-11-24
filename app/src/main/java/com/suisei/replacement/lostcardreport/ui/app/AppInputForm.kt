package com.suisei.replacement.lostcardreport.ui.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppInputForm(
    title: String,
    additional: @Composable () -> Unit = { },
    inputs: List<@Composable () -> Unit>? = null,
    input: @Composable (() -> Unit)? = null
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(title, fontSize = 18.sp)
                additional()
            }

            if (input != null || !inputs.isNullOrEmpty()) Spacer(modifier = Modifier.height(8.dp))
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                if (input != null) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        input()
                    }
                }

                inputs?.forEach { input ->
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        input()
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppInputForm() {
    AppInputForm("Test")
}