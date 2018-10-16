package lucascampos.modules.base.extension

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer

fun <T> LiveData<T>.observe(owner: LifecycleOwner, func: (T) -> Unit) =
        observe(owner, Observer<T> { it?.let { func(it) } })