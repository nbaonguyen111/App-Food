package vn.edu.tdc.demokotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdminAdapter(
    private val foodList: MutableList<outDatacomota>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<AdminAdapter.FoodViewHolder>() {

    interface OnItemClickListener {
        fun onEdit(food: outDatacomota)
        fun onDelete(food: outDatacomota)
    }

    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtFoodName: TextView = itemView.findViewById(R.id.txtFoodName)
        val txtFoodType: TextView = itemView.findViewById(R.id.txtFoodType)
        val txtFoodPrice: TextView = itemView.findViewById(R.id.txtFoodPrice)
        val txtFoodDescription: TextView = itemView.findViewById(R.id.txtFoodDescription)
        val btnEdit: Button = itemView.findViewById(R.id.btnEdit)
        val btnDelete: Button = itemView.findViewById(R.id.btnDelete)

        fun bind(food: outDatacomota) {
            txtFoodName.text = food.tenmon
            txtFoodType.text = food.loaiMon
            txtFoodPrice.text = "Giá: ${food.giatien} VND"
            txtFoodDescription.text = food.mota

            btnEdit.setOnClickListener {
                listener.onEdit(food)
            }

            btnDelete.setOnClickListener {
                listener.onDelete(food)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itemadmin_layout, parent, false)
        return FoodViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foodList[position])
    }

    override fun getItemCount(): Int = foodList.size
}
