package benhamida.jassem.ocsorange.ui.program_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import benhamida.jassem.ocsorange.Constants
import benhamida.jassem.ocsorange.R
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_program_details.*

@AndroidEntryPoint
class ProgramDetailsFragment : Fragment() {

    private val viewModel: ProgramDetailsViewModel by viewModels()
    val args: ProgramDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObserver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_program_details, container, false)
    }

    private fun playProgram() {
        //play
    }

    private fun setupUI() {
        program_title.setText(args.title)
        program_subtitle.setText(args.subtitle)
        Glide.with(program_img.context)
            .load(Constants.IMAGES_BASE_URL + args.fullscreenimageurl)
            .placeholder(R.drawable.default_img)
            .into(program_img)
        //Looking for program details
        args.detaillink?.let {
            viewModel.getProgramDetails(it)
        }
    }

    private fun setupObserver() {
        viewModel.programsDetails.observe(this, {
            it?.let {
                if(!it.seasons.isNullOrEmpty()) {
                    program_pitch.setText(it.seasons.get(0).pitch)
                }
            }
        })
    }
}