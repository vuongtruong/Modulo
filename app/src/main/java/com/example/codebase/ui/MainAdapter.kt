package com.example.codebase.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.codebase.R
import com.example.codebase.data.model.Device
import com.example.codebase.util.ProductType
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.item_layout.view.*
import java.util.*

class MainAdapter(
    private val context: Context,
    private val devices: ArrayList<Device>,
    private val iDeviceCallback: IDeviceCallback
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewDeviceName: TextView = itemView.findViewById(R.id.textViewDeviceName)
        var textViewProductType: TextView = itemView.findViewById(R.id.textViewProductType)
        var removeItemBtn: ImageButton = itemView.findViewById(R.id.removeItemBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = devices.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.textViewDeviceName.text = devices[position].deviceName
        holder.textViewProductType.text = devices[position].productType
        holder.removeItemBtn.setOnClickListener() {
            Toast.makeText(context, "remove id: " + devices[position].id, Toast.LENGTH_SHORT).show()
//            removeItem(position)
//            notifyDataSetChanged()
            iDeviceCallback.onItemClick(position, devices[position])
            notifyDataSetChanged()
        }
        holder.itemView.setOnClickListener() {
            //TODO start activity
            Toast.makeText(context, "item id: " + devices[position].id, Toast.LENGTH_SHORT).show()

        }
    }

    fun addData(list: List<Device>) {
        if (devices.size != 0) {
            devices.clear()
        }
        devices.addAll(list)
        notifyDataSetChanged()
    }

    fun devicesFilter(deviceList: List<Device>, productType: ProductType) {
        if (productType == ProductType.All) {
            addData(deviceList)
        } else {
            val devicesFilter: List<Device> =
                deviceList.filter { s -> s.productType == productType.name }
            addData(devicesFilter)
        }
    }

    fun removeItem(pos: Int) {
        devices.removeAt(pos)
        notifyItemRemoved(pos)
    }

}