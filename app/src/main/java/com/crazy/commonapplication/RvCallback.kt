package com.crazy.commonapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.beyondsoft.smarthome.utils.logs.LogTag
import java.util.*

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: RvCallback
 * Author: zy
 * Date: 2021/11/30 17:37
 * Description:
 * History:

 */
class RvCallback(private val adapter :ViewBindTadapter,private val content: Context): ItemTouchHelper.Callback() {

    private val   dragFlags:Int = ItemTouchHelper.DOWN or ItemTouchHelper.UP
    private val   swipeFlags:Int =  ItemTouchHelper.LEFT or  ItemTouchHelper.RIGHT
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        //同时支持左滑、右滑、拖动
        return makeMovementFlags(dragFlags, swipeFlags)

    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        val fromPosition = viewHolder.adapterPosition
        val toPosition = target.adapterPosition
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(adapter.mDataSet, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(adapter.mDataSet, i, i - 1)
            }
        }
        adapter.notifyItemMoved(fromPosition, toPosition)

        return true

    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val ap = viewHolder.adapterPosition
        if (direction== ItemTouchHelper.LEFT  ||  direction==ItemTouchHelper.RIGHT){
            Toast.makeText(content,"onSwiped$ap",Toast.LENGTH_SHORT).show()
            adapter.mNotifyItemRemoved(position = ap)
        }

    }

    /**
     * 对正在拖动的view 单独着色
     */
    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        super.onSelectedChanged(viewHolder, actionState)
        if(actionState==ItemTouchHelper.ACTION_STATE_DRAG){
            viewHolder?.itemView?.setBackgroundColor(Color.RED)
        }
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)
        viewHolder?.itemView?.setBackgroundColor(0)
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
//        LogTag.d(""+dX+"----"+dY+"----"+actionState+"----"+isCurrentlyActive+"----"+(-dX.toInt()))
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)

    }
}