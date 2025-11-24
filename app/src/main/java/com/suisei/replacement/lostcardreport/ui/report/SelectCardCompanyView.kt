package com.suisei.replacement.lostcardreport.ui.report

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.suisei.replacement.lostcardreport.ui.app.AppInputForm
import com.suisei.replacement.lostcardreport.ui.app.InputSection

@Composable
fun SelectCardCompanyView() {
    var selectedCardCompany by remember { mutableStateOf("카드 회사를 선택해주세요") }
    var dropdownMenuExpanded by remember { mutableStateOf(false) }
    val cardCompanyList = listOf("KB국민은행", "NH농협은행", "우리은행", "신한은행", "하나은행")

    AppInputForm(title = "카드 회사", input = {
        InputSection {
            TextButton(
                onClick = { dropdownMenuExpanded = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(selectedCardCompany)
                    Icon(Icons.Filled.ArrowDropDown, "")
                }
            }
        }

        DropdownMenu(
            expanded = dropdownMenuExpanded, onDismissRequest = { dropdownMenuExpanded = false }) {
            cardCompanyList.forEach {
                DropdownMenuItem(text = { Text(it) }, onClick = {
                    selectedCardCompany = it
                    dropdownMenuExpanded = false
                })
            }
        }
    })
}