package com.suisei.replacement.lostcardreport.ui.report

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.suisei.replacement.lostcardreport.ui.app.AppInputForm
import com.suisei.replacement.lostcardreport.ui.app.InputSection
import com.suisei.replacement.lostcardreport.ui.theme.LostCardReportTheme

@Composable
fun InputAcquireDateView() {
    AppInputForm("습득일") {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                InputSection {
                    DateText("YYYY")
                }
                InputSection {
                    DateText("MM")
                }
                InputSection {
                    DateText("DD")
                }
            }

            Icon(Icons.Outlined.CalendarToday, "", modifier = Modifier.size(reportViewIconSize))
        }
    }
}

@Composable
fun DateText(text: String) {
    Text(
        text,
        modifier = Modifier
            .width(80.dp)
            .padding(8.dp),
        fontSize = 20.sp,
        fontWeight = FontWeight.Light,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewInputAcquireDateView() {
    LostCardReportTheme {
        InputAcquireDateView()
    }
}