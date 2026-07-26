package com.example.sciencequiz

import android.Manifest
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var streak = 0
    private var totalQuestions = 0
    private var correctAnswers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        checkNotificationPermission()
        scheduleDailyNotification()
        
        findViewById<Button>(R.id.btnReset).setOnClickListener {
            resetStats()
        }
        
        loadNextQuestion()
        updateStatsUI()
    }

    private fun resetStats() {
        streak = 0
        totalQuestions = 0
        correctAnswers = 0
        updateStatsUI()
        Toast.makeText(this, "Statistik zurückgesetzt", Toast.LENGTH_SHORT).show()
    }

    private fun updateStatsUI() {
        val tvStreak = findViewById<TextView>(R.id.tvStreak)
        val tvAccuracy = findViewById<TextView>(R.id.tvAccuracy)
        
        tvStreak.text = "Streak: $streak"
        
        val accuracy = if (totalQuestions > 0) {
            (correctAnswers.toDouble() / totalQuestions * 100).toInt()
        } else 0
        
        tvAccuracy.text = "Richtig: $accuracy%"
    }

    private fun checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), 101)
            }
        }
    }

    private fun scheduleDailyNotification() {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, QuizReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        // Zeit auf 20:00 Uhr setzen
        val calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, 20)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)

            // Wenn es heute schon nach 20 Uhr ist, plane für morgen
            if (before(Calendar.getInstance())) {
                add(Calendar.DATE, 1)
            }
        }

        // Tägliche Wiederholung
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )
    }

    private fun loadNextQuestion() {
        val tvDiscipline = findViewById<TextView>(R.id.tvDiscipline)
        val tvDiscovery = findViewById<TextView>(R.id.tvDiscovery)
        val buttons = listOf(
            findViewById<Button>(R.id.btnOpt1),
            findViewById<Button>(R.id.btnOpt2),
            findViewById<Button>(R.id.btnOpt3),
            findViewById<Button>(R.id.btnOpt4)
        )

        val correctEntry = ScienceQuizyData.ScienceQuist.random()
        val correctAnswer = correctEntry.person.first()

        val wrongAnswers = ScienceQuizyData.ScienceQuist
            .map { it.person.first() }
            .filter { it != correctAnswer }
            .distinct()
            .shuffled()
            .take(3)

        val allOptions = (wrongAnswers + correctAnswer).shuffled()

        // UI Texte setzen
        tvDiscipline.text = correctEntry.discipline.first().uppercase() // Disziplin in Großbuchstaben
        tvDiscovery.text = correctEntry.discovery.first()

        for (i in buttons.indices) {
            buttons[i].text = allOptions[i]
            buttons[i].setOnClickListener {
                totalQuestions++
                if (buttons[i].text == correctAnswer) {
                    streak++
                    correctAnswers++
                    Toast.makeText(this, "Richtig! 🚀", Toast.LENGTH_SHORT).show()
                } else {
                    streak = 0
                    Toast.makeText(this, "Falsch! Das war $correctAnswer", Toast.LENGTH_SHORT).show()
                }
                updateStatsUI()
                loadNextQuestion()
            }
        }
    }
}