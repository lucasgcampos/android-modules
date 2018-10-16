package lucascampos.modules.repository.widget

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import lucascampos.modules.base.data.model.Repository
import lucascampos.modules.repository.R

class RepositoryView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val name by lazy { findViewById<TextView>(R.id.name) }
    private val description by lazy { findViewById<TextView>(R.id.description) }
    private val forks by lazy { findViewById<TextView>(R.id.forks) }
    private val stars by lazy { findViewById<TextView>(R.id.stars) }

    var repository: Repository? = null
        set(value) {
            value?.let {
                name.text = it.name
                description.text = it.description
                forks.text = it.forks.toString()
                stars.text = it.stars.toString()
            }
        }

    init { LayoutInflater.from(context).inflate(R.layout.view_repository, this, true) }

}