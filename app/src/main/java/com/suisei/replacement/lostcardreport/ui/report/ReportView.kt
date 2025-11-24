package com.suisei.replacement.lostcardreport.ui.report

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraEnhance
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.suisei.replacement.lostcardreport.ui.app.AppInputForm

val reportViewIconSize = 30.dp

@Composable
fun ReportView(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            Row(modifier = Modifier.fillMaxWidth()) {
                TextButton(onClick = { }, modifier = Modifier.weight(1f)) { Text("취소") }
                TextButton(onClick = { }, modifier = Modifier.weight(1f)) { Text("등록") }
            }
        }) { innerPadding ->
        val padding = innerPadding

        Column {
            AppInputForm(
                "카드 정보 입력",
                additional = {
                    Icon(
                        Icons.Outlined.CameraEnhance,
                        "",
                        modifier = Modifier.size(reportViewIconSize)
                    )
                })

            SelectCardCompanyView()
            InputCardNumberView()
            SelectCardStorageView()
            InputAcquireDateView()
        }

    }
}

@Preview
@Composable
fun PreviewReportView() {
    val navController = rememberNavController()
    ReportView(navController)
}