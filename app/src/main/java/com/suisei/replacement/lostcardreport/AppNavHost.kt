package com.suisei.replacement.lostcardreport

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.suisei.replacement.lostcardreport.ui.report.ReportView
import com.suisei.replacement.lostcardreport.ui.theme.LostCardReportTheme
import kotlinx.serialization.Serializable

@Serializable
object NavMainView

@Serializable
object NavReportView

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    LostCardReportTheme {
        Scaffold { innerPadding ->
            val innerPadding = innerPadding
            Box(modifier = Modifier.padding(8.dp, 40.dp)) {
                NavHost(navController = navController, startDestination = NavReportView) {
                    composable<NavMainView> {
                        MainView(navController)
                    }
                    composable<NavReportView> {
                        ReportView(navController)
                    }
                }
            }
        }
    }
}