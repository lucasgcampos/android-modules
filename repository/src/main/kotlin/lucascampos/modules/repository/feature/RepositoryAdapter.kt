package lucascampos.modules.repository.feature

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import lucascampos.modules.base.data.model.Repository
import lucascampos.modules.repository.widget.RepositoryView

class RepositoryAdapter(
        private val repositories: List<Repository>,
        private val onSelectedItem: (Repository) -> Unit
) : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) =
            ViewHolder(RepositoryView(parent.context), onSelectedItem)

    override fun getItemCount() = repositories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(repositories[position])
    }

    class ViewHolder(
            private val view: RepositoryView,
            private val onSelectedItem: (Repository) -> Unit
    ) : RecyclerView.ViewHolder(view) {

        fun bindView(repository: Repository) {
            view.repository = repository
            view.setOnClickListener { onSelectedItem(repository) }
        }

    }
}