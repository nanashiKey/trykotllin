package irfan.sampling.trykotlinlang

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.alert
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
            val username = et_username.text.toString()
            val password = et_password.text.toString()
            handleLogin(username, password)
        }

        tv_newac.setOnClickListener{
            toast("pindah kehalaman register")
        }
    }

    private fun handleLogin(username : String, password : String){
        //membuat log menggunakan anko
        info{"data username : $username , data password : $password"}
        if(username == "test" && password == "test123"){
            toast("Welcome")
        }else{
            alert(title = "Login Gagal", message = "Password atau Username salah"){
                positiveButton(buttonText = "OK"){
                    //tambahkan suatu kegiatan kalau diinginkan
                }
                //set cancelable menjadi false
                isCancelable = false
            }.show()
        }
    }
}
