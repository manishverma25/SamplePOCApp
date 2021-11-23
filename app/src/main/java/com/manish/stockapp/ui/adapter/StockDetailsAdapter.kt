package com.manish.stockapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.manish.stockapp.R
import com.manish.stockapp.model.StockDetailsModel
import kotlinx.android.synthetic.main.layout_stock_details_item.view.*


class StockDetailsAdapter : RecyclerView.Adapter<StockDetailsAdapter.PicsViewHolder>() {

    inner class PicsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<StockDetailsModel>() {
        override fun areItemsTheSame(oldItem: StockDetailsModel, newItem: StockDetailsModel): Boolean {
            return oldItem.sid == newItem.sid
        }

        override fun areContentsTheSame(oldItem: StockDetailsModel, newItem: StockDetailsModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PicsViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.layout_stock_details_item,
            parent,
            false
        )
    )
    override fun getItemCount() =  differ.currentList.size

    override fun onBindViewHolder(holder: PicsViewHolder, position: Int) {
        val stockDetailItem = differ.currentList[position]
        holder.itemView.apply {
            sidTxt.text = stockDetailItem.sid
            dateTxt.text = stockDetailItem.date
            priceTxt.text = stockDetailItem.price.toString()
        }
    }
}