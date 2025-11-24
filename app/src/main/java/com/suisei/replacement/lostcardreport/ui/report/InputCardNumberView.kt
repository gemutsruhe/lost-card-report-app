package com.suisei.replacement.lostcardreport.ui.report

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.suisei.replacement.lostcardreport.ui.app.AppInputForm
import com.suisei.replacement.lostcardreport.ui.app.InputSection
import com.suisei.replacement.lostcardreport.ui.theme.LostCardReportTheme

@Composable
fun InputCardNumberView() {
    val cardNumberList = remember { mutableStateListOf("", "", "", "") }
    val focusRequesterList = remember {
        mutableStateListOf(
            FocusRequester(),
            FocusRequester(),
            FocusRequester(),
            FocusRequester()
        )
    }
    AppInputForm(title = "카드 번호", input = {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            cardNumberList.forEachIndexed { index, value ->
                InputSection(
                    modifier = Modifier
                        .weight(1f)
                        .focusRequester(focusRequesterList[index])
                ) {
                    CardNumberField(
                        value = cardNumberList[index],
                        onValueChange = { new ->
                            if (new.isNotEmpty() && new.last() < '0' || new.last() > '9')
                                if (new.length <= 4) cardNumberList[index] = new
                            if (new.length == 4 && index < 3) focusRequesterList[index + 1].requestFocus()
                        },
                    )
                }
                if (index < 3) {
                    Icon(
                        Icons.Filled.Remove,
                        "",
                        modifier = Modifier.size(12.dp),
                        tint = Color.Gray
                    )
                }
            }
        }
    })
}

@Composable
fun CardNumberField(value: String, onValueChange: (String) -> Unit, modifier: Modifier = Modifier) {
    TextField(
        value = value,
        onValueChange = { new -> onValueChange(new) },
        modifier = modifier.padding(0.dp),
        textStyle = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Light),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        )
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewInputCardNumberView() {
    LostCardReportTheme { InputCardNumberView() }

}