package com.example.ets_ppb.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ets_ppb.R
import com.example.ets_ppb.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController){
    var email by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(
            id = R.drawable.icon_cititrans),
            contentDescription = "Brand image",
            modifier = Modifier.size(200.dp))

        Text(
            text = "Login to your account",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text(text = "Email address")
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFC4B255),
                unfocusedBorderColor = Color(0xFFC4B255),
            ),
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text(text = "Password")
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFC4B255),
                unfocusedBorderColor = Color(0xFFC4B255),
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                Log.i("LoginPassword", "Email: $email | Password: $password")
                navController.navigate(Screen.BookingScreen.withArgs(email))
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 16.dp)
                .height(48.dp),
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFC4B255))
        ) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .padding(end = 8.dp),
                color = Color(0xFFC4B255)
            )
            Text(
                text = "OR",
                modifier = Modifier.padding(horizontal = 8.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFC4B255)
            )
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp)
                    .padding(start = 8.dp),
                color = Color(0xFFC4B255)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_google),
                contentDescription = "Facebook Login",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        // Facebook clicked
                        Log.i("LoginGoogle", "Using Google login")
                    }
            )

            Image(
                painter = painterResource(id = R.drawable.icon_facebook),
                contentDescription = "Github Login",
                modifier = Modifier
                    .size(60.dp)
                    .clickable {
                        // Github clicked
                        Log.i("LoginFacebook", "Using Facebook login")
                    }
            )
        }
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Register",
            fontWeight = FontWeight.Bold,
            color = Color(0xFFC4B255),
            modifier = Modifier.clickable {
                Log.i("Register", "Register clicked")
                navController.navigate(Screen.RegisterScreen.route)
            }
        )
    }
}