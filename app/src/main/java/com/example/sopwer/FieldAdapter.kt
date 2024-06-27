package com.example.sopwer

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FieldAdapter(private val field: List<Field>): RecyclerView.Adapter<FieldAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val fieldImg : ImageView = itemView.findViewById(R.id.imageField)
        val fieldName : TextView = itemView.findViewById(R.id.namaField)
        val fieldType : TextView = itemView.findViewById(R.id.typeField)
        val fieldPrice : TextView = itemView.findViewById(R.id.hargaSewa)
        val fieldNumber : TextView = itemView.findViewById(R.id.nomorTelepon)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_field, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return field.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentField = field[position]
        holder.fieldImg.setImageResource(currentField.pict)
        holder.fieldName.text = currentField.name
        holder.fieldType.text = currentField.type
        holder.fieldPrice.text = currentField.priceField.toString()
        holder.fieldNumber.text = currentField.numberPhone

        holder.itemView.setOnClickListener {
            when (currentField.type) {
                "Futsal" -> {
                    val intent = Intent(it.context, FutsalFieldDetil::class.java)
                    it.context.startActivity(intent)
                }
                "Basketball" -> {
                    val intent = Intent(it.context, BasketFieldDetail::class.java)
                    it.context.startActivity(intent)
                }
                "Badminton" -> {
                    val intent = Intent(it.context, BadminFieldDetail::class.java)
                    it.context.startActivity(intent)
                }
                else -> {
                    Toast.makeText(it.context, "No page available for ${currentField.type}", Toast.LENGTH_SHORT).show() }
            }
        }
    }
}