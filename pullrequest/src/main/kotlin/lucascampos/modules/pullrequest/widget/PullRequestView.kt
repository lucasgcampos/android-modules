package lucascampos.modules.pullrequest.widget

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import lucascampos.modules.base.data.model.PullRequestResponse
import lucascampos.modules.pullrequest.R

class PullRequestView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val title by lazy { findViewById<TextView>(R.id.name) }
    private val description by lazy { findViewById<TextView>(R.id.description) }
    private val username by lazy { findViewById<TextView>(R.id.username) }

    var pullRequest: PullRequestResponse? = null
        set(value) {
            value?.let {
                title.text = it.title
                description.text = it.description
                username.text = it.owner.login
            }
        }

    init { LayoutInflater.from(context).inflate(R.layout.view_pull_request, this, true) }

}