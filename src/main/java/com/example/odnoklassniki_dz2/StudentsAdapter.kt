package com.example.odnoklassniki_dz2

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class StudentsAdapter(studList: MutableList<Student>): RecyclerView.Adapter<StudentsAdapter.StudentHolder>() {

    val studList = studList
    lateinit var onClickListener1: OnClickListener
    interface OnClickListener {
        fun onClick(position: Int, model: Student)
    }
    fun setOnClickListener(onClickListenerParam: OnClickListener) {
        this.onClickListener1 = onClickListenerParam
    }

    override fun getItemCount(): Int {
        return studList.size
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
        var student: Student = studList[position]
        holder.imvStudent.setImageResource(student.Image)
        holder.tvStudent.setText(student.Name + " " + student.Surname)
        holder.layout.setOnClickListener {
            onClickListener1.onClick(position,student)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder{
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.student_item,parent,false)
       // val studHolder = StudentHolder(view)
        return StudentHolder(view)
    }

    class StudentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imvStudent = itemView.findViewById<ImageView>(R.id.rvImvStudent)
        val tvStudent = itemView.findViewById<TextView>(R.id.rvTvStudent)
       val layout = itemView.findViewById<ConstraintLayout>(R.id.rvLayout)
    }
}