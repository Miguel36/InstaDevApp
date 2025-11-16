package com.skyfallen.instadev.ui.auth.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.skyfallen.instadev.R
import com.skyfallen.instadev.ui.components.InstaButton
import com.skyfallen.instadev.ui.components.InstaText

@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel = RegisterViewModel()) {
    val uiState by registerViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.Start
        ) {
            InstaText(
                text = stringResource(R.string.register_header_whats_your_number),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 24.sp,
            )
            Spacer(Modifier.height(8.dp))
            InstaText(
                text = stringResource(R.string.register_text_input_your_contact_number),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 16.sp
            )
            Spacer(Modifier.height(16.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.cellphone,
                onValueChange = { registerViewModel.onCellPhoneChanged(it) },
                label = { InstaText(text = stringResource(R.string.register_textfield_mobile_number)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(Modifier.height(8.dp))
            InstaText(
                text = stringResource(R.string.register_text_it_can_be_that_you_receive_notifications),
                fontSize = 14.sp
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
                onClick = {},
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
            ) {
                InstaText(
                    text = stringResource(R.string.register_btn_register_with_you_email),
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