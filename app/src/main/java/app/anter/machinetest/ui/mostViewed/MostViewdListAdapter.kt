package app.anter.machinetest.ui.mostViewed

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import app.anter.machinetest.R
import app.anter.machinetest.data.model.Result
import app.anter.machinetest.databinding.ItemMostViewedListBinding
import java.util.*

/**
 * A custom adapter to use with the RecyclerView widget.
 */
class MostViewdListAdapter(private val mContext: Context, private var modelList: ArrayList<Result>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mItemClickListener: OnItemClickListener? = null
    fun updateList(modelList: ArrayList<Result>) {
        this.modelList = modelList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemMostViewedListBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.context),
                R.layout.item_most_viewed_list,
                viewGroup,
                false
            )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        //Here you can fill your row view
        if (holder is ViewHolder) {
            val model = getItem(position)
            val genericViewHolder = holder
            genericViewHolder.bind(model)
        }
    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    fun SetOnItemClickListener(mItemClickListener: OnItemClickListener?) {
        this.mItemClickListener = mItemClickListener
    }

    private fun getItem(position: Int): Result {
        return modelList[position]
    }

    interface OnItemClickListener {
        fun onItemClick(view: View?, position: Int, model: Result?)
    }

    inner class ViewHolder(private val binding: ItemMostViewedListBinding) : RecyclerView.ViewHolder(binding.root) {

        init {

            binding.root.setOnClickListener { mItemClickListener!!.onItemClick( 
                binding.root,
                adapterPosition,
                modelList[adapterPosition]) }
        }

        fun bind(model: Result){
            binding.model = model
            binding.executePendingBindings()

        }
    }
}