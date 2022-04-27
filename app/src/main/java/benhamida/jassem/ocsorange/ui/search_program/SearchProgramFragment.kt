package benhamida.jassem.ocsorange.ui.search_program

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import benhamida.jassem.core.data.Program
import benhamida.jassem.ocsorange.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_search_program.*

@AndroidEntryPoint
class SearchProgramFragment : Fragment(), ProgramsListAdapter.OnClickListener {

    private val viewModel: SearchProgramViewModel by viewModels()
    private lateinit var adapter: ProgramsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_program, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObserver()
        search_program_btn.setOnClickListener {
            showProgressBar()
            viewModel.searchProgram(search_program_et.text.toString())
        }
    }

    private fun goToProgramDetails(title: String?, subtitle: String?, fullscreenimageurl: String?, detailLink: String?) {
        val action = SearchProgramFragmentDirections.actionGoToDetails(title, subtitle, fullscreenimageurl, detailLink)
        Navigation.findNavController(programs_list_rv).navigate(action)
    }

    private fun setupUI() {
        programs_list_rv.layoutManager = GridLayoutManager(requireContext(), 2)
        programs_list_rv.setHasFixedSize(true)
        adapter = ProgramsListAdapter(arrayListOf(), this)
        programs_list_rv.adapter = adapter
    }

    private fun setupObserver() {
        viewModel.programsList.observe(this, {
            hideProgressBar()
            adapter.setData(it)
        })
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
        search_program_btn.isEnabled = false
        search_program_et.isEnabled = false
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.INVISIBLE
        search_program_btn.isEnabled = true
        search_program_et.isEnabled = true
    }

    override fun onItemClickListener(program: Program) {
        if (!program.title.isNullOrEmpty()) {
            goToProgramDetails(program.title.get(0).value, program.subtitle, program.fullscreenimageurl, program.detaillink)
        }
    }

}