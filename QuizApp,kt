package com.example.myapplication.ui.theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
data class Question(val text : String, val options : List<String>, val correctAnswer : Int)

val questions = listOf(

    Question(
        text = "What is the capital of India?",
        options = listOf(
            "Mumbai",
            "New Delhi",
            "Kolkata",
            "Chennai"
        ),
        correctAnswer = 1
    ),

    Question(
        text = "Which language is primarily used for Android development?",
        options = listOf(
            "Python",
            "JavaScript",
            "Kotlin",
            "Ruby"
        ),
        correctAnswer = 2
    ),

    Question(
        text = "Which company develops Android?",
        options = listOf(
            "Microsoft",
            "Google",
            "Apple",
            "Meta"
        ),
        correctAnswer = 1
    ),

    Question(
        text = "What does UI stand for?",
        options = listOf(
            "Universal Internet",
            "User Interface",
            "User Internet",
            "Universal Interface"
        ),
        correctAnswer = 1
    ),

    Question(
        text = "Which keyword is used to declare an immutable variable in Kotlin?",
        options = listOf(
            "var",
            "let",
            "const",
            "val"
        ),
        correctAnswer = 3
    )
)

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState);
        setContent()
        {
            MaterialTheme()
            {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background)
                {
                    QuizApp2()
                }
            }
        }
    }
}
@Composable
fun QuizApp2()
{
    var currentQuestion by remember{mutableIntStateOf(0)}
    var selectedAnswer by remember{mutableIntStateOf(-1)}
    var score by remember{mutableIntStateOf(0)}
    var quizFinished by remember{mutableStateOf(false)}
    if(quizFinished == true)
    {
        ResultScreen(score = score, totalQuestions = questions.size,
            onRestart =
                {
                    currentQuestion = 0
                    selectedAnswer = -1
                    score = 0
                    quizFinished = false
                })
    }
    else
    {
        QuizScreen(question = questions[currentQuestion], totalQuestions = questions.size, currentQuestion = currentQuestion + 1, selectedAnswer = selectedAnswer, onAnswerSelected = {answerIndex -> selectedAnswer = answerIndex},
            onNext = {
                if(selectedAnswer == questions[currentQuestion].correctAnswer)
                    score++
                if(currentQuestion < questions.size - 1)
                {
                    currentQuestion++;
                    selectedAnswer = -1;
                }
                else
                {
                    quizFinished = true;
                }
            })
    }
}
@Composable
fun QuizScreen(question : Question, totalQuestions : Int, currentQuestion : Int, selectedAnswer : Int, onAnswerSelected : (Int) -> Unit, onNext : () -> Unit)
{
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp), verticalArrangement = Arrangement.Top)
    {
        Text(text = "Kotlin Quiz.", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "$currentQuestion/$totalQuestions", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(progress = (currentQuestion.toFloat()/totalQuestions), modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(20.dp))
        Card(modifier = Modifier.fillMaxWidth())
        {
            Text(text = question.text, fontSize = 22.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(20.dp))
        }
        Spacer(modifier = Modifier.padding(20.dp))
        question.options.forEachIndexed { index, string ->
            AnswerOption(
                text = string,
                selected = selectedAnswer == index,
                onClick = {onAnswerSelected(index)})
            Spacer(modifier = Modifier.height(20.dp))
        }
        Button(onClick = onNext, enabled = selectedAnswer != -1, modifier = Modifier.fillMaxWidth())
        {
            Text(text = when{
                totalQuestions == currentQuestion -> "Finish quiz."
                else -> "Next question."
            })
        }
    }
}
@Composable
fun AnswerOption(text : String, selected : Boolean, onClick : () -> Unit)
{
    Card(modifier = Modifier
        .fillMaxWidth()
        .selectable(selected = selected, onClick = onClick))
    {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), verticalAlignment = Alignment.CenterVertically)
        {
            RadioButton(selected = selected, onClick = onClick)
            Text(text = text, fontSize = 17.sp, modifier = Modifier.padding(start = 8.dp))
        }
    }
}
@Composable
fun ResultScreen(score : Int, totalQuestions : Int, onRestart : () -> Unit)
{
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = "Quiz Finished.", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Your Score", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "$score/$totalQuestions", fontSize = 48.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = when{
            score == 5 -> "Fucking Perfect!"
            score >= 3 -> "Well Done."
            score <= 1 -> "You failed BOY."
            else-> "Keep practicing."
        }, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = onRestart, modifier = Modifier.fillMaxWidth())
        {
            Text(text = "Restart Quiz")
        }
    }
}
