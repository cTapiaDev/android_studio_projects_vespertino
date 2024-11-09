package cl.bootcamp.geminiapp.viewModel

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import cl.bootcamp.geminiapp.BuildConfig
import cl.bootcamp.geminiapp.model.ChatModel
import cl.bootcamp.geminiapp.model.MessageModel
import cl.bootcamp.geminiapp.room.AppDatabase
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GeminiViewModel(application: Application): AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "chat_bot"
    ).build()

    private val generativeModel = GenerativeModel(
        modelName = "gemini-1.5-flash",
        apiKey = BuildConfig.apiKey
    )

    private val chat by lazy {
        generativeModel.startChat()
    }

    val messageList by lazy {
        mutableStateListOf<MessageModel>()
    }

    // Room
    fun sendMessage(question: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                messageList.add(MessageModel(question, role = "user"))
                val response = chat.sendMessage(question)
                messageList.add(MessageModel(response.text.toString(), role = "model"))

                val chatDao = db.chatDao()
                chatDao.insertChat(item = ChatModel(chat = question, role = "user"))
                chatDao.insertChat(item = ChatModel(chat = response.text.toString(), role = "model"))
            } catch(e:Exception) {
                messageList.add(MessageModel("Error en la conversación: ${e.message}", role = "model"))
            }
        }
    }

    fun loadChat() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val chatDao = db.chatDao()
                val savedChat = chatDao.getChat()
                messageList.clear()
                for (chat in savedChat) {
                    messageList.add(MessageModel(message = chat.chat, role = chat.role))
                }
            } catch(e:Exception) {
                messageList.add(MessageModel("Error en la carga del chat: ${e.message}", role = "model"))
            }
        }
    }

    fun deleteChat() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val chatDao = db.chatDao()
                chatDao.deleteChat()
                messageList.clear()
            } catch(e:Exception) {
                messageList.add(MessageModel("Error al borrar el chat: ${e.message}", role = "model"))
            }
        }
    }

}