package com.fadhlyaulia.restapi3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.fadhlyaulia.restapi3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateActivity : AppCompatActivity() {
    lateinit var btnSubmit:Button
    lateinit var btnCancel:Button
    lateinit var etName: EditText
    lateinit var etNumber: EditText
    lateinit var etAddress: EditText
    lateinit var valName: String
    lateinit var valNumber: String
    lateinit var valAddress: String
    lateinit var valId: String
    lateinit var apiService: ServiceInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        getMyData()
        declaration()
        myfunction()
    }
    fun declaration(){
        btnSubmit = findViewById(R.id.btn_up_submit)
        btnCancel = findViewById(R.id.btn_up_cancel)
        etName = findViewById(R.id.et_up_name)
        etNumber = findViewById(R.id.et_up_number)
        etAddress = findViewById(R.id.et_up_address)
        apiService = Repository.getDataAPI().create(ServiceInterface::class.java)
    }
    fun getMyData(){
        val myValue = intent.extras
        if (myValue!=null){
            valName = myValue.getString("nama").toString()
            valNumber = myValue.getString("no_hp").toString()
            valAddress = myValue.getString("alamat").toString()
            valId = myValue.getString("id").toString()
        }
    }
    fun myfunction(){
        etName.setText(valName)
        etNumber.setText(valNumber)
        val pindah = Intent(this, MainActivity::class.java)
        btnSubmit.setOnClickListener {
            apiService.updateKontak(valId.toInt(), etName.text.toString(), etNumber.text.toString(), etAddress.text.toString()).enqueue(object : Callback<KontakData>{
                override fun onResponse(call: Call<KontakData>, response: Response<KontakData>) {
                    startActivity(pindah)
                    Toast.makeText(baseContext, "Update Data Success", Toast.LENGTH_SHORT).show()
                }
                override fun onFailure(call: Call<KontakData>, t: Throwable) {
                    Toast.makeText(baseContext, "Update Data Failed", Toast.LENGTH_SHORT).show()
                }

            })
        }
        btnCancel.setOnClickListener {
            startActivity(pindah)
        }
    }
}
