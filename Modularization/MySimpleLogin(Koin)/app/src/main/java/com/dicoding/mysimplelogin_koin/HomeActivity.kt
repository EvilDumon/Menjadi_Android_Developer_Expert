package com.dicoding.mysimplelogin_koin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.core.UserRepository
import com.dicoding.mysimplelogin_koin.databinding.ActivityHomeBinding
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import org.koin.android.ext.android.inject

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val userRepository: UserRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvWelcome.text = "Welcome ${userRepository.getUser()}"

        binding.btnLogout.setOnClickListener {
            userRepository.logoutUser()
            moveToMainActivity()
        }

        binding.fab.setOnClickListener{
            try {
                installChatModule()
            } catch (e:Exception) {
                Toast.makeText(this,"Module not found", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun moveToChatActivity() {
        startActivity(Intent(this, Class.forName("com.dicoding.mysimplelogin_koin.chat.ChatActivity")))
    }

    private fun moveToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun installChatModule() {
        val splitInstallManager = SplitInstallManagerFactory.create(this)
        val moduleChat = "chat"
        if (splitInstallManager.installedModules.contains(moduleChat)) {
            moveToChatActivity()
            Toast.makeText(this, "Open module", Toast.LENGTH_SHORT).show()
        } else {
            val request = SplitInstallRequest.newBuilder()
                .addModule(moduleChat)
                .build()
            splitInstallManager.startInstall(request)
                .addOnSuccessListener {
                    Toast.makeText(this, "Success installing module", Toast.LENGTH_SHORT).show()
                    moveToChatActivity()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Error installing module", Toast.LENGTH_SHORT).show()
                }
        }
    }
}
