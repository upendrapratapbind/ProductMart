package com.example.productmart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class HomeAdapter(var context:Context): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
  private var data:ArrayList<Product>?=null
    fun setData(list: ArrayList<Product>){
        data=list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
    return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_rv_item_view,parent,false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
  var item = data?.get(position)
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return data?.size?:0
    }
    class HomeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        lateinit var pImage:ImageView
      lateinit var pTitle:TextView
      lateinit var pDesc:TextView
        lateinit var pCategory:TextView
        lateinit var pRatingRate:RatingBar
        lateinit var pPrice:TextView
        lateinit var pLike:TextView

        fun bindView(item:Product?){
            pImage=itemView.findViewById(R.id.productImage)
            pTitle=itemView.findViewById(R.id.pTitle)
            pDesc=itemView.findViewById(R.id.pDesc)
            pCategory=itemView.findViewById(R.id.pCategory)
            pRatingRate=itemView.findViewById(R.id.pRatingBar)
            pLike=itemView.findViewById(R.id.pLikes)
            pPrice=itemView.findViewById(R.id.pPrice)
            pTitle.text=item?.title
            pDesc.text=item?.description
            pCategory.text=item?.category
            pRatingRate.rating= item?.rating?.rate!!.toFloat()
            pPrice.text=("Rs "+item?.price.toString())
            pLike.text= item.rating.count.toString()
            Glide.with(this.itemView).load(item?.image).override(300, 200).placeholder(R.drawable.shoplogo).error(R.drawable.shoplogo).into(pImage);
        }
    }
}