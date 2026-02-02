package com.example.bussinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardApp()
        }
    }
}

@Composable
fun BusinessCardApp() {

    val background = Color(0xFFDFF5E3)
    val green = Color(0xFF2E7D32)
    val darkBlue = Color(0xFF073042)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background),
        horizontalAlignment = Alignment.CenterHorizontally // Căn giữa toàn bộ nội dung trong cột chính
    ) {

        // Phần trên (Logo + Tên) chiếm khoảng trống còn thừa để đẩy phần contact xuống
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            ProfileSection(green, darkBlue)
        }

        // Phần Contact nằm ở dưới
        ContactSection(green)
    }
}

@Composable
fun ProfileSection(green: Color, darkBlue: Color) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .size(96.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(darkBlue),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(R.drawable.android_logo), // Đảm bảo bạn đã có ảnh này trong res/drawable
                contentDescription = null,
                modifier = Modifier.size(68.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Lưu Thị Hữu Lợi",
            fontSize = 32.sp, // Tăng nhẹ kích thước tên cho nổi bật
            fontWeight = FontWeight.Light // Mỏng hơn một chút cho giống mẫu hiện đại
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 14.sp,
            color = green,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactSection(green: Color) {
    // Column này chứa 3 dòng liên hệ.
    // KHÔNG dùng fillMaxWidth, để nó tự co giãn theo nội dung (dòng email dài nhất).
    // Vì Column cha (BusinessCardApp) đã căn giữa, nên khối này sẽ nằm chính giữa màn hình.
    Column(
        modifier = Modifier.padding(bottom = 50.dp), // Cách đáy màn hình một đoạn
        horizontalAlignment = Alignment.Start // Quan trọng: Để các Icon thẳng hàng bên trái
    ) {

        ContactRow(Icons.Default.Phone, "0846555425", green)
        ContactRow(Icons.Default.Share, "@AndroidDev", green)
        ContactRow(Icons.Default.Email, "loith.24it@vku.udn.vn", green)
    }
}

@Composable
fun ContactRow(
    icon: ImageVector,
    text: String,
    green: Color
) {

    Row(
        modifier = Modifier
            .padding(8.dp), // Padding nhẹ để các dòng không dính sát nhau
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = green,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(24.dp)) // Khoảng cách từ Icon đến chữ

        Text(
            text = text,
            fontSize = 14.sp
        )
    }
}