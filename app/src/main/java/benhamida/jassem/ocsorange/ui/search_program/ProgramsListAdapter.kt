package benhamida.jassem.ocsorange.ui.search_program

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import benhamida.jassem.core.data.Program
import benhamida.jassem.ocsorange.Constants
import benhamida.jassem.ocsorange.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_program.view.*

class ProgramsListAdapter(
    private var programs: List<Program>,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<ProgramsListAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_program, parent,
                false
            )
        )

    override fun getItemCount(): Int = programs.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onClickListener.onItemClickListener(programs.get(position))
        }
        return holder.bind(programs.get(position))
    }

    fun setData(list: List<Program>?) {
        programs = list as ArrayList<Program>
        notifyDataSetChanged()
    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(program: Program) {
            program.title?.let {
                if(!it.isNullOrEmpty())
                    itemView.program_title.setText(program.title[0].value?:"")
            }
            program.subtitle?.let {
                    itemView.program_subtitle.setText(program.subtitle)
            }
            Glide.with(itemView.program_img.context)
                .load(Constants.IMAGES_BASE_URL + program.imageurl)
                .placeholder(R.drawable.default_img)
                .into(itemView.program_img)
        }
    }

    interface OnClickListener {
        fun onItemClickListener(program: Program)
    }
}