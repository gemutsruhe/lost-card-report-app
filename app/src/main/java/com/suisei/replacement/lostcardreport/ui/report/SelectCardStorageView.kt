package com.suisei.replacement.lostcardreport.ui.report

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.suisei.replacement.lostcardreport.ui.app.AppInputForm
import com.suisei.replacement.lostcardreport.ui.app.InputSection
import com.suisei.replacement.lostcardreport.ui.theme.LostCardReportTheme

@Composable
fun SelectCardStorageView() {
    var address by remember { mutableStateOf("") }
    var businessName by remember { mutableStateOf("") }
    AppInputForm("카드 보관 장소", additional = {
        Icon(Icons.Outlined.Map, "", modifier = Modifier.size(reportViewIconSize))
    }, inputs = listOf({
        InputSection {
            TextField(
                value = address,
                onValueChange = { address = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("주소") },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                )
            )
        }
    }, {
        InputSection {
            TextField(
                value = businessName,
                onValueChange = { businessName = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("상호명") },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                )
            )
        }

    }))
}

@Preview(showBackground = true)
@Composable
fun PreviewSelectCardStorageView() {
    LostCardReportTheme {
        SelectCardStorageView()
    }
}