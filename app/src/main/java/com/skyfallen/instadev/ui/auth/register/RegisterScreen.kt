package com.skyfallen.instadev.ui.auth.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.skyfallen.instadev.R
import com.skyfallen.instadev.ui.components.InstaButton
import com.skyfallen.instadev.ui.components.InstaText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel = RegisterViewModel()) {
    val uiState by registerViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(topBar = {
        TopAppBar(
            title = {},
            navigationIcon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.background
            )
        )
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.Start
        ) {
            InstaText(
                text = if (uiState.isRegisterWithNumber) stringResource(R.string.register_header_whats_your_number)
                else stringResource(R.string.register_header_whats_your_email),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(Modifier.height(8.dp))
            InstaText(
                text = if (uiState.isRegisterWithNumber) stringResource(R.string.register_text_input_your_contact_number)
                else stringResource(R.string.register_text_input_your_email),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Spacer(Modifier.height(16.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.textFieldValue,
                onValueChange = { registerViewModel.onCellPhoneChanged(it) },
                label = {
                    InstaText(
                        text = if (uiState.isRegisterWithNumber) stringResource(R.string.register_textfield_mobile_number) else stringResource(
                            R.string.register_textfield_email
                        )
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(Modifier.height(8.dp))
            InstaText(
                text = if (uiState.isRegisterWithNumber) stringResource(R.string.register_text_it_can_be_that_you_receive_notifications) else stringResource(
                    R.string.register_text_you_will_receive_emails
                ),
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(Modifier.height(16.dp))
            InstaButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.register_btn_next),
                onClick = {},
                enabled = uiState.isRegisterEnabled
            )
            Spacer(Modifier.height(4.dp))
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { registerViewModel.onChangeRegisterType() },
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
            ) {
                InstaText(
                    text = if (uiState.isRegisterWithNumber) stringResource(R.string.register_btn_register_with_your_email) else stringResource(
                        R.string.register_btn_register_with_your_cellphone
                    ),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.weight(1f))
            InstaText(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = stringResource(R.string.register_text_link_search_my_account),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }

}