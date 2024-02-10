package com.example.odnoklassniki_dz2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ImageView
import android.widget.Switch
import androidx.appcompat.widget.SwitchCompat
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var rvStudents: RecyclerView
    lateinit var groupStudInfo: Group
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvStudents = findViewById(R.id.rvStudents)
        groupStudInfo = findViewById(R.id.grpStudInfo)
        var imgvStudent = findViewById(R.id.imgvStudent) as ImageView
        var tilSurname= findViewById(R.id.tilSurname) as TextInputLayout
        var tilName= findViewById(R.id.tilName) as TextInputLayout
        var switchGender= findViewById(R.id.switchGender) as SwitchCompat
        var students = generateSudentsList()
        val studAdapter = StudentsAdapter(students)
        rvStudents.adapter=studAdapter
        rvStudents.layoutManager = LinearLayoutManager(this)
        studAdapter.setOnClickListener(object: StudentsAdapter.OnClickListener {
            override fun onClick(position: Int, student: Student) {
                groupStudInfo.visibility=android.view.View.VISIBLE
                imgvStudent.setImageResource(student.Image)
                tilSurname.editText?.setText(student.Surname)
                tilName.editText?.setText(student.Name)
                switchGender.isChecked = student.sexIsFemale
            }
        })
    }
    private fun generateSudentsList(): MutableList<Student> {
        val studList: MutableList<Student> = ArrayList()
        studList.add(Student(R.drawable.ic_launcher_foreground,"Andrroid","Andrew",false))
        studList.add(Student(R.drawable.ic_launcher_foreground,"Android","Andrina",true))
        studList.add(Student(R.drawable.ic_launcher_foreground,"Andrroid","Andrew",false))
        studList.add(Student(R.drawable.ic_launcher_foreground,"Andrroid","Andrew",false))
        studList.add(Student(R.drawable.ic_launcher_foreground,"Andrroid","Andrew",false))
        studList.add(Student(R.drawable.ic_launcher_foreground,"Andrroid","Andrew",false))
        studList.add(Student(R.drawable.ic_launcher_foreground,"Andrroid","Andrew",false))
        studList.add(Student(R.drawable.ic_launcher_foreground,"Andrroid","Andrew",false))
        studList.add(Student(R.drawable.ic_launcher_foreground,"Andrroid","Andrew",false))
        return studList
    }
}