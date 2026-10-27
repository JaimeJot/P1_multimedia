
package com.example.p1_tarjetapresentacion_juan_jaime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BusinessCardScreen()
        }
    }
}

@Composable
fun BusinessCardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.dark_bg))
    ) {

        // Sección superior: logo, nombre y puesto
        Column(
            modifier = Modifier
                .weight(3f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.jjlogo),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )

            Text(
                text = stringResource(R.string.full_name),
                fontSize = 40.sp,
                color = colorResource(R.color.red_500),
                textAlign = TextAlign.Center
            )

            Text(
                text = stringResource(R.string.job_title),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.red_500),
                textAlign = TextAlign.Center
            )
        }

        // Sección inferior: datos de contacto
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .widthIn(max = 340.dp)
                    .fillMaxWidth(0.9f),
                verticalArrangement = Arrangement.Center
            ) {
                ContactRow(
                    icono = R.drawable.phone,
                    descripcion = "Teléfono",
                    texto = stringResource(R.string.phone)
                )

                ContactRow(
                    icono = R.drawable.link,
                    descripcion = "Enlace a github",
                    texto = stringResource(R.string.social)
                )

                ContactRow(
                    icono = R.drawable.mail,
                    descripcion = "Correo electrónico",
                    texto = stringResource(R.string.email)
                )
            }
        }
    }
}

@Composable
fun ContactRow(
    icono: Int,
    descripcion: String,
    texto: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.width(100.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Image(
                painter = painterResource(icono),
                contentDescription = descripcion,
                modifier = Modifier.size(24.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Todos los textos empiezan en el mismo punto
        Text(
            text = texto,
            modifier = Modifier.weight(1f),
            fontSize = 18.sp,
            color = colorResource(R.color.grey_700),
            textAlign = TextAlign.Start
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardScreen()
}
