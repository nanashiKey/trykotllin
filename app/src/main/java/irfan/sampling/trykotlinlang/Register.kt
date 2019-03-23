package irfan.sampling.trykotlinlang

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.register_activity.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.alert
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class Register : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)

        btn.setOnClickListener {
            val fullname = et_fullname.text.toString().trim()
            val username = et_username.text.toString().trim()
            val password = et_password.text.toString().trim()
            handleRegister(fullname, username, password)
        }
    }

    private fun handleRegister(fullName : String, userName : String, password: String){
        info { "fullname : $fullName , usernmae : $userName, password : $password" }
        when{
            fullName.isEmpty() -> toast("fullname masih kosong")
            userName.isEmpty() -> toast("username masih kosong")
            password.isEmpty() -> toast("password masih kosong")
            else -> alert(title = "Register", message = "Akun baru telah dibuat"){
                positiveButton("OK"){
                    onBackPressed()
                }
                isCancelable = false
            }.show()
        }
    }
}