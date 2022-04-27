package benhamida.jassem.ocsorange.ui.program_details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import benhamida.jassem.core.data.ProgramDetails
import benhamida.jassem.ocsorange.framework.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProgramDetailsViewModel @Inject constructor(private val useCases: UseCases) : ViewModel() {

    var programsDetails : MutableLiveData<ProgramDetails?> = MutableLiveData()

    fun getProgramDetails(detailLink: String) {
        GlobalScope.launch(Dispatchers.IO) {
            var pDetails = useCases.getProgramDetails.invoke(detailLink)
            programsDetails?.postValue(pDetails)
        }
    }
}