package lucascampos.modules.pullrequest.feature

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import lucascampos.modules.base.data.model.PullRequestResponse
import lucascampos.modules.pullrequest.widget.PullRequestView

class PullRequestAdapter(
        private val pullRequests: List<PullRequestResponse>
) : RecyclerView.Adapter<PullRequestAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) =
            ViewHolder(PullRequestView(parent.context))

    override fun getItemCount() = pullRequests.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(pullRequests[position])
    }

    class ViewHolder(private val view: PullRequestView) : RecyclerView.ViewHolder(view) {

        fun bindView(pullRequestResponse: PullRequestResponse) {
            view.pullRequest = pullRequestResponse
        }

    }

}