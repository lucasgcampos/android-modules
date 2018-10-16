package lucascampos.modules.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

abstract class BaseViewModel<T> : ViewModel() {

    val results = MutableLiveData<T>()
    val error = MutableLiveData<Throwable>()

}
