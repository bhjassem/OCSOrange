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
    private var albums: List<Program>
) : RecyclerView.Adapter<ProgramsListAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_program, parent,
                false
            )
        )

    override fun getItemCount(): Int = albums.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(albums.get(position))

    fun setData(list: List<Program>?) {
        albums = list as ArrayList<Program>
        notifyDataSetChanged()
    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(program: Program) {
            program.title?.let {
                if(it.size>0)
                    itemView.program_title.setText(program.title[0].value?:"")
            }
            Glide.with(itemView.program_img.context)
                .load(Constants.IMAGES_BASE_URL + program.imageurl)
                .into(itemView.program_img)
        }
    }
}