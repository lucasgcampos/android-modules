package lucascampos.modules.repository

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import android.widget.ViewFlipper
import lucascampos.modules.base.RetrofitConfig.api
import lucascampos.modules.base.extension.observe
import lucascampos.modules.repository.feature.RepositoryAdapter
import lucascampos.modules.repository.feature.RepositoryViewModel
import lucascampos.modules.repository.feature.RepositoryViewModelFactory

private const val SHOW_CONTENT = 0
private const val SHOW_LOADER = 1

class RepositoryActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders
                .of(this,
                RepositoryViewModelFactory(api!!))
                .get(RepositoryViewModel::class.java)
    }

    private val repositories by lazy { findViewById<RecyclerView>(R.id.repositories) }
    private val viewFlipper by lazy { findViewById<ViewFlipper>(R.id.repository_screen) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)

        viewModel.apply {
            error.observe(this@RepositoryActivity) {
                Toast.makeText(this@RepositoryActivity, "Erros", Toast.LENGTH_SHORT).show()
            }

            results.observe(this@RepositoryActivity) {
                viewFlipper.displayedChild = SHOW_CONTENT

                repositories.adapter = RepositoryAdapter(it)
                repositories.layoutManager = LinearLayoutManager(this@RepositoryActivity)
            }

            viewFlipper.displayedChild = SHOW_LOADER
            getRepositories()
        }
    }

}
