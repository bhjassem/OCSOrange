package benhamida.jassem.ocsorange.ui.search_program

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import benhamida.jassem.core.data.Program
import benhamida.jassem.ocsorange.framework.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchProgramViewModel @Inject constructor(private val useCases: UseCases) : ViewModel() {

    var programsList : MutableLiveData<List<Program>?> = MutableLiveData()

    fun searchProgram(title: String) {
        GlobalScope.launch(Dispatchers.IO) {
            var programs = useCases.searchProgram.invoke("title=$title")
            programsList?.postValue(programs)
        }
    }
}